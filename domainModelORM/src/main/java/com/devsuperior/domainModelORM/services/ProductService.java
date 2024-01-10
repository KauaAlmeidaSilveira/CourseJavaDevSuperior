package com.devsuperior.domainModelORM.services;

import com.devsuperior.domainModelORM.DTO.ProductDTO;
import com.devsuperior.domainModelORM.entities.Product;
import com.devsuperior.domainModelORM.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).orElseGet(Product::new);
        return new ProductDTO(product);
    }

}
