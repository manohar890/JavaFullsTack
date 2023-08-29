package com.example.OnlineTaskMangement.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineTaskMangement.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public Optional<Employee> findByEmpName(String name);
}
