package com.rental.toolRental;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ToolRental {

	/**
	 * This is the main method for the rental tool
	 * @param args Unused
	 */
	public static void main(String[] args) {
		
		// Two example rentals with contracts printed out
		RentalAgreement contract = checkout("LAWD", 3, "7/2/20", 10);
		System.out.println(contract.printForm() + "\n");
		
		contract = checkout("LAWD", 3, "2/20/15", 10);
		System.out.println(contract.printForm());
	}
	
	/**
	 * This method 
	 * @param toolCode This is the rented tool's unique identifier.
	 * @param dayCount This is the number of days the rental will be for.
	 * @param date This is the date that the rental shall begin.
	 * @param discount This is the percent discount applied to the rental.
	 * @return
	 */
	public static RentalAgreement checkout(String toolCode, int dayCount, String date, int discount) {
		
		ArrayList<Tool> toolRepo = getToolRepo();
		RentalAgreement contract = null;
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("M/d/yy");
		
		if(dayCount < 1) {
			throw new IllegalArgumentException("Please enter a rental time of at least one day");
		}
		if(discount < 0 || discount > 100) {
			throw new IllegalArgumentException("Please enter a percent discount between 0 and 100");
		}

		LocalDate myDate = LocalDate.parse(date, pattern);
		Tool rentalTool = null;
		for(Tool tool : toolRepo) {
			if(tool.getCode().equals(toolCode)) {
				rentalTool = tool;
			}
		}
		contract = new RentalAgreement(rentalTool, dayCount, myDate, discount);
		return contract;
	}
	
	/**
	 * This method generates the tool types and the four tools to rent.
	 * In a real service this would be calling a database for the info.
	 * @return
	 */
	public static ArrayList<Tool> getToolRepo()
	{
		ToolType ladder = new ToolType("Ladder", 1.99, true, true, false);
		ToolType chainsaw = new ToolType("Chainsaw", 1.49, true, false, true);
		ToolType jackhammer = new ToolType("Jackhammer", 2.99, true, false, false);
		
		ArrayList<Tool> toolRepo = new ArrayList<>();
		toolRepo.add(new Tool("CHNS", chainsaw, "Stihl"));
		toolRepo.add(new Tool("LAWD", ladder, "Werner"));
		toolRepo.add(new Tool("JAKD", jackhammer, "DeWalt"));
		toolRepo.add(new Tool("JAKR", jackhammer, "Ridgid"));
		
		return toolRepo;
	}

}
