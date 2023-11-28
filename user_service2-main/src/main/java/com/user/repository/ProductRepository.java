package com.user.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.Product;


@Repository(value="productRepository")
@Scope(value="singleton")
public interface ProductRepository extends JpaRepository<Product,Integer> {
}

