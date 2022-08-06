package application;

public class ActivitiesTracker extends ApplicationController{
	int calories = 0;
	int protein = 0;
	int fat = 0;
	String group = "";
	
	
	//The function below returns user weight status
	//based on their BMI
	public String getSuitableHealthStatus(double BMI) {
		if (BMI >= 25) {
			return "overWeight";
		}
		else if (BMI <= 18.5) {
			return "underWeight";
		}
		else {
			return "all";
		}
	}
	//The following method get nutrition
	//values of exercises and food
	public String getInfo(String code) { 
		switch(code) { 
		case "chicken": break; 
		case "pork": break; 
		case "rice": break; 
		case "vegetable": break; 
		case "soup": break; 
		case "salmon": break; 
		
		//each display for 30 minutes 
		//calories burn
		case "pushUp":
			calories = 210;
			break; //7 per minute
		case "squat":
			calories = 240; //8 per minute
			break;
		case "swim":
			calories = 250;
			break;
			
		//These activities below based on
		//user's weight as well
		case "running":
			if (getUserWeight() >= 60 && getUserWeight() <= 70) {
				calories = 300;
			}else if (getUserWeight() > 70 && getUserWeight() <= 80) {
				calories = 350;
			}else if (getUserWeight() > 80 && getUserWeight() <= 90) {
				calories = 400;
			}else if (getUserWeight() > 90 && getUserWeight() <= 100) {
				calories = 450;
			}
			else {
				calories = 200;
			}
			break;
		case "jogging":
			if (getUserWeight() >= 60 && getUserWeight() <= 70) {
				calories = 125;
			}else if (getUserWeight() > 70 && getUserWeight() <= 80) {
				calories = 150;
			}else if (getUserWeight() > 80 && getUserWeight() <= 90) {
				calories = 175;
			}else if (getUserWeight() > 90 && getUserWeight() <= 100) {
				calories = 200;
			}
			else {
				calories = 100;
			}
			break;
		
		case "cycling":		
			if (getUserWeight() >= 60 && getUserWeight() <= 70) {
				calories = 200;
			}else if (getUserWeight() > 70 && getUserWeight() <= 80) {
				calories = 250;
			}else if (getUserWeight() > 80 && getUserWeight() <= 90) {
				calories = 300;
			}else if (getUserWeight() > 90 && getUserWeight() <= 100) {
				calories = 350;
			}
			else {
				calories = 180;
			}
			break;
		
		} 
		return code; 
		}
	
}
