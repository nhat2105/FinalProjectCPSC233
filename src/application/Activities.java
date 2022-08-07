package application;

public class Activities{
	protected double calories = 0;
	private String preference = "";
	private String actCode = "";
	
	public Activities(String code) {
		setCode(code);
		
	}
	
	
	public void setPreference(String pref) {
		this.preference += pref;
		
	}
	String getPreference() {
		return preference;
	}
	
	public double getCaloriesInfo() {
		return calories;
	}
	//The function below returns user weight status
	//based on their BMI
	protected void setCode(String actCode) {
		this.actCode = actCode;
		
	}
	public String getCode() {
		return actCode;
	}
	protected void setCalories(double caloriesAmount) {
		this.calories = caloriesAmount;
	}
	
}
