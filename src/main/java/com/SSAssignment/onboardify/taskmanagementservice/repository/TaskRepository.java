package com.SSAssignment.onboardify.taskmanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SSAssignment.onboardify.taskmanagementservice.dto.Task;

import jakarta.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	Task findByTaskAssigneeAndTaskName(String userName, String taskName);

	List<Task> findByTaskAssignee(String userName);

	Task findByTaskId(long taskId);

	@Transactional
	int deleteByTaskId(long taskId);
	
}
