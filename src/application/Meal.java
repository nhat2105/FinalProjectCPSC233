package application;

public class Meal extends Activities {
	String mealGroup ="";
	
	public Meal(String code, double calories, String type, double protein) {
		super(code, calories, type);
		setProteinInfo(protein);
	}
	private double protein = 0;
	public double getProteinInfo() {
		return this.protein;
	} 
	public void setMealGroup(String group) {
		this.mealGroup = group;
	}
	public String getMealGroup() {
		return this.mealGroup;
	}
	public void setProteinInfo(double protein) {//protein per 100g for now
		this.protein = protein;
	}
	public void setCaloriesInfo(double calories) {//protein per 100g for now
		this.calories = calories;	
	}
	public String getInfo() {
		return "Per 100 gram of this food contains " + getProteinInfo() + "g of protein and " + super.getCaloriesInfo() + " calories";
	}
	public String toString() {
		return "In your meal: " + getCode();
	}
}
