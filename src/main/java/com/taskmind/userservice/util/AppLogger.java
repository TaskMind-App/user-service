package com.taskmind.userservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppLogger {

    private final Logger logger = LoggerFactory.getLogger("TaskMindLogger");

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public void warn(String message) {
        logger.warn(message);
    }
}