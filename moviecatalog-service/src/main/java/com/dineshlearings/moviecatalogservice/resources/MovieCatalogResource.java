package com.dineshlearings.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.dineshlearings.moviecatalogservicemodels.CatalogItem;
import com.dineshlearings.moviecatalogservicemodels.Movie;
import com.dineshlearings.moviecatalogservicemodels.Rating;
import com.dineshlearings.moviecatalogservicemodels.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	WebClient.Builder webClientBuilder;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userid) {
		List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingdata/user/tha", UserRating.class);
		for (Rating rating : ratings.getListOfRating()) {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId(), Movie.class);
			catalogItems.add(new CatalogItem(movie.getName(), "Blabla", rating.getRating()));
		}
		return catalogItems;

	}
}
