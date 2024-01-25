package com.devsuperior.uri2602.DTO;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

public class CustomerDTO {

    private String name;

    public CustomerDTO() {
    }

    public CustomerDTO(String name) {
        this.name = name;
    }

    public CustomerDTO(CustomerMinProjection customerMinProjection) {
        name = customerMinProjection.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
