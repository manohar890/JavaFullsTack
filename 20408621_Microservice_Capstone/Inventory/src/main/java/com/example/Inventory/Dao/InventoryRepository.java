package com.example.Inventory.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Inventory.Model.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	Optional<Inventory> findByProductId(int id);
}
