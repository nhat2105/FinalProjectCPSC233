package application;

public class Meal extends Activities {
	
	public double getProteinInfo(String code) {//protein per 100g for now
		switch(code) { 
		case "chicken": 
			return 27; 
		case "pork": 
			return 27; 
		case "beef": 
			return 26; 
		case "vege": 
			return 2.9;
		case "soup": 
			return 4;
		case "seed": 
			return 30;
		}
		return calories;
		
	}
	public String getInfo(String code) {
		return "Per 100 gram ofthis food contains " + getProteinInfo(code) + "g of protein";
	}

}
