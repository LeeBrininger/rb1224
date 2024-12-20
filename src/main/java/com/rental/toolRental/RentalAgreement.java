package com.rental.toolRental;

import java.time.LocalDate;

public class RentalAgreement {
	
	public RentalAgreement(Tool tool, int rentalDays, LocalDate checkOutDate, int discount) {
		super();
		this.tool = tool;
		this.rentalDays = rentalDays;
		this.checkOutDate = checkOutDate;
		this.discount = discount;
		calculateCharges();
	}

	private void calculateCharges()
	{
		dueDate = checkOutDate.plusDays(rentalDays);
		preDiscountCharge = tool.getType().getCharge() * rentalDays;
		chargeDays = rentalDays;
		discountAmount = preDiscountCharge * (discount * 0.01);
		discountAmount = Math.round(discountAmount * 100) * 0.01;
		
		double newAmount = preDiscountCharge - discountAmount;
		finalCharge = Math.round(newAmount * 100) * 0.01;
	}
	
	public String printForm() {
		return "Tool code: " + tool.getCode() + "\n" +
				"Tool type: " + tool.getType().getName() + "\n" +
				"Tool brand: " + tool.getBrand() + "\n" +
				"Rental days: " + rentalDays + "\n" +
				"Check out date: " + checkOutDate + "\n" +
				"Due Date: " + dueDate + "\n" +
				"Daily Rental Charge: " + tool.getType().getCharge() + "\n" +
				"Charge Days: " + chargeDays + "\n" +
				"Pre-Discount Charge: " + preDiscountCharge + "\n" +
				"Discount Percent: " + discount + "\n" +
				"Discount Amount: " + discountAmount + "\n" +
				"Final Charge: " + finalCharge + " ";
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getChargeDays() {
		return chargeDays;
	}

	public void setChargeDays(int chargeDays) {
		this.chargeDays = chargeDays;
	}

	public double getPreDiscountCharge() {
		return preDiscountCharge;
	}

	public void setPreDiscountCharge(double preDiscountCharge) {
		this.preDiscountCharge = preDiscountCharge;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getdiscountAmount() {
		return discountAmount;
	}

	public void setdiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getFinalCharge() {
		return finalCharge;
	}

	public void setFinalCharge(double finalCharge) {
		this.finalCharge = finalCharge;
	}

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
