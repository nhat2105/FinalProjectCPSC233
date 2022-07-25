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

	@FXML
	private Text sleepResult, BMIDisplay, healthStatusText, recommendActText;
	

    @FXML
    private Button sleepTrackerResultButton;

    @FXML
    private TextField sleepInput, userWeightInput, userHeightInput;	
	@FXML
	private Text sleepData, eatingData, exerciseData, mealSuggestionText;	
	
	@FXML
	private Button calculateBMIButton, vegetableButton, porkButton, riceButton, chickenButton, soupButton, salmonButton;
	
	@FXML
    private Text weightDisplay;

    @FXML
    private Text heightDisplay;

    @FXML
    private Text appName;

    @FXML
    private Button mealsButton;


    @FXML
    private Button sleepTrackerButton, exerciseButton, BMIButton;

    @FXML
    private Pane exercisePane, sleepTrackerPane, mealPane;

    @FXML
    private Button squatButton;

    @FXML
    private Button joggingButton;

    @FXML
    private Button cyclingButton;


    @FXML
    private Button swimmingButton;

    @FXML
    private Button runningButton;

    @FXML
    private Button pushUpButton;

    //The function below takes in user inputs for their height and weights
    @FXML
    void getStart(ActionEvent event) throws FileNotFoundException, IOException {
    	
    	setUserHeight(userHeightInput.getText());
    	setUserWeight(userWeightInput.getText());
    	switchScene("Main View");
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
			//The below codes pass data between scenes
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
	
	//The function below get the sleep tracker
	//result when the right button is clicked
	@FXML
	public void getSleepResult(ActionEvent e) {
		SleepTracker sleepTrack = new SleepTracker();
		String sleepHoursTrack = sleepTrack.getSleepResult(sleepInput.getText());
		sleepResult.setText(sleepHoursTrack);
		sleepResult.setVisible(true);
		sleepData.setVisible(true);
	}
	
	//The function below opens and function the exercise
	//suggestion feature when the right button is clicked
    @FXML
    void openExercise(ActionEvent event) {
    	BMIControl exercises = new BMIControl();
    	turnOnScene(exercises.getSuitableHealthStatus(userBMI) + "Exercises");
    }
    
    //The function below opens the right screen
    //for the right feature
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
			recommendActText.setVisible(true);
			healthStatusText.setVisible(true);
			
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			mealPane.setVisible(false);
			
			//This feature is turned on based on the BMI result
			if (sceneCode.contains("over")) {
				healthStatusText.setText("Health status: You are overweight");
				
				swimmingButton.setVisible(true);
				cyclingButton.setVisible(true);
				runningButton.setVisible(true);
			}
			else if (sceneCode.contains("under")) {
				healthStatusText.setText("Health status: You are underweight");
				
				squatButton.setVisible(true);
				joggingButton.setVisible(true);
				pushUpButton.setVisible(true);
			}
			else {
				healthStatusText.setText("Health status: You are normal");
				swimmingButton.setVisible(true);
				cyclingButton.setVisible(true);
				runningButton.setVisible(true);
				squatButton.setVisible(true);
				joggingButton.setVisible(true);
				pushUpButton.setVisible(true);
			}
		}
		else if (sceneCode.contains("Meal")) {
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			exercisePane.setVisible(false);
			
			//Turn on this feature
			appName.setText("Meal Suggestion");
			mealPane.setVisible(true);
			healthStatusText.setVisible(true);
			//Turn on scene depends on health status
			if (sceneCode.contains("over")) {
				healthStatusText.setText("Health status: You are overweight");
				
				salmonButton.setVisible(true);
				vegetableButton.setVisible(true);
				soupButton.setVisible(true);
			}
			else if (sceneCode.contains("under")) {
				healthStatusText.setText("Health status: You are underweight");
				
				porkButton.setVisible(true);
				chickenButton.setVisible(true);
				riceButton.setVisible(true);
			}
			else {
				healthStatusText.setText("Health status: You are normal");
				
				salmonButton.setVisible(true);
				vegetableButton.setVisible(true);
				soupButton.setVisible(true);
				porkButton.setVisible(true);
				chickenButton.setVisible(true);
				riceButton.setVisible(true);
			}
			
		}
		
	}
	//The function below opens and function the meal
	//suggestion feature when the right button is clicked
	@FXML
	public void openMealSuggestion(ActionEvent e) {
		BMIControl mealSuggestion = new BMIControl();
		turnOnScene(mealSuggestion.getSuitableHealthStatus(userBMI) + "Meal");
	}

	//The function below opens the exercise
	//sleep tracker feature when the right button is clicked
	@FXML
	public void openSleepTracker(ActionEvent e){
		turnOnScene("Sleep Tracker");
	}


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
	
}
