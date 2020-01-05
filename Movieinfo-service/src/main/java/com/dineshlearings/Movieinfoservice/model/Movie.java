package com.dineshlearings.Movieinfoservice.model;

public class Movie {
	private String name;
	private int modieId;

	public Movie(String name, int modieId) {
		super();
		this.name = name;
		this.modieId = modieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getModieId() {
		return modieId;
	}

	public void setModieId(int modieId) {
		this.modieId = modieId;
	}

}
