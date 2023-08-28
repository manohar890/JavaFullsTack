package com.Student.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Student.Dao.StudentDao;
import com.Student.Model.StudentData;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext cfg=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao std=(StudentDao) cfg.getBean("StudentDAO");
		StudentData data=new StudentData();
		data.setStudentId(0);
		data.setStudentName("Manohar");
		data.setSub1Marks(80);
		data.setSub2marks(70);
		data.setSub3Marks(100);
		std.insertStudent(data);   
		std.findById(0);
		std.findall();
		std.UpdateStudent(0, 51, 51, 51);
		std.DeleteStudent(0);
		std.findall();
		
	}

}
