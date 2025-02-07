package com.beetexting.AysncService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void performLongRunningTask() {
        logger.info("Long-running task started...");
        try {
            Thread.sleep(10000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        logger.info("Long-running task completed.");
    }
}
