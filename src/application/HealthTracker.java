package application;


public class HealthTracker{
	
	private double userWeight, userHeight;
	double userBMI;

	
	/**
	 * The method below takes a string as a parameter and validate whether
	 * it is a valid number to be converted into a double, it returns the 
	 * error message of how it is invalid, if it is valid then error message will
	 * be an empty string
	 * @param stringInput represents the input user put in
	 * @param upperBound represents the max value of the double converted from stringInput should be
	 * @param lowerBound represents the minimum value the double converted from stringInput should be
	 * @return error message, empty if stringInput is error-free
	 */
	public String validateInput(String stringInput, int upperBound, int lowerBound) {
		
    	//counter to keep track of '.' char
    	int counter = 0;
    	//check to see if entered value is numeric
    	for (char c: stringInput.toCharArray()) {
    		//if a character is not a digit, display the error message
    		if (!Character.isDigit(c) && c != '.') {
    			return ("Don't include character such as: " + c + 
    					", only the numerical number");
    			
    		}
    		//if there is a dot, increase the tracking counter
    		if (c == '.') {
    			counter += 1;
    		}
    		//if there are more than 1 dot, it is an invalid decimal
    		if (counter > 1) {
    			return "Invalid value entered. Decimal should only include 1 dot";
    		}
    	}
    	
    	/* Verify whether the project grade input was in a valid range
    	 If not it will be 0 */
    	if (Double.parseDouble(stringInput) < lowerBound || Double.parseDouble(stringInput) > upperBound ) {//hours of 7 days
    		return ("Error. Value entered should be in between " + lowerBound + " and " + upperBound);
    	}
		return "";
		
	}


	//Setter and getter for user weight input
	double getUserWeight() {
		return userWeight;
	}
	void setUserWeight(String userWeight) {
		if (userWeight != null) {
			this.userWeight = Double.parseDouble(userWeight);
		}
		else {
			this.userWeight = 0;
		}
	}
	//Setter and getter for height input
	double getUserHeight() {
		return userHeight;
	}

	void setUserHeight(String userHeight) {
		if (userHeight != null) { 
			this.userHeight = Double.parseDouble(userHeight);
		}
		else {
			this.userHeight = 0;
		}
	}
	void setUserBMI(double BMI) {
		this.userBMI = BMI;
	}
	double getUserBMI() {
		return this.userBMI;
	}


	public void updateUserData(String userHeight, String userWeight, double userBMI) {
		this.setUserBMI(userBMI);
		this.setUserHeight(userHeight);
		this.setUserWeight(userWeight);
		
	}



	
}
