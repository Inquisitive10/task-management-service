package com.SSAssignment.onboardify.taskmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SSAssignment.onboardify.taskmanagementservice.dto.Task;
import com.SSAssignment.onboardify.taskmanagementservice.service.TaskManagementServiceInterface;

@RestController
@RequestMapping("/task-management-service")
public class TaskManagementController {
	
	@Autowired
	private TaskManagementServiceInterface taskManagementService;
	
	@GetMapping("/user/{userName}/task/{taskName}")
	private ResponseEntity<Object> retrievetaskDetails(@PathVariable String userName, @PathVariable String taskName) {
		 return taskManagementService.getTaskDetails(userName, taskName);
	}
	
	@GetMapping("/user/{userName}/tasks")
	private ResponseEntity<Object> retrieveUsertasks(@PathVariable String userName) {
		 return taskManagementService.getUserTaskList(userName);
	}
	
	@PostMapping("/task")
	private ResponseEntity<Object> saveTask(@RequestBody Task task){
		return taskManagementService.addTask(task);
	}
	
	@PutMapping("/task")
	private ResponseEntity<Object> updateTask(@RequestBody Task task){
		return taskManagementService.modifyTask(task);
	}
	
	@DeleteMapping("/task/{taskId}")
	private ResponseEntity<Object> deleteUsertask(@PathVariable long taskId){
		return taskManagementService.removeTask(taskId);
	}

}
