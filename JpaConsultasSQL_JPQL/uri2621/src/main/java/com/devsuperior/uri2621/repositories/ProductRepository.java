package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT products.name from products " +
            "INNER JOIN providers ON products.id_providers = providers.id " +
            "WHERE providers.name LIKE :startsWith% " +
            "AND products.amount >= 10 AND products.amount <= 20")
    List<ProductProjection> productsSQL(String startsWith);

}
