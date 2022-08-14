package application;

public class Activity{
	
	//Instances
	protected double calories = 0;
	private String actCode = "";
	protected String type = "";
	
	//Constructor to set activity's code, calories, type in that respectively
	public Activity(String code, double calories, String type) {
		setCode(code);
		setCalories(calories);
		setType(type);
	}
	//Copy constructor
	public Activity(Activity toCopy) {
		this.type = toCopy.getType();
		this.calories = toCopy.getCaloriesInfo();
		this.actCode = toCopy.getCode();
	}
	
	//setter and getter for activity's code (name)
	protected void setCode(String actCode) {
		this.actCode = actCode;
		
	}
	public String getCode() {
		return actCode;
	}
	//setter and getter for activity's type
	public void setType(String typeOfAct) {
		this.type = typeOfAct;
	}
	
	public String getType() {
		return this.type;
	}
	//setter and getter for activity's calories
	protected void setCalories(double caloriesAmount) {
		this.calories = caloriesAmount;
	}
	public double getCaloriesInfo() {
		return calories;
	}
	
}
