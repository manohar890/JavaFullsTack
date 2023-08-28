package com.example.Cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Cart.Model.Lineitem;

@Repository
public interface LineItemRepository extends JpaRepository<Lineitem, Integer>{

}
