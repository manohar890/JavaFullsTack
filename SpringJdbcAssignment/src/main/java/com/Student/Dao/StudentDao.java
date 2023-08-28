package com.Student.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Student.Model.StudentData;

public interface StudentDao {
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	public void insertStudent(StudentData data);
	public void findById(int id);
	public void UpdateStudent(int id,int sub1marks,int sub2marks,int sub3marks);
	public void DeleteStudent(int id);
	public void findall();
	

}
