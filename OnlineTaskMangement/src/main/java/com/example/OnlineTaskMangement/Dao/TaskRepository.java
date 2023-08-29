package com.example.OnlineTaskMangement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineTaskMangement.Entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByTaskIdIn(List<Integer> lis);
}
