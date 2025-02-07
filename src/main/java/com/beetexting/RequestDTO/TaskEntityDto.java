package com.beetexting.RequestDTO;





import org.json.JSONArray;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class TaskEntityDto {
	
	long Id;
	public String description;
	
	
	public String Status;
	
	
	private Timestamp dueDate;
	
	private JSONArray userids=new JSONArray();

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

	public JSONArray getUserids() {
		return userids;
	}

	public void setUserids(JSONArray userids) {
		this.userids = userids;
	}
	
	
	

}
