package com.kristina.pikachuMovies.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

import com.kristina.pikachuMovies.Models.User;
import com.kristina.pikachuMovies.Repositories.UserRepository;


@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "LoginRegister/Register";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepository.save(user);

		return "LoginRegister/RegisterSuccess";
	}
	  @GetMapping("/login")
	    public String viewLoginPage() {	         
	        return "LoginRegister/Login";
	    }
}
