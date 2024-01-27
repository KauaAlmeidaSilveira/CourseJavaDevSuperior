package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductProjection;

public class ProductDTO {

    private String name;

    public ProductDTO() {
    }

    public ProductDTO(String name) {
        this.name = name;
    }

    public ProductDTO(ProductProjection productProjection) {
        name = productProjection.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
