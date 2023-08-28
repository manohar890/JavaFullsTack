package com.example.Order.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Order.Model.Orders;


public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	List<Orders> findByOrderIdIn(List<Integer> lis);

}
