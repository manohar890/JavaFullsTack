package com.example.OnlineTaskMangement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Task_sequence")    
	@SequenceGenerator(name = "Task_sequence", sequenceName = "Task_sequence", initialValue = 10000, allocationSize = 1)
	private int taskId;
	@Column
	private String taskName;
	@Column
	private String description;
	@Column
	private int dueDay;
	public Task(int taskId, String taskName, String description, int dueDay) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
		this.dueDay = dueDay;
	}
	public Task() {
		// TODO Auto-generated constructor stub
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDueDay() {
		return dueDay;
	}
	public void setDueDay(int dueDay) {
		this.dueDay = dueDay;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", dueDay="
				+ dueDay + "]";
	}
	
	

	
//	public Task() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
    
	
	
}
