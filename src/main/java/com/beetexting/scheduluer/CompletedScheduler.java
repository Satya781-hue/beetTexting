package com.beetexting.scheduluer;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.beetexting.Repo.UserRepo;
import com.beetexting.Utility.*;

@Component
public class CompletedScheduler {  // Corrected spelling from "Compltedscheduluer"
    private static final Logger logger = LoggerFactory.getLogger(CompletedScheduler.class);

    @Autowired 
    private UserRepo repo;

    @Autowired
    private EmailSender sendMail;  // Ensure sendMail is properly injected

    @Scheduled(cron = "${api.cron}")
    public void parse() {  
        try {
            logger.info("Task Completion Email Scheduler Started");

            List<Map<String, Object>> data = repo.getCompletedTask();

            for (int i = 0; i < data.size(); i++) { 
            	Map<String, Object> data1=data.get(i);
                sendMail.sendTaskCompletionEmail(String.valueOf(data1.get("email")),data1.get("id")); // Ensure correct parameters
            }

            logger.info("Task Completion Email Scheduler Ended");

        } catch (Exception e) {
            logger.error("Error occurred in Task Completion Email Scheduler", e);
        }
    }
}
