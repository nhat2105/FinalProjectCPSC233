package application;

public class Meal extends Activities {
	private double protein = 0;
	public Meal(String code) {
		super(code);
	}
	public double getProteinInfo() {
		return this.protein;
	}
	public void setProteinInfo(String code) {//protein per 100g for now
		switch(code) { 
		case "milk":
			this.protein = 3.4;
			break;
		case "fruit":
			this.protein = 0.3;
			break;
		case "tea":
			this.protein = 0.1;
			break;
		case "chicken": 
			this.protein = 27; 
			break;
		case "pork": 
			this.protein = 27; 
			break;
		case "beef": 
			this.protein = 26; 
			break;
		case "vegetable": 
			this.protein = 2.9;
			break;
		case "soup": 
			this.protein = 4;
			break;
		case "seed": 
			this.protein = 30;
			break;
		}
		
	}
	public void setCaloriesInfo(String code) {//protein per 100g for now
		switch(code) { 
		
		case "milk":
			super.setCalories(42);
			break;
		case "fruit":
			super.setCalories(71);
			break;
		case "tea":
			super.setCalories(1);
			break;
		case "chicken": 
			super.setCalories(239); 
			break;
		case "pork": 
			super.setCalories(242); 
			break;
		case "beef": 
			super.setCalories(250); 
			break;
		case "vegetable": 
			super.setCalories(65);
			break;
		case "soup": 
			super.setCalories(42);
			break;
		case "seed": 
			super.setCalories(559);
			break;
		}
		
	}
	public String getInfo() {
		return "Per 100 gram of this food contains " + getProteinInfo() + "g of protein and " + super.getCaloriesInfo() + " calories";
	}
	public String toString() {
		return "In your meal: " + getCode();
	}
}
