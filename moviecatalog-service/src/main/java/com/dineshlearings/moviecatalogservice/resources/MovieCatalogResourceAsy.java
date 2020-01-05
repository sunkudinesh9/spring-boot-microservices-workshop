package com.dineshlearings.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.dineshlearings.moviecatalogservicemodels.CatalogItem;
import com.dineshlearings.moviecatalogservicemodels.Movie;
import com.dineshlearings.moviecatalogservicemodels.Rating;

public class MovieCatalogResourceAsy {
	@Autowired
	WebClient.Builder webClientBuilder;

	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userid) {
		List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("4567", 5), new Rating("7890", 4));
		for (Rating rating : ratings) {
			/*
			 * Below is the new way of calling the http request and conver that into the
			 * java objetc
			 */
			Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movie/" + rating.getMovieId())
					.retrieve().bodyToMono(Movie.class).block();

			catalogItems.add(new CatalogItem(movie.getName(), "Blabla", rating.getRating()));
		}
		return catalogItems;

	}

}
