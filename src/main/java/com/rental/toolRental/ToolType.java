package com.rental.toolRental;

public class ToolType {
	
	public ToolType(String name, double charge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
		super();
		this.name = name;
		this.charge = charge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}

	@Override
	public String toString() {
		return "ToolType [name=" + name + ", charge=" + charge + ", weekdayCharge=" + weekdayCharge + ", weekendCharge="
				+ weekendCharge + ", holidayCharge=" + holidayCharge + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}

	public void setWeekdayCharge(boolean weekdayCharge) {
		this.weekdayCharge = weekdayCharge;
	}

	public boolean isWeekendCharge() {
		return weekendCharge;
	}

	public void setWeekendCharge(boolean weekendCharge) {
		this.weekendCharge = weekendCharge;
	}

	public boolean isHolidayCharge() {
		return holidayCharge;
	}

	public void setHolidayCharge(boolean holidayCharge) {
		this.holidayCharge = holidayCharge;
	}

	private String name;
	
	private double charge;
	
	private boolean weekdayCharge;
	
	private boolean weekendCharge;
	
	private boolean holidayCharge;
}
