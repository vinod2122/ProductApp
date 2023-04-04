package com.vinod.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinod.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	Optional<Product> findByName(String fileName);

}
