package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ApplicationController {
	
	private double userWeight, userHeight;
	double userBMI;
	
    @FXML
    private TextField userWeightInput;

    @FXML
    private Button startButton;

    @FXML
    private TextField userHeightInput;
    
    @FXML
    public void getUserInfo(ActionEvent e) {
    	setUserHeight(userHeightInput.getText());
    	setUserWeight(userWeightInput.getText());
    	userBMI = userWeight/ ((userHeight/100)*(userHeight/100));
    	System.out.format("Your BMI is: %.1f", userBMI);
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
}
