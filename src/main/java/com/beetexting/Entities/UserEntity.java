package com.beetexting.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class UserEntity {
	@Id

	public Long id;

	@Column(name="email")
	private String mailId;

	
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TaskEntity> UserEntity = new ArrayList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public List<TaskEntity> getUserEntity() {
		return UserEntity;
	}


	public void setUserEntity(List<TaskEntity> userEntity) {
		UserEntity = userEntity;
	}




	
	

	
}
