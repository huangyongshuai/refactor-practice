package com.refactor.practice;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDREN = 2;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
}
