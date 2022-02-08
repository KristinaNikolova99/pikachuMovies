package com.kristina.pikachuMovies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kristina.pikachuMovies.Models.Movie;
import com.kristina.pikachuMovies.Repositories.MovieRepository;


@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;

	public List<Movie> findByKeyword(String keyword) {
		return movieRepository.findByKeyword(keyword);
	}
}
