package application;

public class SleepTracker {
	
	double sleepHours, sleepHoursEveryday;
	String sleepStatus;
	
	//Try to add later so that whenever it
	//switches back to the main screen, the input
	//still saves
	
	public String getSleepResult(String sleepInput) {
		//Validate input{
		sleepHours = Double.parseDouble(sleepInput);
		
		sleepHoursEveryday = sleepHours/7;
		
		if (sleepHoursEveryday >= 9.5) {
			sleepStatus = "too much";
			return "You sleep too much. Try to reduce it" 
				+" to 7 to 9 hours per day.";
			}
		else if (sleepHoursEveryday >= 7 && sleepHoursEveryday < 9.5) {
			sleepStatus = "good";
			return "You have a good sleep schedule, keep it up!";
		}
		else {
			sleepStatus = "too little";
			return "You need to sleep more. Try to arrange so that "
					+ "you have at least 7 hours of sleep every day.";
			}	
	}
	public String getSleepStatus() {
		return sleepStatus;
	}
	
	
}
