package com.zzrmyy.equ.voting.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzrmyy.equ.voting.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, Long>{
	List<Entry> findByVotingId(long votingId);
}
