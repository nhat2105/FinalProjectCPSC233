package application;

public class Exercises extends Activities {
	public Exercises(String code) {
		super(code);
		setType("exercise");
	}
	
	public void setCaloriesInfo(String code, double userWeight) {
		switch(code) {
		//each display for 30 minutes 
		//calories burn
		case "yoga":
			this.calories = 100;
			break;
		case "meditation":
			this.calories = 35;
			break;
		case "aerobics":
			this.calories = 85;
			break;
		case "pushUp":
			this.calories = 210;//7 per min
			break;
		case "squat":
			this.calories = 240; //8 per minute
			break;
		case "swim":
			this.calories = 250;	
			break;
			//These activities below based on
			//user's weight as well
		case "running":
			if (userWeight >= 60 && userWeight <= 70) {
				this.calories = 300;
				break;
			}else if (userWeight > 70 && userWeight <= 80) {
				this.calories = 350;
				break;
			}else if (userWeight > 80 && userWeight <= 90) {
				this.calories = 400;
				break;
			}else if (userWeight > 90 && userWeight <= 100) {
				this.calories = 450;
				break;
				}
			else {
				this.calories = 220;
				break;
				}
			case "jogging":
				if (userWeight >= 60 && userWeight <= 70) {
					this.calories = 125;
					break;
				}else if (userWeight > 70 && userWeight <= 80) {
					this.calories = 150;
					break;
				}else if (userWeight > 80 && userWeight <= 90) {
					this.calories = 175;
					break;
				}else if (userWeight > 90 && userWeight <= 100) {
					this.calories = 200;
					break;
				}
				else {
					this.calories = 100;
					break;
				}
				
			case "cycling":		
				if (userWeight >= 60 && userWeight <= 70) {
					this.calories = 200;
					break;
				}else if (userWeight > 70 && userWeight <= 80) {
					this.calories = 250;
					break;
				}else if (userWeight > 80 && userWeight <= 90) {
					this.calories = 300;
					break;
				}else if (userWeight > 90 && userWeight <= 100) {
					this.calories = 350;
					break;
				}
				else {
					this.calories = 180;
					break;
				}
			
		}
	}

	//String representation of get information
	String getInfo() {
		return "This activity consumes " + getCaloriesInfo() + " calories in 30 minutes for you";
	}
	public String toString() {
		return "Your activity: " + getCode();
	}
}
