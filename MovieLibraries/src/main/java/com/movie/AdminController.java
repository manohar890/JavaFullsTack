package com.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.Repository.MovieRepository;
import com.movie.model.Movie;

@Controller
public class AdminController {

	@Autowired
	private MovieRepository rep;
	
	@GetMapping("/home")
	public String HomeAdmin() {
		return "Admin";
	}
	@GetMapping("/admin")
	public String Login() {
		return "LoginForm";
	}
	@PostMapping("/Login")
	public String Loginsucces(@RequestParam("username") String username,@RequestParam("password") String password) {
		if(username.equals("root") && password.equals("root")) {
			return "Admin";
		}
		else {
			return "LoginForm";
		}
	}
	@GetMapping("/addMovie")
	public String AddMovie(ModelMap m) {
		String s="";
		Movie movie=new Movie("","",0.0);
		m.put("movie", movie);
		m.put("s", s);
		return "addMovie";
	}
	@PostMapping("/addMovie")
	public String addMovies(Movie m,ModelMap M) {
		String s="Inserted Successfully....";
		M.put("s", s);
		rep.save(m);
		return "addMovie";
	}
	@GetMapping("/modifyMovie")
	public String modifyMovie() {
		return "modify";
	}
	@GetMapping("/delMovie")
	public String delMovie() {
		return "modify";
	}
}
