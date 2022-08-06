package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicationController {
	Stage applicationStage;
	
	private double userWeight, userHeight;
	double userBMI;
	String userSleepStatus;
	
	Meal mealSuggestion;
	SleepTracker sleepTracker;
	
	//Result display text
	@FXML
	private Text sleepResult, BMIDisplay, healthStatusText;
	
	//Error text
	@FXML
	private Text weightErrorText, heightErrorText;
	
	//Result button
    @FXML
    private Button sleepTrackerResultButton, calculateBMIButton;

   //Input text
    @FXML
    private TextField sleepInput, userWeightInput, userHeightInput;	
	
    //Meal buttons
	@FXML
	private Button vegetableButton, porkButton, beefButton, chickenButton, soupButton, seedButton;
	@FXML
	private Button nutButton, fruitButton, teaButton;
	@FXML
	private Button vegeOption, meatOption;
	
	
	//Data display text
	@FXML
    private Text weightDisplay, heightDisplay, appName, sleepData, eatingData, exerciseData, mealOptionText;
	@FXML
    private Text sleepActDescription, sleepActDescription2, sleepMealDes;


    //Feature button
    @FXML
    private Button sleepTrackerButton, exerciseButton, BMIButton, mealsButton;

    //Pane
    @FXML
    private Pane exercisePane, sleepTrackerPane, mealPane;
    
    //Exercise button
    @FXML
    private Button squatButton, joggingButton, cyclingButton, swimmingButton, runningButton, pushUpButton;
    @FXML
    private Button sleepExercisesButton, sleepExercisesButton1, sleepExercisesButton2;
    

    //The function below takes in user inputs for their height and weights
    @FXML
    void getStart(ActionEvent event) throws FileNotFoundException, IOException {
    	//Validate input first
    	String errorFreeHeightInput = validateInput(userHeightInput.getText(), 215, 1);
    	String errorFreeWeightInput = validateInput(userWeightInput.getText(), 130, 1);
    	if (errorFreeHeightInput == "" && errorFreeWeightInput == "") {
	    	setUserHeight(userHeightInput.getText());
	    	setUserWeight(userWeightInput.getText());
	    	switchScene("Main View");
    	}
    	else {
    		weightErrorText.setText(errorFreeWeightInput);
    		heightErrorText.setText(errorFreeHeightInput);
    	}
    }

    
    /**
    * @param view (switch to main view)
    * @throws FileNotFoundException
    * @throws IOException
    * The function below switches the view from get started view to the main
    * application function view. It passes data of user inputs (height and weight)
    * from that scene to the main scene also
    */
    private void switchScene(String view) throws FileNotFoundException, IOException {
		if (view.equalsIgnoreCase("Main View")) {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/ApplicationView.fxml"));
			
			ApplicationController mainController = loader.getController();
			
			//The below codes pass data (user's weight and height )between scenes
			
			mainController.setUserHeight(String.valueOf(getUserHeight()));
			mainController.setUserWeight(String.valueOf(getUserWeight()));
			userBMI = getUserWeight()/ ((getUserHeight()/100)*(getUserHeight()/100));
	    	mainController.setUserBMI(userBMI);
			Scene scene = new Scene(root, 600, 400);
			
	    	applicationStage.setScene(scene);
	    	applicationStage.show();
	    	
		}
		
	}
    
	private void setUserBMI(double BMI) {
		this.userBMI = BMI;
	}
	
	/*
	 * The function below get the sleep tracker
	result when the right button is clicked
	*/
	@FXML
	public void getSleepResult(ActionEvent e) {
		//Create new sleep tracker
		sleepTracker = new SleepTracker();
		//Validate input
		String errorFreeInput = validateInput(sleepInput.getText(), 24 * 7, 0);
		
		//If input is valid, display the result for sleep status
		if (errorFreeInput == "") {
			String sleepHoursTrack = sleepTracker.getSleepResult(sleepInput.getText());
			sleepResult.setText(sleepHoursTrack);
			sleepResult.setVisible(true);
			sleepData.setVisible(true);
			userSleepStatus = sleepTracker.getSleepStatus();
			if (userSleepStatus != null) {
				healthStatusText.setText("Health status: " + userSleepStatus + " sleep");
				healthStatusText.setVisible(true);
			}
		}
		//If input is invalid, error message is displayed
		else {
			sleepResult.setText(errorFreeInput);
		}
		
	}
	
	/*
	 * The function below opens and function the exercise
		suggestion feature when the right button is clicked
	*/
    @FXML
    void openExercise(ActionEvent event) {
    	ActivitiesTracker exercises = new ActivitiesTracker();
    	turnOnScene(exercises.getSuitableHealthStatus(userBMI) + "Exercises" + userSleepStatus);
    }
    
    /**
     * The function below turns on the right for the 
     * right feature, determined by the String sceneCode
     * passed as the argument
     * @param sceneCode the String which contains the 
     * name or code that refers to the right feature
     */
	private void turnOnScene(String sceneCode) {
		sleepTrackerPane.setStyle(""
				+ "-fx-background-color:lightgray; "
				);
		if (sceneCode.equals("Sleep Tracker")) {
			//The below code turn off other feature's interface
			exercisePane.setVisible(false);
			mealPane.setVisible(false);
			
			//The below code open the interface of sleep tracker
			appName.setText("Sleep Tracker");
			sleepTrackerPane.setVisible(true);
		}
		else if (sceneCode.contains("Exercises")) {
			appName.setText("Exercise Recommendation");
			exercisePane.setVisible(true);
			exerciseData.setVisible(true);
			healthStatusText.setVisible(true);
			
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			mealPane.setVisible(false);
			
			//This feature is turned on based on the user preference and also sleep results
			
			if (sceneCode.contains("much") || sceneCode.contains("little")) {// this indicates user had used sleep tracker
				sleepExercisesButton.setVisible(true);
				sleepExercisesButton1.setVisible(true);
				sleepExercisesButton2.setVisible(true);
				sleepActDescription.setVisible(true);
				sleepActDescription2.setVisible(true);
				
			}
			/**
			//over-weight screen
			if (sceneCode.contains("over")) {
				healthStatusText.setText("Health status: You are overweight");
				
				swimmingButton.setVisible(true);
				cyclingButton.setVisible(true);
				runningButton.setVisible(true);
			}
			//under-weight screen
			else if (sceneCode.contains("under")) {
				healthStatusText.setText("Health status: You are underweight");
				
				squatButton.setVisible(true);
				joggingButton.setVisible(true);
				pushUpButton.setVisible(true);
			}
			//normal status screen
			else {
				healthStatusText.setText("Health status: You are normal");
				swimmingButton.setVisible(true);
				cyclingButton.setVisible(true);
				runningButton.setVisible(true);
				squatButton.setVisible(true);
				joggingButton.setVisible(true);
				pushUpButton.setVisible(true);
			}
			*/
		}
		
		else if (sceneCode.contains("Meal")) {
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			exercisePane.setVisible(false);
			
			//Turn on this feature
			appName.setText("Meal Suggestion");
			mealPane.setVisible(true);
			mealOptionText.setVisible(true);
			healthStatusText.setVisible(true);
			//Turn on scene depends on user's preferences and sleep status
			
			if (sceneCode.contains("much") || sceneCode.contains("little")) {
				sleepMealDes.setVisible(true);
				if (sceneCode.contains("under")) {
					//an under-weight shouldn't drink tea, so only show other options
					nutButton.setVisible(true);
					fruitButton.setVisible(true);
				}
				else {
					nutButton.setVisible(true);
					fruitButton.setVisible(true);
					teaButton.setVisible(true);
					if (sceneCode.contains("little")) {
						teaButton.setVisible(false);
					}
				}
			}
			/**
			//over-weight screen
			if (sceneCode.contains("over")) {
				healthStatusText.setText("Health status: You are overweight");
				
				seedButton.setVisible(true);
				vegetableButton.setVisible(true);
				soupButton.setVisible(true);
			}
			//under-weight screen
			else if (sceneCode.contains("under")) {
				healthStatusText.setText("Health status: You are underweight");
				
				porkButton.setVisible(true);
				chickenButton.setVisible(true);
				beefButton.setVisible(true);
			}
			else {
				healthStatusText.setText("Health status: You are normal");
				
				seedButton.setVisible(true);
				vegetableButton.setVisible(true);
				soupButton.setVisible(true);
				porkButton.setVisible(true);
				chickenButton.setVisible(true);
				beefButton.setVisible(true);
			}
			*/
			
		}
		
	}
	//The function below opens and function the meal
	//suggestion feature when the right button is clicked
	@FXML
	public void openMealSuggestion(ActionEvent e) {
		mealSuggestion = new Meal();
		turnOnScene(mealSuggestion.getSuitableHealthStatus(userBMI) + "Meal" + userSleepStatus);
	}

	//The function below opens the exercise
	//sleep tracker feature when the right button is clicked
	@FXML
	public void openSleepTracker(ActionEvent e){
		turnOnScene("Sleep Tracker");
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
	//This function below is triggered when user chooses food pref as 
	//vegetable, which is used to set user preference
    @FXML
    void setPrefToVegetable(ActionEvent event) {
    	mealSuggestion.setPreference("vegetable");
    }
    @FXML
    void setPrefToMeat(ActionEvent event) {
    	mealSuggestion.setPreference("meat");
    }
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
	
}
