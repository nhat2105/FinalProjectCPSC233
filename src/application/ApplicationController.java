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
	private Text sleepResult, BMIDisplay;
	

    @FXML
    private Button sleepTrackerResultButton;

    @FXML
    private TextField sleepInput, userWeightInput, userHeightInput;	
	@FXML
	private Text sleepData, eatingData, exerciseData;	
	
	@FXML
	private Button calculateBMIButton;
	
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
    private Pane exercisePane, sleepTrackerPane;

    @FXML
    private Button squatButton;

    @FXML
    private Button joggingButton;

    @FXML
    private Button cyclingButton;

    @FXML
    private Text healthStatusText;

    @FXML
    private Button swimmingButton;

    @FXML
    private Button runningButton;

    @FXML
    private Button pushUpButton;

    @FXML
    void getStart(ActionEvent event) throws FileNotFoundException, IOException {
    	
    	setUserHeight(userHeightInput.getText());
    	setUserWeight(userWeightInput.getText());
    	switchScene("Main View");
    }


    
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
	@FXML
	public void getSleepResult(ActionEvent e) {
		SleepTracker sleepTrack = new SleepTracker();
		String sleepHoursTrack = sleepTrack.getSleepResult(sleepInput.getText());
		sleepResult.setText(sleepHoursTrack);
		sleepResult.setVisible(true);
		sleepData.setVisible(true);
	}
	
    @FXML
    void openExercise(ActionEvent event) {
    	Exercise exercises = new Exercise();
    	turnOnScene(exercises.getSuitableExercises(userBMI));
    }

	private void turnOnScene(String sceneCode) {
		sleepTrackerPane.setStyle(""
				+ "-fx-background-color:lightgray; "
				);
		if (sceneCode.equals("Sleep Tracker")) {
			//The below code turn off other feature's interface
			exercisePane.setVisible(false);
			
			//The below code open the interface of sleep tracker
			appName.setText("Sleep Tracker");
			sleepTrackerPane.setVisible(true);
		}
		else if (sceneCode.contains("Exercises")) {
			appName.setText("Exercise Recommendation");
			exercisePane.setVisible(true);
			exerciseData.setVisible(true);
			
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			
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
		
	}



	@FXML
	public void openSleepTracker(ActionEvent e)  throws FileNotFoundException, IOException{
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
