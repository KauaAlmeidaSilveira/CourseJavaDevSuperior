package com.devsuperior.domainModelORM.repositories;

import com.devsuperior.domainModelORM.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
