package com.SSAssignment.onboardify.taskmanagementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SSAssignment.onboardify.taskmanagementservice.dto.Task;
import com.SSAssignment.onboardify.taskmanagementservice.repository.TaskRepository;

@Service
public class TaskManagementServiceImpl implements TaskManagementServiceInterface{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public ResponseEntity<Object> getTaskDetails(String userName, String taskName) {
		Task task = null;
		try {
			task = taskRepository.findByTaskAssigneeAndTaskName(userName,taskName);
		}catch(Exception ex) {}
		if(task!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(task);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Cannot find task " + taskName + " assigned to user " + userName);
		}
	}

	@Override
	public ResponseEntity<Object> getUserTaskList(String userName) {
		List<Task> tasks = null;
		try {
			tasks = taskRepository.findByTaskAssignee(userName);
		}catch(Exception ex) {}
		if(tasks.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No tasks assigned to user " + userName);
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(tasks);
		}
	}

	@Override
	public ResponseEntity<Object> addTask(Task task) {
		Task existingTask = null;
		try {
			existingTask = taskRepository.findByTaskAssigneeAndTaskName(task.getTaskAssignee(),task.getTaskName());
		}catch(Exception ex) {}
		if(existingTask==null) {
			if(task.getTaskName()==null || task.getTaskName() == "")
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Please provide task name");
			if(task.getTaskAssignee()==null || task.getTaskAssignee() == "")
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Please provide task assignee");
			task.setTaskStatus("Active");
			taskRepository.save(task);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("Created task " + task.getTaskName() + " with task id " + task.getTaskId());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Task " + task.getTaskName() + " is already assigned to user " + task.getTaskAssignee());
		}
	}

	@Override
	public ResponseEntity<Object> modifyTask(Task task) {
		Task existingTask = null;
		try {
			existingTask = taskRepository.findByTaskAssigneeAndTaskName(task.getTaskAssignee(),task.getTaskName());
		}catch(Exception ex) {}
		if(existingTask!=null) {
			if(task.getTaskName()==null || task.getTaskName() == "")
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Please provide task name");
			if(task.getTaskAssignee()==null || task.getTaskAssignee() == "")
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Please provide task assignee");
			existingTask.setTaskStatus(task.getTaskStatus());
			existingTask.setTaskComment(task.getTaskComment());
			existingTask.setTaskDescription(task.getTaskDescription());
			existingTask.setTaskStartTime(task.getTaskStartTime());
			existingTask.setTaskEndTime(task.getTaskEndTime());
			taskRepository.save(existingTask);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("Updated task " + existingTask.getTaskName() + " with task id " + existingTask.getTaskId());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Task " + task.getTaskName() + " does not exist in " + task.getTaskAssignee() + "bucket");
		}
	}

	@Override
	public ResponseEntity<Object> removeTask(long taskId) {
		Task task = null;
		try {
			task = taskRepository.findByTaskId(taskId);
		} catch(Exception ex) {}
		if(task == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No task with id " + taskId);
		}
		try{
			taskRepository.deleteByTaskId(taskId);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Deleted task with id " + taskId);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Unable to delete task. Server has encountered a problem");
		}
	}

}
