package com.devsuperior.uri2611.DTO;

import com.devsuperior.uri2611.projections.MovieProjection;

public class MovieDTO {

    private Long id;
    private String name;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MovieDTO(MovieProjection movieProjection) {
        id = movieProjection.getId();
        name = movieProjection.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
