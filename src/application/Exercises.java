package application;

public class Exercises extends Activities {
	public Exercises(String code, double calories, String type) {
		super(code, calories, type);
	}

	public void setCaloriesInfo(double caloriesInfo) {
		this.calories = caloriesInfo;
	}

	//String representation of get information
	String getInfo() {
		return "This activity consumes " + getCaloriesInfo() + " calories in 30 minutes for you";
	}
	public String toString() {
		return "Your activity: " + getCode();
	}
}
