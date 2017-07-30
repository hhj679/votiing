package com.zzrmyy.equ.voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TResult")
public class Result {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name="votingid")
	Long votingId;
	
	@Column(name="entryid")
	Long entryId;
	
	@Column(name="userid")
	Long userId;
	
	@Column(name="result")
	String result;
	
	@Column(name="description")
	String description;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVotingId() {
		return votingId;
	}

	public void setVotingId(Long votingId) {
		this.votingId = votingId;
	}

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
