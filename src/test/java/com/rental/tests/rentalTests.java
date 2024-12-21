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

	@Test
	void testOne() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->
			ToolRental.checkout("JAKR", 5, "2015-09-03", 101));
		assertEquals("Please enter a percent discount between 0 and 100", exception.getMessage());
	}

	@Test
	void testTwo() {
		RentalAgreement contract = ToolRental.checkout("LAWD", 3, "2020-07-02", 10);
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
	
	@Test
	void testThree() {
		RentalAgreement contract = ToolRental.checkout("CHNS", 5, "2015-07-02", 25);
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
	
	@Test
	void testFour() {
		RentalAgreement contract = ToolRental.checkout("JAKD", 6, "2015-09-03", 0);
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
	
	@Test
	void testFive() {
		RentalAgreement contract = ToolRental.checkout("JAKR", 9, "2015-07-02", 0);
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
	
	@Test
	void testSix() {
		RentalAgreement contract = ToolRental.checkout("JAKR", 3, "2020-07-02", 10);
		assertAll("Rental Test 6",
			() -> assertEquals(contract.getTool().getCode(), "JAKR"),
			() -> assertEquals(contract.getTool().getType().getName(), "Jackhammer"),
			() -> assertEquals(contract.getTool().getBrand(), "Ridgid"),
			() -> assertEquals(contract.getRentalDays(), 3),
			() -> assertEquals(contract.getCheckOutDate().format(pattern), "7/2/20"),
			() -> assertEquals(contract.getDueDate().format(pattern), "7/5/20"),
			() -> assertEquals(contract.getTool().getType().getCharge(), 2.99, 0.01),
			() -> assertEquals(contract.getChargeDays(), 1),
			() -> assertEquals(contract.getPreDiscountCharge(), 2.99, 0.01),
			() -> assertEquals(contract.getDiscount(), 10),
			() -> assertEquals(contract.getdiscountAmount(), 0.3, 0.01),
			() -> assertEquals(contract.getFinalCharge(), 2.69, 0.01)
		);
	}
}
