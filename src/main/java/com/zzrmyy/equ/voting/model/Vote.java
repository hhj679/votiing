package com.zzrmyy.equ.voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TVote")
public class Vote {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name="votingtime")
	String votingTime;

	@Column(name="votingtitle")
	String votingTitle;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVotingTime() {
		return votingTime;
	}

	public void setVotingTime(String votingTime) {
		this.votingTime = votingTime;
	}

	public String getVotingTitle() {
		return votingTitle;
	}

	public void setVotingTitle(String votingTitle) {
		this.votingTitle = votingTitle;
	}
}
