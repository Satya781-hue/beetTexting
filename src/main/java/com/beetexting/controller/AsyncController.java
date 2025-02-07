package com.beetexting.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beetexting.AysncService.AsyncService;

@RestController
@RequestMapping("/")
public class AsyncController {

    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/startTask")
    public String startAsyncTask() {
        asyncService.performLongRunningTask(); // Run in background
        return "Task started! You will be notified once it's done.";
    }
}
