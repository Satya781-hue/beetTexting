package com.beetexting.Repo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.beetexting.Entities.TaskEntity;
import com.beetexting.Entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

	@Procedure(name = "getCompletedTasksList")
	List<Map<String,Object>> getCompletedTask();

}
