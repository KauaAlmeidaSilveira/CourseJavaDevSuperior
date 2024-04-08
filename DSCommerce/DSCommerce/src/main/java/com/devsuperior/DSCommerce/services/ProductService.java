package com.devsuperior.DSCommerce.services;

import com.devsuperior.DSCommerce.DTO.CategoryDTO;
import com.devsuperior.DSCommerce.DTO.ProductDTO;
import com.devsuperior.DSCommerce.DTO.ProductMinDTO;
import com.devsuperior.DSCommerce.entities.Category;
import com.devsuperior.DSCommerce.entities.Product;
import com.devsuperior.DSCommerce.repositories.ProductRepository;
import com.devsuperior.DSCommerce.services.exceptions.DatabaseException;
import com.devsuperior.DSCommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado !!"));
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
        Page<Product> productList = productRepository.findByName(name, pageable);
        return productList.map(ProductMinDTO::new);
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        try {
            Product product = new Product();
            copyDtoToEntity(productDTO, product);
            product = productRepository.save(product);
            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado !!");
        }
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        try {
            Product product = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, product);
            productRepository.save(product);
            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado !!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado !!");
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial!!");
        }

    }

    private void copyDtoToEntity(ProductDTO productDTO, Product product) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
        product.getCategories().clear();
        for (CategoryDTO catDTO : productDTO.getCategories()) {
            Category cat = new Category();
            cat.setId(catDTO.getId());
            product.getCategories().add(cat);
        }
    }
}
