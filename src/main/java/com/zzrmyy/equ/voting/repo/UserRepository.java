package com.zzrmyy.equ.voting.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zzrmyy.equ.voting.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByWechatId(String wechatId);
}
