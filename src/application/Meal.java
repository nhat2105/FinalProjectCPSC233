package application;

public class Meal extends ActivitiesTracker {
	String preference = "";
	
	public void setInfo(String code) {
		switch(code) { 
		case "chicken": break; 
		case "pork": break; 
		case "rice": break; 
		case "vegetable": break; 
		case "soup": break; 
		case "salmon": break; 
		}

	}

	public void setPreference(String pref) {
		this.preference = pref;
		
	}
}
