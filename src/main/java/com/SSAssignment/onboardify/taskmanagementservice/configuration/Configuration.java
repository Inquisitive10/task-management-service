package com.SSAssignment.onboardify.taskmanagementservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "task-management-service")
public class Configuration {

}