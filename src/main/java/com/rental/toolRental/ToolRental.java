package com.rental.toolRental;

import java.time.LocalDate;
import java.util.ArrayList;

public class ToolRental {

	public static void main(String[] args) {
		
		// In a real service these would be stored and read in from a database
		ToolType chainsaw = new ToolType("Chainsaw", 1.99, true, true, false);
		ToolType ladder = new ToolType("Ladder", 1.49, true, false, true);
		ToolType jackhammer = new ToolType("Jackhammer", 2.99, true, false, false);
		
		// These would also be coming from a database instead of a hard coded ArrayList
		ArrayList<Tool> toolRepo = new ArrayList<>();
		toolRepo.add(new Tool("CHNS", chainsaw, "Stihl"));
		toolRepo.add(new Tool("LAWD", ladder, "Werner"));
		toolRepo.add(new Tool("JAKD", jackhammer, "DeWalt"));
		toolRepo.add(new Tool("JAKR", jackhammer, "Ridgid"));		
		
		generateRental("LAWD", 5, "2024-02-14", 10, toolRepo);
	}
	
	public static void generateRental(String toolCode, int dayCount, String date, int discount, ArrayList<Tool> toolRepo) {
		
		if(dayCount < 1)
		{
			System.out.println("Please enter a rental time of at least one day");
		}
		else if(discount < 0 || discount > 100)
		{
			System.out.println("Please enter a percent discount between 0 and 100");
		}
		else
		{
			LocalDate myDate = LocalDate.parse(date);
			Tool rentalTool = null;
			for(Tool tool : toolRepo) {
				if(tool.getCode().equals(toolCode)) {
					rentalTool = tool;
				}
			}
			
			RentalAgreement contract = new RentalAgreement(rentalTool, dayCount, myDate, discount);
			System.out.println(contract.printForm());
		}
	}

}
