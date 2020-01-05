package com.dineshlearings.moviecatalogservicemodels;

import java.util.List;

public class UserRating {
	private List<Rating> listOfRating;
	
	public UserRating() {
		super();
	}

	public List<Rating> getListOfRating() {
		return listOfRating;
	}

	public void setListOfRating(List<Rating> listOfRating) {
		this.listOfRating = listOfRating;
	}
}
