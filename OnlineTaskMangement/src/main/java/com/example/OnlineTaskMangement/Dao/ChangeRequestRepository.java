package com.example.OnlineTaskMangement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.OnlineTaskMangement.Entity.ChangeRequests;

import jakarta.transaction.Transactional;

public interface ChangeRequestRepository extends JpaRepository<ChangeRequests, Integer>{
	
	List<ChangeRequests> findByEmployeeId(int id);

	@Query("select cr from ChangeRequests cr where cr.status = 'pending'")
	public List<ChangeRequests> findrequests();
	
	@Transactional
	@Query("update ChangeRequests cr set cr.status=:action where cr.taskId=:id")
	@Modifying(clearAutomatically = true)
	public void UpdateStatus(String action,int id);
}


