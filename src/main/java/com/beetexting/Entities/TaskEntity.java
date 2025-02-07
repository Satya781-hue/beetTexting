package com.beetexting.Entities;




import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	long Id;
	@Column(name="description")
	public String description;
	
	
	@Column(name="status")
	public String Status;
	
	
	@Column(name = "dueDate")
	private Timestamp dueDate;
	@ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;  
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	
	
	
	

}
