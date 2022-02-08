package com.kristina.pikachuMovies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kristina.pikachuMovies.Models.Movie;
import com.kristina.pikachuMovies.Repositories.MovieRepository;


@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;

	List<Movie> findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}

	List<Movie> findByTitleStartingWith(String title) {
		return movieRepository.findByTitleStartingWith(title);
	}

	public Optional<Movie> findById(Long id) {
		return movieRepository.findById(id);
	}

	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}

	public void save(Movie movie) {
		movieRepository.save(movie);
	}

	public List<Movie> findByKeyword(String keyword) {
		return movieRepository.findByKeyword(keyword);
	}
}
