package com.kristina.pikachuMovies.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kristina.pikachuMovies.Models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    
}