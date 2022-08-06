package application;

public class Exercises extends ActivitiesTracker {
	
	
	public void setCaloriesInfo(String code) {
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
			if (getUserWeight() >= 60 && getUserWeight() <= 70) {
				super.setCaloriesInfo(300);
			}else if (getUserWeight() > 70 && getUserWeight() <= 80) {
				super.setCaloriesInfo(350);
			}else if (getUserWeight() > 80 && getUserWeight() <= 90) {
				super.setCaloriesInfo(400);
			}else if (getUserWeight() > 90 && getUserWeight() <= 100) {
				super.setCaloriesInfo(450);
				}
			else {
				super.setCaloriesInfo(220);
				}
				break;
			case "jogging":
				if (getUserWeight() >= 60 && getUserWeight() <= 70) {
					super.setCaloriesInfo(125);
				}else if (getUserWeight() > 70 && getUserWeight() <= 80) {
					super.setCaloriesInfo(150);
				}else if (getUserWeight() > 80 && getUserWeight() <= 90) {
					super.setCaloriesInfo(175);
				}else if (getUserWeight() > 90 && getUserWeight() <= 100) {
					super.setCaloriesInfo(200);
				}
				else {
					super.setCaloriesInfo(100);
				}
				break;
				
			case "cycling":		
				if (getUserWeight() >= 60 && getUserWeight() <= 70) {
					super.setCaloriesInfo(200);
				}else if (getUserWeight() > 70 && getUserWeight() <= 80) {
					super.setCaloriesInfo(250);
				}else if (getUserWeight() > 80 && getUserWeight() <= 90) {
					super.setCaloriesInfo(300);
				}else if (getUserWeight() > 90 && getUserWeight() <= 100) {
					super.setCaloriesInfo(350);
				}
				else {
					super.setCaloriesInfo(180);
				}
				break;
		}
		
	}

	
}
