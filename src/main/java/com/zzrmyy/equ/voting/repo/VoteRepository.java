package com.zzrmyy.equ.voting.repo;

import org.springframework.data.repository.CrudRepository;

import com.zzrmyy.equ.voting.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long>{
	Vote findById(long id);
}
