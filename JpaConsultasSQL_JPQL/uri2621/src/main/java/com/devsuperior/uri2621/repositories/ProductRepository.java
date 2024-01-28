package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductDTO;
import com.devsuperior.uri2621.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers ON products.id_providers = providers.id " +
            "WHERE providers.name LIKE :startsWith% " +
            "AND products.amount BETWEEN :min AND :max")
    List<ProductProjection> productsSQL(Integer min, Integer max, String startsWith);


    @Query("SELECT new com.devsuperior.uri2621.dto.ProductDTO(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.provider.name LIKE :startsWith% " +
            "AND obj.amount BETWEEN :min AND :max")
    List<ProductDTO> productsJPQL(Integer min, Integer max, String startsWith);
}
