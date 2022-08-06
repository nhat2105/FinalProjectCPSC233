package application;

public class Exercises extends Activities {
	public Exercises(String code) {
		super(code);
	}

	//Next step, when clicked on, display data for each button
	public double getCaloriesInfo(String code, double userWeight) {
		switch(code) {
		//each display for 30 minutes 
		//calories burn
		case "pushUp":
			return 210;//7 per min
		case "squat":
			return 240; //8 per minute
		case "swim":
			return 250;	
			//These activities below based on
			//user's weight as well
		case "running":
			if (userWeight >= 60 && userWeight <= 70) {
				return 300;
			}else if (userWeight > 70 && userWeight <= 80) {
				return 350;
			}else if (userWeight > 80 && userWeight <= 90) {
				return 400;
			}else if (userWeight > 90 && userWeight <= 100) {
				return 450;
				}
			else {
				return 220;
				}
			case "jogging":
				if (userWeight >= 60 && userWeight <= 70) {
					return 125;
				}else if (userWeight > 70 && userWeight <= 80) {
					return 150;
				}else if (userWeight > 80 && userWeight <= 90) {
					return 175;
				}else if (userWeight > 90 && userWeight <= 100) {
					return 200;
				}
				else {
					return 100;
				}
				
			case "cycling":		
				if (userWeight >= 60 && userWeight <= 70) {
					return 200;
				}else if (userWeight > 70 && userWeight <= 80) {
					return 250;
				}else if (userWeight > 80 && userWeight <= 90) {
					return 300;
				}else if (userWeight > 90 && userWeight <= 100) {
					return 350;
				}
				else {
					return 180;
				}
		}
		return calories;
	}

	//String representation of get information
	String getInfo(String exerciseCode, double userWeight) {
		return "This activity consumes " + getCaloriesInfo(exerciseCode, userWeight) + " calories in 30 minutes for you";
	}
	public String toString() {
		return "Your activity: " + getCode();
	}
}
