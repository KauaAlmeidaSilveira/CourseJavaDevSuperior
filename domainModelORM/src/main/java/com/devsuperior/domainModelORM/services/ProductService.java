package com.devsuperior.domainModelORM.services;

import com.devsuperior.domainModelORM.DTO.ProductDTO;
import com.devsuperior.domainModelORM.entities.Product;
import com.devsuperior.domainModelORM.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> productList = productRepository.findAll(pageable);
        return productList.map(ProductDTO::new);
    }

}
