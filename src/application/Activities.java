package application;

public class Activities{
	protected double calories = 0;
	private String actCode = "";
	protected String type = "";
	
	public Activities(String code, double calories, String type) {
		setCode(code);
		setCalories(calories);
		setType(type);
	}
	
	public double getCaloriesInfo() {
		return calories;
	}
	//The function below returns user weight status
	//based on their BMI
	protected void setCode(String actCode) {
		this.actCode = actCode;
		
	}
	public void setType(String typeOfAct) {
		this.type = typeOfAct;
	}
	public String getType() {
		return this.type;
	}
	public String getCode() {
		return actCode;
	}
	protected void setCalories(double caloriesAmount) {
		this.calories = caloriesAmount;
	}
	
}
