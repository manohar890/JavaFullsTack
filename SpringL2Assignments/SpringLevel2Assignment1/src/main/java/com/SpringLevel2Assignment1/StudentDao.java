package com.SpringLevel2Assignment1;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	List<StudentData> lis=new ArrayList<StudentData>();
	public void addStudents() {
		lis.add(new StudentData(0,"Kohli","delhi"));
		lis.add(new  StudentData(1,"Sehwag","delhi"));
		lis.add(new StudentData(2,"Yuvraj","Punjab"));
		lis.add(new  StudentData(3,"Rohit","Mumbai"));
		lis.add(new StudentData(4,"Raina","Jharkand"));
		lis.add(new StudentData(5,"Hardik","delhi"));
		lis.add(new StudentData(6,"Krunal","delhi"));
		lis.add(new StudentData(7,"Bumrah","Mumbai"));
		lis.add(new StudentData(8,"Shami","delhi"));
		lis.add(new StudentData(9,"Chahal","delhi"));
	}

	public void getAllDetails() {
		System.out.println("Student Id\t"+"Student Name\t"+"Student Adress\n---------------------------------");
		lis.stream().forEach(d->{System.out.println(d.getStudentId()+"\t\t"+
				d.getStudentName()+"\t\t"+d.getStudentAddress());
		System.out.println("_____________________________________________");});
		System.out.println("***********************************************");
				
	}
	public void getDetails(int id) {
		System.out.println("Student Id\t"+"Student Name\t"+"Student Adress\n---------------------------------");
		lis.stream().filter(d->d.getStudentId()==id).forEach(d->System.out.println(d.getStudentId()+"\t\t"+
		d.getStudentName()+"\t\t"+d.getStudentAddress()+"\n____________________________________"));
	}
}
