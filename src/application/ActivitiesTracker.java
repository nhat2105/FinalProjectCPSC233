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
	public void setCaloriesInfo(int caloriesAmount) {
		this.calories = caloriesAmount;
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
		}
		return code; 
		}
	
}
