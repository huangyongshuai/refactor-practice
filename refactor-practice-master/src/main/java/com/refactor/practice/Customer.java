package com.refactor.practice;

import java.util.Enumeration;
import java.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

		for (Rental rental : rentals) {
			double thisAmount = 0;

			// Determine amounts for each line
			switch (rental.getMovie().getPriceCode()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (rental.getDayRented() > 2) {
						thisAmount += (rental.getDayRented() - 2) * 1.5;
					}
					break;
				case Movie.NEW_RELEASE:
					thisAmount += rental.getDayRented() * 3;
					break;
				case Movie.CHILDREN:
					thisAmount += 1.5;
					if (rental.getDayRented() > 3) {
						thisAmount += (rental.getDayRented() - 3) * 1.5;
					}
					break;
			}

			// Add frequent renter points
			frequentRenterPoints++;
			// Add bonus for a two-day new release rental
			if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDayRented() > 1) {
				frequentRenterPoints++;

			}

			// Show figures for this rental
			result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
			totalAmount += thisAmount;
		}

		// Add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}
	public String htmlStatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("<h1>Rental Record for <em>").append(getName()).append("</em></h1>\n");

		for (Rental rental : rentals) {
			double thisAmount = 0;

			// Determine amounts for each line
			switch (rental.getMovie().getPriceCode()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (rental.getDayRented() > 2) {
						thisAmount += (rental.getDayRented() - 2) * 1.5;
					}
					break;
				case Movie.NEW_RELEASE:
					thisAmount += rental.getDayRented() * 3;
					break;
				case Movie.CHILDREN:
					thisAmount += 1.5;
					if (rental.getDayRented() > 3) {
						thisAmount += (rental.getDayRented() - 3) * 1.5;
					}
					break;
			}

			// Add frequent renter points
			frequentRenterPoints++;
			// Add bonus for a two-day new release rental
			if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDayRented() > 1) {
				frequentRenterPoints++;

			}

			// Show figures for this rental
			result.append("<p>").append(rental.getMovie().getTitle()).append(": ").append(thisAmount).append("</p>\n");
			totalAmount += thisAmount;
		}

		// Add footer lines
		result.append("<p>Amount owed is <em>").append(totalAmount).append("</em></p>\n");
		result.append("<p>You earned <em>").append(frequentRenterPoints).append("</em> frequent renter points</p>");
		return result.toString();
	}
}
