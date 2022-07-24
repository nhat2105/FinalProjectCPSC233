package application;

public class SleepTracker {
	
	double sleepHours;
	double sleepDebt;

	public String getSleepResult(String sleepInput) {
		String error = validate(sleepInput);
		if (error.equals("")) {
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
		return error;	
	}

	private String validate(String sleepInput) {
		String errorMessage = ""; // String to display when error occurs
		
    	//counter to keep track of '.' char
    	int counter = 0;
    	//check to see if entered value is numeric
    	boolean validInput = true;
    	for (char c: sleepInput.toCharArray()) {
    		//if a character is not a digit, display the error message
    		if (!Character.isDigit(c) && c != '.') {
    			validInput= false;
    			errorMessage = ("Don't include character such as: " + c + 
    					", only grade number");
    			
    		}
    		//if there is a dot, increase the tracking counter
    		if (c == '.') {
    			counter += 1;
    		}
    		//if there are more than 1 dot, it is an invalid decimal
    		if (counter > 1) {
    			validInput = false;
    			errorMessage = ("Invalid value entered. Decimal should only include 1 dot");
    		}
    	}
    	
    	if (validInput){
    		sleepHours = Double.parseDouble(sleepInput);
    	}
    	
    	/*Verify whether the project grade input was in a valid range
    	 *If not it will be 0
    	*/
    	if ( sleepHours < 0 || sleepHours > 168 ) {//hours of 7 days
    		errorMessage = ("Error. Grade should be in between 0 and " + 168);
    		sleepHours = 0;
    	}
		return errorMessage;
		
	}
}
