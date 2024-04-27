package com.SSAssignment.onboardify.taskmanagementservice.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="task_id")
	private long taskId;
	
	@Column(name="task_name", nullable = false)
	private String taskName;
	
	@Column(name="task_start_time")
    private LocalDateTime taskStartTime;
	
	@Column(name="task_end_time")
	private LocalDateTime taskEndTime;
	
	@Column(name="task_status", nullable = false)
	private String taskStatus;
	
	@Column(name="task_assignee", nullable = false)
	private String taskAssignee;
	
	@Column(name="task_reporter", nullable = false)
	private String taskReporter;
	
	@Column(name="task_description")
	private String taskDescription;
	
	@Column(name="task_comment")
	private String taskComment;

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public LocalDateTime getTaskStartTime() {
		return taskStartTime;
	}

	public void setTaskStartTime(LocalDateTime taskStartTime) {
		this.taskStartTime = taskStartTime;
	}

	public LocalDateTime getTaskEndTime() {
		return taskEndTime;
	}

	public void setTaskEndTime(LocalDateTime taskEndTime) {
		this.taskEndTime = taskEndTime;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskAssignee() {
		return taskAssignee;
	}

	public void setTaskAssignee(String taskAssignee) {
		this.taskAssignee = taskAssignee;
	}

	public String getTaskReporter() {
		return taskReporter;
	}

	public void setTaskReporter(String taskReporter) {
		this.taskReporter = taskReporter;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}
	
}
