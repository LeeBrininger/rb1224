package com.rental.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.rental.toolRental.RentalAgreement;
import com.rental.toolRental.ToolRental;

public class rentalTests {

	private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("M/d/yy");
	
	/**
	 * Provided test one
	 */
	@Test
	void testOne() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->
			ToolRental.checkout("JAKR", 5, "9/3/15", 101));
		assertEquals("Please enter a percent discount between 0 and 100", exception.getMessage());
	}

	/**
	 * Provided test two
	 */
	@Test
	void testTwo() {
		RentalAgreement contract = ToolRental.checkout("LAWD", 3, "7/2/20", 10);
		assertAll("Rental Test 2",
			() -> assertEquals(contract.getTool().getCode(), "LAWD"),
			() -> assertEquals(contract.getTool().getType().getName(), "Ladder"),
			() -> assertEquals(contract.getTool().getBrand(), "Werner"),
			() -> assertEquals(contract.getRentalDays(), 3),
			() -> assertEquals(contract.getCheckOutDate().format(pattern), "7/2/20"),
			() -> assertEquals(contract.getDueDate().format(pattern), "7/5/20"),
			() -> assertEquals(contract.getTool().getType().getCharge(), 1.99, 0.01),
			() -> assertEquals(contract.getChargeDays(), 2),
			() -> assertEquals(contract.getPreDiscountCharge(), 3.98, 0.01),
			() -> assertEquals(contract.getDiscount(), 10),
			() -> assertEquals(contract.getdiscountAmount(), 0.4, 0.01),
			() -> assertEquals(contract.getFinalCharge(), 3.58, 0.01)
		);
	}
	
	/**
	 * Provided test three
	 */
	@Test
	void testThree() {
		RentalAgreement contract = ToolRental.checkout("CHNS", 5, "7/2/15", 25);
		assertAll("Rental Test 3",
			() -> assertEquals(contract.getTool().getCode(), "CHNS"),
			() -> assertEquals(contract.getTool().getType().getName(), "Chainsaw"),
			() -> assertEquals(contract.getTool().getBrand(), "Stihl"),
			() -> assertEquals(contract.getRentalDays(), 5),
			() -> assertEquals(contract.getCheckOutDate().format(pattern), "7/2/15"),
			() -> assertEquals(contract.getDueDate().format(pattern), "7/7/15"),
			() -> assertEquals(contract.getTool().getType().getCharge(), 1.49, 0.01),
			() -> assertEquals(contract.getChargeDays(), 3),
			() -> assertEquals(contract.getPreDiscountCharge(), 4.47, 0.01),
			() -> assertEquals(contract.getDiscount(), 25),
			() -> assertEquals(contract.getdiscountAmount(), 1.12, 0.01),
			() -> assertEquals(contract.getFinalCharge(), 3.35, 0.01)
		);
	}
	
	/**
	 * Provided test four
	 */
	@Test
	void testFour() {
		RentalAgreement contract = ToolRental.checkout("JAKD", 6, "9/3/15", 0);
		assertAll("Rental Test 4",
			() -> assertEquals(contract.getTool().getCode(), "JAKD"),
			() -> assertEquals(contract.getTool().getType().getName(), "Jackhammer"),
			() -> assertEquals(contract.getTool().getBrand(), "DeWalt"),
			() -> assertEquals(contract.getRentalDays(), 6),
			() -> assertEquals(contract.getCheckOutDate().format(pattern), "9/3/15"),
			() -> assertEquals(contract.getDueDate().format(pattern), "9/9/15"),
			() -> assertEquals(contract.getTool().getType().getCharge(), 2.99, 0.01),
			() -> assertEquals(contract.getChargeDays(), 3),
			() -> assertEquals(contract.getPreDiscountCharge(), 8.97, 0.01),
			() -> assertEquals(contract.getDiscount(), 0),
			() -> assertEquals(contract.getdiscountAmount(), 0.0, 0.01),
			() -> assertEquals(contract.getFinalCharge(), 8.97, 0.01)
		);
	}
	
	/**
	 * Provided test five
	 */
	@Test
	void testFive() {
		RentalAgreement contract = ToolRental.checkout("JAKR", 9, "7/2/15", 0);
		assertAll("Rental Test 5",
			() -> assertEquals(contract.getTool().getCode(), "JAKR"),
			() -> assertEquals(contract.getTool().getType().getName(), "Jackhammer"),
			() -> assertEquals(contract.getTool().getBrand(), "Ridgid"),
			() -> assertEquals(contract.getRentalDays(), 9),
			() -> assertEquals(contract.getCheckOutDate().format(pattern), "7/2/15"),
			() -> assertEquals(contract.getDueDate().format(pattern), "7/11/15"),
			() -> assertEquals(contract.getTool().getType().getCharge(), 2.99, 0.01),
			() -> assertEquals(contract.getChargeDays(), 6),
			() -> assertEquals(contract.getPreDiscountCharge(), 17.94, 0.01),
			() -> assertEquals(contract.getDiscount(), 0),
			() -> assertEquals(contract.getdiscountAmount(), 0.0, 0.01),
			() -> assertEquals(contract.getFinalCharge(), 17.94, 0.01)
		);
	}
	
	/**
	 * Provided test six
	 */
	@Test
	void testSix() {
		RentalAgreement contract = ToolRental.checkout("JAKR", 4, "7/2/20", 50);
		assertAll("Rental Test 6",
			() -> assertEquals(contract.getTool().getCode(), "JAKR"),
			() -> assertEquals(contract.getTool().getType().getName(), "Jackhammer"),
			() -> assertEquals(contract.getTool().getBrand(), "Ridgid"),
			() -> assertEquals(contract.getRentalDays(), 4),
			() -> assertEquals(contract.getCheckOutDate().format(pattern), "7/2/20"),
			() -> assertEquals(contract.getDueDate().format(pattern), "7/6/20"),
			() -> assertEquals(contract.getTool().getType().getCharge(), 2.99, 0.01),
			() -> assertEquals(contract.getChargeDays(), 2),
			() -> assertEquals(contract.getPreDiscountCharge(), 5.98, 0.01),
			() -> assertEquals(contract.getDiscount(), 50),
			() -> assertEquals(contract.getdiscountAmount(), 2.99, 0.01),
			() -> assertEquals(contract.getFinalCharge(), 2.99, 0.01)
		);
	}
	
	/**
	 * Additional test, checks that zero day rental returns an exception
	 */
	@Test
	void testSeven() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->
			ToolRental.checkout("JAKR", 0, "9/3/15", 56));
		assertEquals("Please enter a rental time of at least one day", exception.getMessage());
	}
	
	
	@Test
	void testEight() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->
			ToolRental.checkout("JAKR", -1, "9/3/15", 56));
		assertEquals("Please enter a rental time of at least one day", exception.getMessage());
	}
	
	@Test
	void testNine() {
		RentalAgreement contract = ToolRental.checkout("LAWD", 3, "12/12/12", 10);
		assertAll("Testing date with to digit month and day",
			() -> assertEquals(contract.getTool().getCode(), "LAWD"),
			() -> assertEquals(contract.getTool().getType().getName(), "Ladder"),
			() -> assertEquals(contract.getTool().getBrand(), "Werner"),
			() -> assertEquals(contract.getRentalDays(), 3),
			() -> assertEquals(contract.getCheckOutDate().format(pattern), "12/12/12"),
			() -> assertEquals(contract.getDueDate().format(pattern), "12/15/12"),
			() -> assertEquals(contract.getTool().getType().getCharge(), 1.99, 0.01),
			() -> assertEquals(contract.getChargeDays(), 3),
			() -> assertEquals(contract.getPreDiscountCharge(), 5.97, 0.01),
			() -> assertEquals(contract.getDiscount(), 10),
			() -> assertEquals(contract.getdiscountAmount(), 0.6, 0.01),
			() -> assertEquals(contract.getFinalCharge(), 5.37, 0.01)
		);
	}
	
	/**
	 * Additional test, checks that a non-real date for rental returns an exception
	 */
	@Test
	void testTen() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->
			ToolRental.checkout("JAKR", 4, "14/3/15", 56));
		assertEquals("Please enter a valid date in the format mm/dd/yy", exception.getMessage());
	}
	
	/**
	 * Additional test, checks that differently formatted date for rental returns an exception
	 */
	@Test
	void testEleven() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->
			ToolRental.checkout("JAKR", 4, "2025-12-21", 56));
		assertEquals("Please enter a valid date in the format mm/dd/yy", exception.getMessage());
	}
}
