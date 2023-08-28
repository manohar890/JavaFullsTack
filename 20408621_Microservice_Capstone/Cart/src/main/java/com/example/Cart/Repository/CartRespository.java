package com.example.Cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Cart.Model.Cart;

@Repository
public interface CartRespository extends JpaRepository<Cart, Integer> {

}
