package com.kristina.pikachuMovies.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.validation.Valid;

import com.kristina.pikachuMovies.Models.Genre;
import com.kristina.pikachuMovies.Models.Movie;
import com.kristina.pikachuMovies.Repositories.GenreRepository;
import com.kristina.pikachuMovies.Repositories.MovieRepository;


@Controller
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	@Autowired
	GenreRepository genreRepository;

	
    @GetMapping("/movies")
    public String index(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movie/index";
    }
    
    @GetMapping("/movieform")
    public String showSignUpForm(Model model) {
    	List<Genre> genres = genreRepository.findAll();
    	model.addAttribute("genres", genres);
    	model.addAttribute("movie", new Movie());
        return "movie/add-movie";
    }

    @PostMapping("/addmovie")
    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "movie/add-movie";
        }

        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "redirect:/movies";
    }

    @GetMapping("/movie/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
    	List<Genre> genres = genreRepository.findAll();
    	model.addAttribute("genres", genres);
        model.addAttribute("movie", movie);
        return "movie/update-movie";
    }

    @PostMapping("/movie/update/{id}")
    public String updateMovie(@PathVariable("id") long id, @Valid Movie movie,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
        	movie.setId(id);
            return "movie/update-movie";
        }

        movieRepository.save(movie);
        model.addAttribute("movie", movieRepository.findAll());
        return "redirect:/movie";
    }

    @GetMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable("id") long id, Model model) {
    	Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        movieRepository.delete(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "redirect:/movies";
    }
}
