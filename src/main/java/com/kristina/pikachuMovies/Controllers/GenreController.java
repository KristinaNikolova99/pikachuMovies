package com.kristina.pikachuMovies.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import com.kristina.pikachuMovies.Models.Genre;
import com.kristina.pikachuMovies.Repositories.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	GenreRepository genreRepository;

	@GetMapping("/genres")
	public String index(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		return "genre/index";
	}

	@GetMapping("/genreform")
	public String showSignUpForm(Genre genre) {
		return "genre/add-genre";
	}

	@PostMapping("/addgenre")
	public String addGenre(@Valid Genre genre, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "genre/add-genre";
		}

		genreRepository.save(genre);
		model.addAttribute("genres", genreRepository.findAll());
		return "redirect:/genres";
	}

	@GetMapping("/genre/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Genre genre = genreRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid genre Id:" + id));

		model.addAttribute("genre", genre);
		return "genre/update-genre";
	}

	@PostMapping("/genre/update/{id}")
	public String updateGenre(@PathVariable("id") long id, @Valid Genre genre, BindingResult result, Model model) {
		if (result.hasErrors()) {
			genre.setId(id);
			return "genre/update-genre";
		}

		genreRepository.save(genre);
		model.addAttribute("genres", genreRepository.findAll());
		return "redirect:/genres";
	}

	@GetMapping("/genre/delete/{id}")
	public String deleteGenre(@PathVariable("id") long id, Model model) {
		Genre genre = genreRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid genre Id:" + id));
		genreRepository.delete(genre);
		model.addAttribute("genres", genreRepository.findAll());
		return "redirect:/genres";
	}
}
