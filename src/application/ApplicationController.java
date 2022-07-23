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
import javafx.stage.Stage;

public class ApplicationController {
	Stage applicationStage;
	
	private double userWeight, userHeight;
	double userBMI;
	
	@FXML
	private Button mealsButton;
	
	@FXML
	private Button sleepTrackerButton;
	
	@FXML
	private Button exerciseButton;	
	
	@FXML
    private TextField userWeightInput;

    @FXML
    private Button startButton;

    @FXML
    private TextField userHeightInput;
    
    /**
    @FXML
    public void getStart(ActionEvent e) throws FileNotFoundException, IOException {
    	calculateUserBMI();
    	System.out.println(String.format("Your BMI is: %.1f", userBMI));
    	
    	//Switch to main scene
    	switchScene("src/application/ApplicationView.fxml");
    	
    }
    */
	@FXML
	public void openSleepTracker(ActionEvent e) throws FileNotFoundException, IOException {
		System.out.println("Worked");
		switchScene("src/application/SleepTrackerView.fxml");
		
	}
	
    private void switchScene(String fileInputStream) throws FileNotFoundException, IOException {
    	//Switch screen
    	FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream(fileInputStream));
		Scene scene = new Scene(root, 600, 400);
    	applicationStage.setScene(scene);
    	applicationStage.show();
    	
	}

    
	double getUserWeight() {
		return userWeight;
	}

	void setUserWeight(String userWeight) {
		this.userWeight = Double.parseDouble(userWeight);
	}

	double getUserHeight() {
		return userHeight;
	}

	void setUserHeight(String userHeight) {
		this.userHeight = Double.parseDouble(userHeight);
	}
	
	void calculateUserBMI() {
		setUserHeight(userHeightInput.getText());
    	setUserWeight(userWeightInput.getText());
    	userBMI = getUserWeight()/ ((getUserHeight()/100)*(getUserHeight()/100));
	}
}
