package com.Student.Model;

public class StudentData {
	
	private int studentId;
	private String studentName;
	private int sub1Marks;
	private int sub2marks;
	private int sub3Marks;
	private int avergae;
	private String grade;
	public int getAvergae() {
		return avergae;
	}
	public void setAvergae(int avergae) {
		this.avergae = avergae;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public StudentData(int studentId, String studentName, int sub1Marks, int sub2marks, int sub3Marks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.sub1Marks = sub1Marks;
		this.sub2marks = sub2marks;
		this.sub3Marks = sub3Marks;
	}
	public StudentData() {
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getSub1Marks() {
		return sub1Marks;
	}
	public void setSub1Marks(int sub1Marks) {
		this.sub1Marks = sub1Marks;
	}
	public int getSub2marks() {
		return sub2marks;
	}
	public void setSub2marks(int sub2marks) {
		this.sub2marks = sub2marks;
	}
	public int getSub3Marks() {
		return sub3Marks;
	}
	public void setSub3Marks(int sub3Marks) {
		this.sub3Marks = sub3Marks;
	}
	

}
