package application;

public class Meal extends Activities {
	//Instances include protein information
	//and meal group for meal proportion
	String mealGroup ="";
	private double protein = 0;
	
	//Constructor with parameters to set name, calories consumption, type of
	//activities and protein information of meal in that order
	public Meal(String code, double calories, String type, double protein) {
		super(code, calories, type);
		setProteinInfo(protein);
	}
	
	public Meal(Meal another) {
		super(another);
		this.setProteinInfo(another.getProteinInfo());
	}

	//Setters and getters for protein and meal group
	public double getProteinInfo() {
		return this.protein;
	} 
	public void setProteinInfo(double protein) {//protein per 100g for now
		this.protein = protein;
	}
	public void setMealGroup(String group) {
		this.mealGroup = group;
	}
	public String getMealGroup() {
		return this.mealGroup;
	}
	
	//String representation of get information method
	public String getInfo() {
		return "Per 100 gram of this food contains " + getProteinInfo() + "g of protein and " + super.getCaloriesInfo() + " calories";
	}
	//String representation of this activity's name
	public String toString() {
		return "In your meal: " + getCode();
	}
}

