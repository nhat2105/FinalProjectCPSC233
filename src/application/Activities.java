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
	
	protected double getCaloriesInfo() {
		return this.calories;
	}
	//The function below returns user weight status
	//based on their BMI
	protected void setCode(String actCode) {
		this.actCode = actCode;
		
	}
	public String getCode() {
		return actCode;
	}
	
}
