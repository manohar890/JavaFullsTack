package com.example.OnlineTaskMangement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OnlineTaskMangement.Entity.AssignTask;
@Repository
public interface AssignTaskRepository extends JpaRepository<AssignTask, Integer>{
	@Query("select a.taskId from AssignTask a where a.empId=:id")
	List<Integer> findallint(int id);
	
}
