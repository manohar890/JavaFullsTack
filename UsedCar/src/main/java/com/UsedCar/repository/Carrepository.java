package com.UsedCar.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UsedCar.Model.CarModel;

public interface Carrepository extends JpaRepository<CarModel, Integer> {
	
	@Query("select c.brand from CarModel c")
	public Set<String> getbrands();
	public List<CarModel> findByBrand(String brand);
	
	@Query("select c from CarModel c where c.price <= 500000")
	public List<CarModel> lessthanfive();
	
	@Query("select c from CarModel c where c.price >= 500000")
	public List<CarModel> greaterthanfive();
}
