package com.zzrmyy.equ.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zzrmyy.equ.voting.model.User;
import com.zzrmyy.equ.voting.repo.UserRepository;


@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/api/user/allUsers", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<User> getCustomers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/api/user/{id}", method=RequestMethod.GET)
	public User getCustomer(@PathVariable long id){
		return userRepository.findOne(id);
	}
	
	@RequestMapping(value="/api/user/save", method=RequestMethod.POST)
	public void addCustomer(@RequestBody User user){
		userRepository.save(user);
	}
}
