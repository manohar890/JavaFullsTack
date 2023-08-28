package com.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.movie.Repository.MovieRepository;

@Controller
public class UserController {
	@Autowired
	MovieRepository mrep;
	@GetMapping("/")
	public String Welcome() {
		return "welcome";
	}
	
	@GetMapping("/searching")
	public String byMovieId(ModelMap m) {
		return "search";	
	}
	@PostMapping("/result")
	public String byMovie(@RequestParam("id") String id,ModelMap m) {
		if(mrep.findById(id).isPresent()) {
			m.put("movie", mrep.findById(id).get());
			return "Data";
		}else if(mrep.findByMovieName(id).isPresent()) {
			m.put("movie", mrep.findByMovieName(id).get());
			return "Data";
		}
		return "NotFound";	
	}
	@GetMapping("/byMovieCollection")
	public String byMovieCollection(ModelMap m) {
		return "search2";	
	}
	@PostMapping("/byMovieCollection")
	public String byMovieCollection(@RequestParam("id") double id,ModelMap m) {
		if(mrep.findByMovieCollection(id).isPresent()) {
			m.put("movie", mrep.findByMovieCollection(id).get());
			return "Data";
		}
		return "NotFound";	
	}
}
