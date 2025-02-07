package com.beetexting.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beetexting.Entities.TaskEntity;
import com.beetexting.Entities.UserEntity;
import com.beetexting.Repo.UserRepo;
import com.beetexting.service.Taskservice;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class Controller {

    private Taskservice service;

    @Autowired
    Controller(Taskservice service) {
        this.service = service;
    }

    @Autowired
    UserRepo repo;

    @PostMapping("${api.url.insert}")
    public String insertTaskData(@RequestBody String task) {
        service.insertData(new JSONObject(task));
        return "Task data inserted successfully";
    }

    @PostMapping("${api.url.update}")
    public String update(@RequestBody String task) {
        service.updateData(new JSONObject(task));
        return "Task data updated successfully";
    }

    @PostMapping("${api.url.delete}")
    public String delete(@RequestBody String task) {
        service.deleteData(new JSONObject(task));
        return "Task data deleted successfully";
    }

    @GetMapping("${api.url.getData}")

    public List<UserEntity> getData() {
        return repo.findAll();
    }
}