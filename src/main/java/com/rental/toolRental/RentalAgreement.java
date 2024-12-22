package com.rental.toolRental;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Constructor for the Rental Agreement
	 * @param tool Type of tool being rented.
	 * @param rentalDays How many days the tool is being rented for.
	 * @param checkOutDate The date the rental is occurring.
	 * @param discount The percentage discount for the rental.
	 */
	public RentalAgreement(Tool tool, int rentalDays, LocalDate checkOutDate,
							int discount) {
		super();
		this.tool = tool;
		this.rentalDays = rentalDays;
		this.checkOutDate = checkOutDate;
		this.discount = discount;
		calculateCharges();
	}

	public Tool getTool() {
		return tool;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public int getChargeDays() {
		return chargeDays;
	}

	public double getPreDiscountCharge() {
		return preDiscountCharge;
	}

	public int getDiscount() {
		return discount;
	}

	public double getdiscountAmount() {
		return discountAmount;
	}

	public double getFinalCharge() {
		return finalCharge;
	}

	/**
	 * This method prints out the formatted rental form.
	 */
	public String printForm() {
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yy");
		return "Tool code: " + tool.getCode() + "\n" +
				"Tool type: " + tool.getType().getName() + "\n" +
				"Tool brand: " + tool.getBrand() + "\n" +
				"Rental days: " + rentalDays + "\n" +
				"Check out date: " + checkOutDate.format(pattern) + "\n" +
				"Due Date: " + dueDate.format(pattern) + "\n" +
				"Daily Rental Charge: $" + df.format(tool.getType().getCharge()) + "\n" +
				"Charge Days: " + chargeDays + "\n" +
				"Pre-Discount Charge: $" + df.format(preDiscountCharge) + "\n" +
				"Discount Percent: " + discount + "%\n" +
				"Discount Amount: $" + df.format(discountAmount) + "\n" +
				"Final Charge: $" + df.format(finalCharge) + " ";
	}
	
	/**
	 * This method calculates the charge and date info based on the info passed
	 * in via the constructor. It calculates the due date, how many days are
	 * chargeable, the discount amount, and the final charge amount.
	 */
	private void calculateCharges() {
		
		// Calculate due date
		dueDate = checkOutDate.plusDays(rentalDays);
		
		// Calculate chargeable days
		getValidDays();
		
		// Calculate pre-discount charge
		preDiscountCharge = tool.getType().getCharge() * chargeDays;
		
		// Calculate the discount amount, rounding to nearest cent
		discountAmount = preDiscountCharge * (discount * 0.01);
		BigDecimal bDiscount = new BigDecimal(discountAmount).setScale(2, RoundingMode.HALF_UP);
		discountAmount = bDiscount.doubleValue();
		
		// Calculate the final charge amount rounding to nearest cent
		finalCharge = preDiscountCharge - discountAmount;
		BigDecimal bFinal = new BigDecimal(finalCharge).setScale(2, RoundingMode.HALF_UP);
		finalCharge = bFinal.doubleValue();
	}
	
	/**
	 * This method checks all of the rental days to see which ones are
	 * chargeable for the rented tool type. It checks for holidays, weekdays
	 * and weekends.
	 */
	private void getValidDays() {
		
		DayOfWeek dayOfWeek = null;
		LocalDate checkDay = null;
		
		// Shortcut where all days are charged so there is no need to check
		if(tool.getType().isWeekdayCharge() &&
				tool.getType().isWeekendCharge() &&
				tool.getType().isHolidayCharge()) {
			chargeDays = rentalDays;
			return;
		}
		
		for(int i = 1; i <= rentalDays; i++) {
			checkDay = checkOutDate.plusDays(i);
			dayOfWeek = checkDay.getDayOfWeek();
			
			// If we don't charge on holidays and the day is a holiday skip
			// the rest of the loop's iteration. Otherwise check if it is a
			// weekend.
			if(!tool.getType().isHolidayCharge() && isHoliday(checkDay)) {
				continue;
			}
			
			switch(dayOfWeek) {
				case DayOfWeek.MONDAY:
				case DayOfWeek.TUESDAY:
				case DayOfWeek.WEDNESDAY:
				case DayOfWeek.THURSDAY:
				case DayOfWeek.FRIDAY:
					if(tool.getType().isWeekdayCharge()) {
						chargeDays++;
					}
					break;
				case DayOfWeek.SATURDAY:
				case DayOfWeek.SUNDAY:
					if(tool.getType().isWeekendCharge()) {
						chargeDays++;
					}
					break;
				default:
					break;
			}
		}
	}
	
	/**
	 * This method checks a passed in date to see if it is a holiday. The two
	 * holidays it looks for are the 4th of July and Labor day.
	 * @param date The date being checked.
	 * @return True if the date is a holiday, otherwise false.
	 */
	private boolean isHoliday(LocalDate date) {

		// Check for 4th of July
		if(date.getMonth().equals(Month.JULY) && date.getDayOfMonth() == 4) {
			return true;
		}
		
		// Check for Labor Day: See if the month is September, check if the day
		// is a Monday, if so check if is in the first week to know if it is
		// the first Monday
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		if(checkOutDate.getMonth().equals(Month.SEPTEMBER) &&
				dayOfWeek == DayOfWeek.MONDAY &&
				checkOutDate.getDayOfMonth() < 8) {
			return true;
		}
		
		return false;
	}
	
	// Class Variable Definitions
	private Tool tool;
	
	private int rentalDays;
	
	private LocalDate checkOutDate;
	
	private LocalDate dueDate;
	
	private int chargeDays;
	
	private double preDiscountCharge;
	
	private int discount;
	
	private double discountAmount;
	
	private double finalCharge;
	
}
