package com.Student.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Student.Model.StudentData;

public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbctemplate;

	public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
		// TODO Auto-generated method stub
		this.jdbctemplate=jdbctemplate;
	}

	public void insertStudent(StudentData data) {
		// TODO Auto-generated method stub
		float total=(data.getSub1Marks()+data.getSub2marks()+data.getSub3Marks());
		float avg=(total/3);
		String grade="";
		if(avg>80) {
			grade="A";
		}else if(avg > 70){
			grade="B";
		}else if(avg >60) {
			grade ="C";
			
		}else if(avg>50) {
			grade="D";
			
		}else {
			grade="Fail";
		}
		
		String Sql="insert into Studentinfo(id,name,sub1marks,sub2marks,sub3marks,Average,Grade) values(?,?,?,?,?,?,?)";
		int row=jdbctemplate.update(Sql,data.getStudentId(),data.getStudentName(),data.getSub1Marks(),
				data.getSub2marks(),data.getSub3Marks(),avg,grade);
		if(row>0) {
			System.out.println("Inserted Successfully........");
		}else {
			System.out.println("Failed to insert .....");
		}
		
		
	}

	public void findById(int id) {
		// TODO Auto-generated method stub
		
		String sql ="select * from studentinfo where id = ?";
		StudentData d=jdbctemplate.queryForObject(sql,new Object[]{id},new RowMapper<StudentData>() {

			public StudentData mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				StudentData data=new StudentData();
				data.setStudentId(rs.getInt("id"));
				data.setStudentName(rs.getString("name"));
				data.setSub1Marks(rs.getInt("sub1marks"));
				data.setSub2marks(rs.getInt("sub2marks"));
				data.setSub3Marks(rs.getInt("sub3marks"));
				data.setAvergae(rs.getInt("average"));
				data.setGrade(rs.getString("grade"));
				return data;
			}
			
		});
		System.out.println("studentId\t"+"student Name\t"+"Sub1marks\t"+"Sub2Marks\t"+"Sub3Marks\t"+"Average\t"+"Grade");
		System.out.println(d.getStudentId()+"\t\t"+d.getStudentName()+"\t \t"+
				d.getSub1Marks()+"\t \t"+d.getSub2marks()+"\t \t"+d.getSub3Marks()+" \t\t"+d.getAvergae()+" \t\t"+d.getGrade()
						);
	}

	

	public void DeleteStudent(int id) {
		// TODO Auto-generated method stub
		
		String sql="delete from studentinfo where id =?";
		int row=jdbctemplate.update(sql, id);
		if(row>0)System.out.println("id of "+id+" deleted Succesfully");
		else System.out.println("Failed to delete");
		
	}

	public void findall() {
		// TODO Auto-generated method stub
		String sql="select * from studentinfo";
		List<StudentData> data=jdbctemplate.query(sql, new RowMapper<StudentData>(){

			public StudentData mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				StudentData data=new StudentData();
				data.setStudentId(rs.getInt("id"));
				data.setStudentName(rs.getString("name"));
				data.setSub1Marks(rs.getInt("sub1marks"));
				data.setSub2marks(rs.getInt("sub2marks"));
				data.setSub3Marks(rs.getInt("sub3marks"));
				data.setAvergae(rs.getInt("average"));
				data.setGrade(rs.getString("grade"));
				return data;
			}
			
		});
		System.out.println("studentId\t"+"student Name\t"+"Sub1marks\t"+"Sub2Marks\t"+"Sub3Marks\t"+"Average \t"+"Grade");
		for(StudentData d:data) {
			System.out.println(d.getStudentId()+"\t \t"+d.getStudentName()+"\t \t"+
					d.getSub1Marks()+"\t\t"+d.getSub2marks()+"\t\t "+d.getSub3Marks()+"\t\t"+d.getAvergae()+"\t\t"+d.getGrade()
							);
		}
		
	}

	public void UpdateStudent(int id, int sub1marks, int sub2marks, int sub3marks) {
		// TODO Auto-generated method stub
		float total=(sub1marks+sub2marks+sub3marks);
		float avg=(total/3);
		String grade="";
		if(avg>80) {
			grade="A";
		}else if(avg > 70){
			grade="B";
		}else if(avg >60) {
			grade ="C";
			
		}else if(avg>50) {
			grade="D";
			
		}else {
			grade="F";
		}
		String sql="update studentinfo set sub1marks=?,sub2marks=?,sub3marks=?,average=?,grade=? where id =?";
		int row=jdbctemplate.update(sql, sub1marks,sub2marks,sub3marks,avg,grade,id);
		if(row>0)System.out.println("Data Updated Successfully.......");
		else System.out.println("Failed to update");
	}

}
