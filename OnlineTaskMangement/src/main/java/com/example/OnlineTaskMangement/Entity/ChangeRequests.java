package com.example.OnlineTaskMangement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ChangeRequests {
	@Id
	private int taskId;
	
	@Column
	private int employeeId;
	
	@Column
	private String status="pending";

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ChangeRequests(int taskId, int employeeId, String status) {
		super();
		this.taskId = taskId;
		this.employeeId = employeeId;
		this.status = status;
	}

	public ChangeRequests() {
		super();
		// TODO Auto-generated constructor stub
	}
}
