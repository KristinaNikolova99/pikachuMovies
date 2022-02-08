package com.kristina.pikachuMovies.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kristina.pikachuMovies.Models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	@Query(value = "select * from movies m where m.title like %:keyword%", nativeQuery = true)
	List<Movie> findByKeyword(@Param("keyword") String keyword);
}