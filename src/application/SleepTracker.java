package application;

public class SleepTracker {
	
	double sleepHours;
	double sleepDebt;

	public String getSleepResult(String sleepInput) {
		//Validate input{
		sleepHours = Double.parseDouble(sleepInput);
		
		double sleepHoursEveryday = sleepHours/7;
		if (sleepHoursEveryday >= 9.5) {
			return "You sleep too much. Try to reduce it" 
				+" to 7 to 9 hours per day";
			}
		else if (sleepHoursEveryday >= 7 && sleepHoursEveryday < 9.5) {
			return "You have a good sleep schedule, keep it up!";
		}
		else {
			return "You need to sleep more. Try to arrange so that"
					+ "you have at least 7 hours of sleep every day";
			}	
	}
}
