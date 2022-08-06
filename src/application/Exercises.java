package application;

public class Exercises extends ActivitiesTracker {
	

	public void setCaloriesInfo(String code, double userWeight) {
		switch(code) {
		//each display for 30 minutes 
		//calories burn
		case "pushUp":
			super.setCaloriesInfo(210);//7 per min
			break; 
		case "squat":
			super.setCaloriesInfo(240); //8 per minute
			break;
		case "swim":
			super.setCaloriesInfo(250);
			break;		
			//These activities below based on
			//user's weight as well
		case "running":
			if (userWeight >= 60 && userWeight <= 70) {
				super.setCaloriesInfo(300);
			}else if (userWeight > 70 && userWeight <= 80) {
				super.setCaloriesInfo(350);
			}else if (userWeight > 80 && userWeight <= 90) {
				super.setCaloriesInfo(400);
			}else if (userWeight > 90 && userWeight <= 100) {
				super.setCaloriesInfo(450);
				}
			else {
				super.setCaloriesInfo(220);
				}
				break;
			case "jogging":
				if (userWeight >= 60 && userWeight <= 70) {
					super.setCaloriesInfo(125);
				}else if (userWeight > 70 && userWeight <= 80) {
					super.setCaloriesInfo(150);
				}else if (userWeight > 80 && userWeight <= 90) {
					super.setCaloriesInfo(175);
				}else if (userWeight > 90 && userWeight <= 100) {
					super.setCaloriesInfo(200);
				}
				else {
					super.setCaloriesInfo(100);
				}
				break;
				
			case "cycling":		
				if (userWeight >= 60 && userWeight <= 70) {
					super.setCaloriesInfo(200);
				}else if (userWeight > 70 && userWeight <= 80) {
					super.setCaloriesInfo(250);
				}else if (userWeight > 80 && userWeight <= 90) {
					super.setCaloriesInfo(300);
				}else if (userWeight > 90 && userWeight <= 100) {
					super.setCaloriesInfo(350);
				}
				else {
					super.setCaloriesInfo(180);
				}
				break;
		}
		
	}

	
}
