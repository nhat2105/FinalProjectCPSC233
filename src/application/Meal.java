package application;

public class Meal extends Activities {
	public Meal(String code) {
		super(code);
	}
	public double getProteinInfo(String code) {//protein per 100g for now
		switch(code) { 
		case "milk":
			return 3.4;
		case "fruit":
			return 0.3;
		case "tea":
			return 0.1;
		case "chicken": 
			return 27; 
		case "pork": 
			return 27; 
		case "beef": 
			return 26; 
		case "vegetable": 
			return 2.9;
		case "soup": 
			return 4;
		case "seed": 
			return 30;
		}
		return calories;
		
	}
	public String getInfo(String code) {
		return "Per 100 gram of this food contains " + getProteinInfo(code) + "g of protein";
	}
	public String toString() {
		return "In your meal: " + getCode();
	}
}
