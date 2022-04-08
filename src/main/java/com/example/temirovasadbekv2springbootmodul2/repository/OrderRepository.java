package com.example.temirovasadbekv2springbootmodul2.repository;

import com.example.temirovasadbekv2springbootmodul2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
