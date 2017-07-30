package com.zzrmyy.equ.voting.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zzrmyy.equ.voting.model.Entry;
import com.zzrmyy.equ.voting.model.Result;
import com.zzrmyy.equ.voting.model.Vote;
import com.zzrmyy.equ.voting.repo.EntryRepository;
import com.zzrmyy.equ.voting.repo.VoteRepository;


@RestController
public class VoteController {
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	EntryRepository entryRepository;
	
	@Autowired
    @Qualifier("entityManager")
    EntityManager em;
	
	@RequestMapping(value="/api/vote/votes", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Vote> getVoteList(){
		return voteRepository.findAll();
	}
	
	@RequestMapping(value="/api/vote/{id}", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getVoteById(@PathVariable long id){
		Vote vote = voteRepository.findById(id);
		List<Entry> entries = entryRepository.findByVotingId(vote.getId());
		
		JSONObject data = new JSONObject();
		data.put("vote", vote);
		data.put("entries", entries);
//		data.put("voteId", vote.getId());
//		data.put("voteTime", vote.getVotingTime());
//		data.put("voteTitle", vote.getVotingTitle());
//		JSONArray ens = new JSONArray();
//		for(Entry en : entries) {
//			JSONObject data = new JSONObject();
//		}
		
		JSONObject result = new JSONObject();
		result.put("success", true);
		result.put("data", data);
		
		return result;
	}
	
	@RequestMapping(value="/api/vote/save", method=RequestMethod.POST)
	public JSONObject addVote(@RequestBody String sVote){
		JSONObject jVote = JSONObject.parseObject(sVote);
		
		String[] entriesList = jVote.getString("entries").split("\n");
		String votingTime = jVote.getString("time");
		String votingTitle = jVote.getString("title");
		
		Vote vote = new Vote();
		vote.setVotingTime(votingTime);
		vote.setVotingTitle(votingTitle);
		Vote nVote = voteRepository.save(vote);
		
		if(nVote.getId() != null) {
			for(String entgry : entriesList) {
				Entry en = new Entry();
				en.setVotingId(nVote.getId());
				en.setTitle(entgry);
				
				em.persist(en);
			}
			
			em.flush();
			em.clear();
		}
		
		JSONObject result = new JSONObject();
		result.put("success", true);
		result.put("msg", "create vote success!");
		
		return result;
	}
	
	@RequestMapping(value="/api/vote/voting", method=RequestMethod.POST)
	public JSONObject voting(@RequestBody String sVote){
		JSONObject jVote = JSONObject.parseObject(sVote);
		JSONArray jVotes = jVote.getJSONArray("entries");
		for(int i=0; i < jVotes.size(); i++) {
			JSONObject jResult = jVotes.getJSONObject(i);
			Result result = new Result();
			result.setEntryId(jResult.getLong("entryId"));
			result.setResult(jResult.getString("result"));
			result.setUserId(jVote.getLong("userId"));
			result.setVotingId(jVote.getLong("voteId"));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		result.put("msg", "create vote success!");
		
		return result;
	}
}
