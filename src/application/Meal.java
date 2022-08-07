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
	public String getInfo() {
		return "Per 100 gram of this food contains " + getProteinInfo() + "g of protein";
	}
	public String toString() {
		return "In your meal: " + getCode();
	}
}
