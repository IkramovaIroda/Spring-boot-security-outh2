package com.example.temirovasadbekv2springbootmodul2.repository;

import com.example.temirovasadbekv2springbootmodul2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
