package com.SpringL2Assignment;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class StudentDao {
	@Autowired
	 HibernateTemplate template;
	 public void setTemplate(HibernateTemplate template) {
		 this.template=template;
	 }
  
	public void add(StudentData data) {
		template.persist(data);
		System.out.println("Inseted successfully.....");
	}
	
	public void getAllDetails() {
		List<StudentData> data=template.loadAll(StudentData.class);
		System.out.println("Student Id\t"+"Student Name\t"+"Student Adress\n---------------------------------");
		data.stream().forEach(d->{System.out.println(d.getStudentId()+"\t\t"+
				d.getStudentName()+"\t\t"+d.getStudentAddress());
		System.out.println("_____________________________________________");});
		System.out.println("***********************************************");
	}
public void getDetails(int id) {
	StudentData d=template.get(StudentData.class, id);
	System.out.println("Student Id\t"+"Student Name\t"+"Student Adress\n---------------------------------");
	System.out.println(d.getStudentId()+"\t\t"+
	d.getStudentName()+"\t\t"+d.getStudentAddress()+"\n____________________________________");
}
}
