package com.SSAssignment.onboardify.taskmanagementservice.service;

import org.springframework.http.ResponseEntity;

import com.SSAssignment.onboardify.taskmanagementservice.dto.Task;

public interface TaskManagementServiceInterface {

	ResponseEntity<Object> getTaskDetails(String userName, String taskName);

	ResponseEntity<Object> getUserTaskList(String userName);

	ResponseEntity<Object> addTask(Task task);

	ResponseEntity<Object> modifyTask(Task task);

	ResponseEntity<Object> removeTask(long taskId);

}
