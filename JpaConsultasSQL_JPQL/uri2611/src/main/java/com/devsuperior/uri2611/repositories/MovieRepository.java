package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.DTO.MovieDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name " +
            "FROM movies " +
            "INNER JOIN genres ON movies.id_genres = genres.id " +
            "WHERE UPPER(genres.description) = UPPER(:genre)")
    List<MovieProjection> moviesSQL(String genre);

    @Query("SELECT new com.devsuperior.uri2611.DTO.MovieDTO(obj.id, obj.name) " +
            "FROM Movie obj " +
            "WHERE UPPER(obj.genre.description) = UPPER(:genre)")
    List<MovieDTO> moviesJPQL (String genre);
}
