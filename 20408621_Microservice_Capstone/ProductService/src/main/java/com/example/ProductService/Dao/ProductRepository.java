package com.example.ProductService.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProductService.Model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

}
