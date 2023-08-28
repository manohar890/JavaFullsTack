package com.example.Order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Order.Model.Lineitem;



@Repository
public interface LineItemRepository extends JpaRepository<Lineitem, Integer>{

}
