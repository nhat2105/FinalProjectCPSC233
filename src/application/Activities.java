package application;

public class Activities{
	int calories = 0;
	int protein = 0;
	int fat = 0;
	String preference = "";
	String actCode = "";
	
	
	public void setPreference(String pref) {
		this.preference += pref;
		
	}
	String getPreference() {
		return preference;
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
	protected void setCalories(int caloriesAmount) {
		this.calories = caloriesAmount;
	}
	protected void setProteinInfo(int proteinAmount) {
		this.protein = proteinAmount;
	}
	public void setCode(String actCode) {
		this.actCode = actCode;
		
	}
	public String getCode() {
		return actCode;
	}
	
}
