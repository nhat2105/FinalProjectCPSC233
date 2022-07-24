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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicationController {
	Stage applicationStage;
	
	private double userWeight, userHeight;
	double userBMI;
	
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
    private Text BMIDisplay;

    @FXML
    private Button sleepTrackerButton;

    @FXML
    private Button exerciseButton;
    
    @FXML
    private TextField userWeightInput;
    
    @FXML
    private TextField userHeightInput;

    @FXML
    private Button BMIButton;

    @FXML
    void getStart(ActionEvent event) throws FileNotFoundException, IOException {
    	calculateUserBMI();
    	switchScene("Main View");
    }


    private void switchScene(String view) throws FileNotFoundException, IOException {
		if (view.equalsIgnoreCase("Main View")) {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/ApplicationView.fxml"));
			Scene scene = new Scene(root, 600, 400);
	    	applicationStage.setScene(scene);
	    	applicationStage.show();
		}
		
	}

	void calculateUserBMI() {
    	setUserHeight(userHeightInput.getText());
    	setUserWeight(userWeightInput.getText());
    	userBMI = getUserWeight()/ ((getUserHeight()/100)*(getUserHeight()/100));
    	System.out.println(String.format("BMI: %.1f", userBMI));

    	
    	/**
    	BMIDisplay.setText(String.format("BMI: %.1f", userBMI));
		heightDisplay.setText("Height: " + String.valueOf(getUserHeight()) + " cm");
		weightDisplay.setText("Weight: " + String.valueOf(getUserWeight()) + " kg");
		*/
    }

   
	@FXML
	public void openSleepTracker(ActionEvent e) throws FileNotFoundException, IOException  {
		//switchScene("Sleep Tracker");
		appName.setText("Sleep Tracker");
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
