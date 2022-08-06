package application;

public class ActivitiesTracker{
	int calories = 0;
	int protein = 0;
	int fat = 0;
	String preference = "";
	
	public void setPreference(String pref) {
		this.preference = pref;
		
	}
	
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
	protected void setCaloriesInfo(int caloriesAmount) {
		this.calories = caloriesAmount;
	}
	//The following method get nutrition
	//values of exercises and food
	public String getInfo(String componentCode) { 
		return "This component contains " + calories + " amount of calories for each use";
		}
	
}
