package com.model;

public class Cat extends Pet{
	private int catId;
	private String catColor;

	public Cat() {
		super();	
	}

	public Cat(int catId, String catColor) {
		super();
		this.catId = catId;
		this.catColor = catColor;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatColor() {
		return catColor;
	}

	public void setCatColor(String catColor) {
		this.catColor = catColor;
	}

	@Override
	public String toString() {
		return "Cat [catId=" + catId + ", catColor=" + catColor + "]";
	}
}
