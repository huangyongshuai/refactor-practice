package com.refactor.practice;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
	private Customer customer;
	private String baseline;

	@Before
	public void setUp() throws IOException {
		customer = new Customer("user1");
		File file = new File("src/test/java/com/refactor/practice/baseline");
		baseline = FileUtils.readFileToString(file);
	}

	@Test
	public void shouldGetStatementOfRentals() {
		// Given
		addRental(customer, "regular movie", Movie.REGULAR, 3);
		addRental(customer, "new movie", Movie.NEW_RELEASE, 2);
		addRental(customer, "children movie", Movie.CHILDREN, 5);

		// When
		String result = customer.statement();

		// Then
		assertThat(result).isEqualTo(baseline);
	}

	@Test
	public void shouldGetHtmlStatementOfRentals() {
		// Given
		addRental(customer, "regular movie", Movie.REGULAR, 3);
		addRental(customer, "new movie", Movie.NEW_RELEASE, 2);
		addRental(customer, "children movie", Movie.CHILDREN, 5);

		// When
		String result = customer.htmlStatement();

		// Then
		assertThat(result).isEqualTo(getHtmlBaseline());
	}

	private void addRental(Customer customer, String movieTitle, int movieType, int dayRented) {
		Movie movie = new Movie(movieTitle, movieType);
		Rental rental = new Rental(movie, dayRented);
		customer.addRental(rental);
	}

	private String getHtmlBaseline() {
		return "<h1>Rental Record for <em>user1</em></h1>\n" +
				"<p>regular movie: 3.5</p>\n" +
				"<p>new movie: 6.0</p>\n" +
				"<p>children movie: 4.5</p>\n" +
				"<p>Amount owed is <em>14.0</em></p>\n" +
				"<p>You earned <em>4</em> frequent renter points</p>";
	}
}
