package com.dineshlearings.Ratingdataserice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineshlearings.Ratingdataserice.modules.Rating;
import com.dineshlearings.Ratingdataserice.modules.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
	
	@RequestMapping("/{movieid}")
	public Rating getRating(@PathVariable("movieid") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("user/{userid}")
	public UserRating getMovieRatings(@PathVariable("userid") String userid) {
		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("4567", 5), new Rating("7890", 4));
		UserRating userRatinds = new UserRating();
		userRatinds.setListOfRating(ratings);
		return userRatinds;
	}
}
