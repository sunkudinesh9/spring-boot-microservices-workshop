package com.dineshlearings.Movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineshlearings.Movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfoServiceResource {

	@RequestMapping("/{movieid}")
	public Movie getMovieInfo(@PathVariable("movieid") int movieid) {
		return new Movie("Tharazamenper", movieid);
	}
}
