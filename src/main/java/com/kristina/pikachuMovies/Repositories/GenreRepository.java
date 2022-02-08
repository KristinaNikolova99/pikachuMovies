package com.kristina.pikachuMovies.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kristina.pikachuMovies.Models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}