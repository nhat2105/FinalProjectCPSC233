package application;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class SleepTracker {
	//Instances for sleep tracker
	private double sleepHoursTotal, sleepHoursEveryday;
	private String sleepStatus;
	
	/**
	 * This method returns the sleep result based on all
	 * sleep inputs user entered
	 * @param allSleepInputs an array list of all sleep inputs of user's sleep in a week
	 * @return sleep status as String
	 */
	public String getSleepResult(ArrayList<TextField> allSleepInputs) {
		for (TextField sleepInput: allSleepInputs) {
			sleepHoursTotal += Double.parseDouble(sleepInput.getText());
		}
		sleepHoursEveryday = sleepHoursTotal/7;
		
		if (sleepHoursEveryday >= 9.5) {
			sleepStatus = "too much";
			return "You sleept too much. Try to reduce it" 
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
	//getter for user's sleep Status
	public String getSleepStatus() {
		return sleepStatus;
	}

}
