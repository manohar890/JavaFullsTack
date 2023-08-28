package com.shopping.ServiceCommunication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping.DemoModels.CustomerAndOrderMapping;



public interface MapRepository extends JpaRepository<CustomerAndOrderMapping, Integer>{
	
	@Query("select o.orderId from CustomerAndOrderMapping o where customerId=:id")
	List<Integer> findallIds(int id); 

}
