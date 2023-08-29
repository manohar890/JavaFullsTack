package com.example.OnlineTaskMangement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class AssignTask {
	@Id
	private int taskId;
	@Column
	private int empId;
	public AssignTask(int taskId, int empId) {
		super();
		this.taskId = taskId;
		this.empId = empId;
	}
	public AssignTask() {
		// TODO Auto-generated constructor stub
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "AssignTask [taskId=" + taskId + ", empId=" + empId + "]";
	}
	
	

}
