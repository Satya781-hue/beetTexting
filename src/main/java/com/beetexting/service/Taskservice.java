package com.beetexting.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beetexting.Entities.TaskEntity;
import com.beetexting.Entities.UserEntity;
import com.beetexting.Repo.UserRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

@Service
public class Taskservice {

    private static final Logger logger = LoggerFactory.getLogger(Taskservice.class);
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserRepo repo;

    public UserEntity insertData(JSONObject task) {
        logger.info("Received request to insert data: {}", task.toString());

        UserEntity user = new UserEntity();
        try {
            long id = task.getLong("id");
            String mailId = task.getString("email");

            user.setId(id);
            user.setMailId(mailId);

            JSONArray taskList = task.getJSONArray("tasklist");

            for (int j = 0; j < taskList.length(); j++) {
            	
                JSONObject json = taskList.getJSONObject(j);
                TaskEntity entity = new TaskEntity();
                String dueDateStr = json.getString("dueDate").replace("T", " ").substring(0, 19); 
                LocalDateTime dueDate = LocalDateTime.parse(dueDateStr, formatter);
                entity.setDueDate(Timestamp.valueOf(dueDate));
                entity.setDescription(json.getString("description"));
                entity.setDueDate(Timestamp.valueOf(LocalDateTime.now())); // Use proper date handling
                entity.setStatus(json.getString("status"));
                entity.setUserEntity(user);

                user.getUserEntity().add(entity);
            }

            user = repo.save(user);
            logger.info("User data inserted successfully with ID: {}", user.getId());

        } catch (Exception e) {
            logger.error("Error inserting data", e);
        }

        return user;
    }

    public UserEntity updateData(JSONObject task) {
        logger.info("Received request to update data: {}", task.toString());

        try {
            long id = task.getLong("id");
            if (!repo.existsById(id)) {
                logger.warn("User with ID {} not found for update", id);
                return null;
            }

            UserEntity user = repo.findById(id).orElse(null);
            if (user == null) {
                return null;
            }

            user.setMailId(task.getString("email"));

            JSONArray taskList = task.getJSONArray("tasklist");
            user.getUserEntity().clear();  // Clear existing tasks before updating

            for (int j = 0; j < taskList.length(); j++) {
                JSONObject json = taskList.getJSONObject(j);
                TaskEntity entity = new TaskEntity();
                
                entity.setDescription(json.getString("description"));
                String dueDateStr = json.getString("dueDate").replace("T", " ").substring(0, 19); 
                LocalDateTime dueDate = LocalDateTime.parse(dueDateStr, formatter);
                entity.setDueDate(Timestamp.valueOf(dueDate)); // Use proper date handling
                entity.setStatus(json.getString("status"));
                entity.setUserEntity(user);

                user.getUserEntity().add(entity);
            }

            user = repo.save(user);
            logger.info("User data updated successfully with ID: {}", user.getId());

            return user;

        } catch (Exception e) {
            logger.error("Error updating data", e);
            return null;
        }
    }

    public void deleteData(JSONObject task) {
        try {
            long id = task.getLong("id");
            if (!repo.existsById(id)) {
                logger.warn("User with ID {} not found for deletion", id);
                return;
            }

            repo.deleteById(id);
            logger.info("User with ID {} deleted successfully", id);

        } catch (Exception e) {
            logger.error("Error deleting data", e);
        }
    }
}
