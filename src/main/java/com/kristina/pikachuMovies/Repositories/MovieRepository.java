package com.kristina.pikachuMovies.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kristina.pikachuMovies.Models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}