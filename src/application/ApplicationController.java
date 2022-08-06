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

	String userSleepStatus;
	private double userBMI;

	private String userHeight, userWeight;
	
	HealthTracker mainTracker = new HealthTracker();
	Meal mealSuggestion;
	SleepTracker sleepTracker;
	Exercises exercises;
	
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
	private Button vegeOption, meatOption, bothOption, cardioOption, mildOption, bothEOption;
	
	
	//Data display text
	@FXML
    private Text weightDisplay, heightDisplay, appName, sleepData, eatingData, exerciseData, mealOptionText;
	@FXML
    private Text sleepActDescription, sleepActDescription2, sleepMealDes, exerciseOptionText;


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
    	String errorFreeHeightInput = mainTracker.validateInput(userHeightInput.getText(), 215, 1);
    	String errorFreeWeightInput = mainTracker.validateInput(userWeightInput.getText(), 130, 1);
    	if (errorFreeHeightInput == "" && errorFreeWeightInput == "") {
	    	this.userHeight = userHeightInput.getText();
	    	this.userWeight = userWeightInput.getText();
	    	mainTracker.setUserHeight(this.userHeight);
	    	mainTracker.setUserWeight(this.userWeight);
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
			
			//The below codes pass data (user's weight and height )between scenes
			ApplicationController mainController = loader.getController();
		
			mainController.userHeight = (String.valueOf(mainTracker.getUserHeight()));
			mainController.userWeight = (String.valueOf(mainTracker.getUserWeight()));	
			mainController.userBMI = mainTracker.getUserWeight()/ ((mainTracker.getUserHeight()/100)*(mainTracker.getUserHeight()/100));
	    	
			Scene scene = new Scene(root, 600, 400);
			
	    	applicationStage.setScene(scene);
	    	applicationStage.show();

	    	
		}
		
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
		String errorFreeInput = mainTracker.validateInput(sleepInput.getText(), 24 * 7, 0);
		
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
    	exercises = new Exercises();
    	turnOnScene("inExercisesopening" + userSleepStatus);
    }
    
    /**
     * The function below turns on the right for the 
     * right feature, determined by the String sceneCode
     * passed as the argument
     * @param sceneCode the String which contains the 
     * name or code that refers to the right feature
     */
	private void turnOnScene(String sceneCode) {
		mainTracker.updateUserData(userHeight, userWeight, userBMI);
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
		else if (sceneCode.contains("inExercises")) {
			appName.setText("Exercise Recommendation");
			exercisePane.setVisible(true);
			exerciseData.setVisible(true);
			healthStatusText.setVisible(true);
			
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			mealPane.setVisible(false);
			
			if (sceneCode.contains("opening")) {
				exerciseOptionText.setVisible(true);
			}
			else if (!sceneCode.contains("opening")) {
				
				exerciseOptionText.setText("");
				cardioOption.setVisible(false);
				mildOption.setVisible(false);
				bothEOption.setVisible(false);
			}
			
			//This feature is turned on based on the user preference and also sleep results
			
			if (sceneCode.contains("much") || sceneCode.contains("little")) {// this indicates user had used sleep tracker
				sleepExercisesButton.setVisible(true);
				sleepExercisesButton1.setVisible(true);
				sleepExercisesButton2.setVisible(true);
				sleepActDescription.setVisible(true);
				sleepActDescription2.setVisible(true);
				
			}
		if (sceneCode.contains("cardio")) {	
			
			swimmingButton.setVisible(true);
			cyclingButton.setVisible(true);
			runningButton.setVisible(true);
		}
		//mild activities
		else if (sceneCode.contains("mild")) {
			squatButton.setVisible(true);
			joggingButton.setVisible(true);
			pushUpButton.setVisible(true);
		}
		//both
		else if (sceneCode.contains("bothE")){

			swimmingButton.setVisible(true);
			cyclingButton.setVisible(true);
			runningButton.setVisible(true);
			squatButton.setVisible(true);
			joggingButton.setVisible(true);
			pushUpButton.setVisible(true);
		}
			
	}
		
		else if (sceneCode.contains("inMeal")) {
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			exercisePane.setVisible(false);
				
			
			//Turn on this feature
			appName.setText("Meal Suggestion");
			mealPane.setVisible(true);
			healthStatusText.setVisible(true);
			if (sceneCode.contains("opening")) {//If it is still the main screen
				mealOptionText.setVisible(true);
			}
			else if (!sceneCode.contains("opening")) {
				mealOptionText.setText("");
				bothOption.setVisible(false);
				vegeOption.setVisible(false);
				meatOption.setVisible(false);
			}
				
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
			//vege screen
		if (sceneCode.contains("vegetable")) {
			
			
			seedButton.setVisible(true);
			vegetableButton.setVisible(true);
			soupButton.setVisible(true);
			
		}
			//meat screen
		else if (sceneCode.contains("meat")) {
			
			porkButton.setVisible(true);
			chickenButton.setVisible(true);
			beefButton.setVisible(true);
		}
			//both screen
		else if (sceneCode.contains("bothM")){
			//healthStatusText.setText("Health status: You are normal");
			
			seedButton.setVisible(true);
			vegetableButton.setVisible(true);
			soupButton.setVisible(true);
			porkButton.setVisible(true);
			chickenButton.setVisible(true);
			beefButton.setVisible(true);
			}
		}
		
	}
	//The function below opens and function the meal
	//suggestion feature when the right button is clicked
	@FXML
	public void openMealSuggestion(ActionEvent e) {
		mealSuggestion = new Meal();
		turnOnScene("inMealopening" + userSleepStatus);
	}

	//The function below opens the exercise
	//sleep tracker feature when the right button is clicked
	@FXML
	public void openSleepTracker(ActionEvent e){
		turnOnScene("Sleep Tracker");
	}
	//This function below is triggered when user chooses food pref as 
	//vegetable, which is used to set user preference
    @FXML
    void setPrefToVegetable(ActionEvent event) {
    	mealSuggestion.setPreference("vegetable");
    	turnOnScene("vegetableinMeal");
    }
    @FXML
    void setPrefToMeat(ActionEvent event) {
    	mealSuggestion.setPreference("meat");
    	turnOnScene("meatinMeal");
    }
    @FXML
    void setPrefToBothM(ActionEvent event) {
    	mealSuggestion.setPreference("both");
    	turnOnScene("bothMinMeal");
    }
 
    @FXML
    void setPrefToMild(ActionEvent event) {
    	exercises.setPreference("mild");
    	turnOnScene("mildinExercises");
    }
    @FXML
    void setPrefToCardio(ActionEvent event) {
    	exercises.setPreference("cardio");
    	turnOnScene("cardioinExercises");
    }
    @FXML
    void setPrefToBothE(ActionEvent event) {
    	exercises.setPreference("both");
    	turnOnScene("bothEinExercises");
    }
}
