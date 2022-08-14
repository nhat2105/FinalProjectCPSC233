package application;

import java.util.ArrayList;

public class HealthTracker{
	//Instances to work with include user's information 
	private double userWeight, userHeight;
	private double userBMI, userCalories;
	private ArrayList<Activity> toDoList = new ArrayList<Activity>();
	
	
	/**
	 * The method below takes a string as a parameter and validate whether
	 * it is a valid number to be converted into a double, it returns the 
	 * error message of how it is invalid, if it is valid then error message will
	 * be an empty string
	 * @param stringInput represents the input user put in
	 * @param upperBound represents the max value of the double converted from stringInput should be
	 * @param lowerBound represents the minimum value the double converted from stringInput should be
	 * @throws InvalidInputException for invalid inputs and error message included,
	 */
	public void validateInput(String stringInput, int upperBound, int lowerBound) throws InvalidInputException{
    	//counter to keep track of '.' char
    	int counter = 0;
    	//check to see if entered value is numeric
    	for (char c: stringInput.toCharArray()) {
    		//if a character is not a digit, display the error message
    		if (!Character.isDigit(c) && c != '.') {
    			throw new InvalidInputException("Don't include character such as: " + c + 
    					", only the numerical number");
    		}
    		//if there is a dot, increase the tracking counter
    		if (c == '.') {
    			counter += 1;
    		}
    		//if there are more than 1 dot, it is an invalid decimal
    		if (counter > 1) {
    			throw new InvalidInputException("Invalid value entered. Decimal should only include 1 dot");
    		}
    	}
    	
    	/* Verify whether the project grade input was in a valid range
    	 If not it will be 0 */
    	if (Double.parseDouble(stringInput) < lowerBound || Double.parseDouble(stringInput) > upperBound ) {//hours of 7 days
    		throw new InvalidInputException("Error. Value entered should be in between " + lowerBound + " and " + upperBound);
    	}
		
	}

	
	//Setter and getter for user weight input
	double getUserWeight() {
		return userWeight;
	}
	protected void setUserWeight(String userWeight) {
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

	protected void setUserHeight(String userHeight) {
		if (userHeight != null) { 
			this.userHeight = Double.parseDouble(userHeight);
		}
		else {
			this.userHeight = 0;
		}
	}
	//setter and getter for user BMI 
	protected void setUserBMI(double BMI) {
		this.userBMI = BMI;
	}
	double getUserBMI() {
		return this.userBMI;
	}

	//The method below updates user's data when their information changes
	public void updateUserData(String userHeight, String userWeight, double userBMI) {
		this.setUserBMI(userBMI);
		this.setUserHeight(userHeight);
		this.setUserWeight(userWeight);
		
	}
	//The method below adds an Activities a into the to do list
	//It will return an error message if not added successfully
	public String addToTodo(Activity a) {
		String errorMessage = "";
		//Max size of to do list is 10
		if (toDoList.size() >= 10) {
			errorMessage = "This list is full";
		}
		//Loop through the to do list
		for (Activity existingAct: toDoList) {
			//If activity is already in the list, it cannot be
			//added twice
			if (existingAct.getCode() == a.getCode()) {
				errorMessage = "This is already in your list";
				break;
			}	
		
		}
		if (errorMessage == "") {
			toDoList.add(a);
		}
		return errorMessage;
	}
	
	//String representation of to do list
	//Format: index. Activity name
	public String getToDoList() {
		String result = "";
		int index = 1;
		result += toDoList.size() + " things to do\n";
		for (Activity a: toDoList) {
			result += index + ". " + a.toString() + "\n";
			index++;
		}
		return result;
	}
	//get user weight status based on their BMI
	public String getHealthStatus(double BMI) {
		if (BMI >= 25) {
			return "overWeight";
		}
		else if (BMI <= 18.5) {
			return "underWeight";
		}
		else {
			return "normal";
		}
	}
	
	//getter for calories consumption
	public double getUserCaloriesConsumption() {
		return this.userCalories;
	}

	//setter for calories consumption, 
	//calories consumption is cumulative 
	public void addUserCaloriesConsumption(double calories) {
		this.userCalories += calories;
		
	}
	//the method below change calories changes into
	//kg changes in weight
	public int convertWeightChange(double calories) {
		return (int)calories * 30/7716;
	}

	//the method below get food suggestion for user based
	//on their weight status
	public String getFoodSuggestion() {
		String matchActivities = "";
		String healthStatus = this.getHealthStatus(getUserBMI());
		if (healthStatus.contains("under")){
			matchActivities = "Beef, nut";
			return matchActivities;
		}
		else if (healthStatus.contains("over")){
			matchActivities = "Vegetable, fruit";
			return matchActivities;
		}
		else {
			return "";
		}
	}
	//The method below get exerciseSuggestion based on their 
	//weight status
		public String getExerciseSuggestion() {
			String matchActivities = "";
			String healthStatus = this.getHealthStatus(getUserBMI());
			if (healthStatus.contains("under")){
				matchActivities = "Jogging, squat";
				return matchActivities;
			}
			else if (healthStatus.contains("over")){
				matchActivities = "Swimming, running";
				return matchActivities;
			}
			else {
				return "";
			}
	}
		//get to do list current size
		public int getToDoSize() {
			return toDoList.size();
		}
		//The method below remove an item from to do list
		//based on their index in the list
		public void removeFromToDo(String indexToRemove) {
			int index = 0;
			for (Activity a: toDoList) {
				//Since to do list shows index starts with 1
				if ((index+1) == Integer.parseInt(indexToRemove)) {
					/*if this is the right index, remove the 
					item and change calories consumption accordingly
					*/
					toDoList.remove(a);
					if (a.getType().equals("meal")) {
						addUserCaloriesConsumption(-1 * a.getCaloriesInfo());
					}
					else if (a.getType().equals("exercise")) {
						addUserCaloriesConsumption(a.getCaloriesInfo());
					}
					break;
				}
				index++;
			}
		}
		
}
