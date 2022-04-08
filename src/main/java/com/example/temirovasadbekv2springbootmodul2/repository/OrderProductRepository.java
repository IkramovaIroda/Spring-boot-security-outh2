package com.example.temirovasadbekv2springbootmodul2.repository;

import com.example.temirovasadbekv2springbootmodul2.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
