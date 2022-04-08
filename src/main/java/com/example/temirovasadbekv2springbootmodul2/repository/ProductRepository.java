package com.example.temirovasadbekv2springbootmodul2.repository;

import com.example.temirovasadbekv2springbootmodul2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}