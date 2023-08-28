package com.example.Customer.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Customer.Model.ShippingAddress;

@Repository
public interface ShippingAdressRepository extends JpaRepository<ShippingAddress, Integer> {

}
