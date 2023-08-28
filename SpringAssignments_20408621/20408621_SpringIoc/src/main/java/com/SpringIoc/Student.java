package com.SpringIoc;

import java.util.List;

public class Student {

	private String studentId;
	private String studentName;
	private List<Test> test;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getTest() {
		return test.toString();
	}
	public void setTest(List<Test> test) {
		this.test = test;
	}
	
	public Student(String studentId, String studentName, List<Test> test) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.test = test;
	}
	void show() {
		System.out.println(studentId+" "+studentName+" ");
		for(Test x:test)
		System.out.println(x.getTestId()+" "+x.getTestMarks()+" "+x.getTestName());
		System.out.println("______________________________________________________");
	}
}
