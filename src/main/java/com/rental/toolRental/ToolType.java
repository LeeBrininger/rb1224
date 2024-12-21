package com.rental.toolRental;

public class ToolType {
	
	/**
	 * Constructor for the Tool Type class
	 * @param name Name of the type of tool.
	 * @param charge How much it costs to rent the tool per day.
	 * @param weekdayCharge If the tool is charged on weekdays.
	 * @param weekendCharge If the tool is charged on weekends.
	 * @param holidayCharge If the tool is charged on holidays.
	 */
	public ToolType(String name, double charge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
		super();
		this.name = name;
		this.charge = charge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}

	public String getName() {
		return name;
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
