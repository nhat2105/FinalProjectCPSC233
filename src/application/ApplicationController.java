package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicationController {
	Stage applicationStage;

	String userSleepStatus;
	private double userBMI = 0;

	private String userHeight = "0", userWeight = "0";
	
	HealthTracker mainTracker = new HealthTracker();
	SleepTracker sleepTracker;
	Exercises exercises = new Exercises("none", 0, "exercise");
	Meal meal = new Meal("none", 0, "meal", 0);
	ArrayList<String> mealGroupList = new ArrayList<String>();

	//ComboBox
	@FXML
	private ComboBox<String> mealComboBox, exerciseComboBox;
	
	//Menu items
	@FXML
    private MenuItem mealChart, sleepChart;
	
	//Root VBox
    @FXML
    private VBox sleepTrackerRoot;
	
	//Result display text
	@FXML
	private Text sleepResult, BMIDisplay, healthStatusText, toDoDisplay;
	
	//Error text
	@FXML
	private Text hweightErrorText, errorToDoText;
	
	//Result button
    @FXML
    private Button sleepTrackerResultButton;

   //Input text
    @FXML
    private TextField userWeightInput, userHeightInput, removeItemTextField;	
	
    //Meal buttons
	@FXML
	private Button vegetableButton, porkButton, beefButton, chickenButton, soupButton, seedButton;
	@FXML
	private Button milkButton, fruitButton, teaButton;
	@FXML
	private Button addToMenuButton;
	
	
	//Data display text
	@FXML
    private Text appName, caloriesConsumptionText, weightChangeText, suggestionText, removeToDoText;
	@FXML
    private Text sleepActDescription, sleepActDescription2, sleepMealDes, activitiesInfoText, mealInfoText;


    //Feature button
    @FXML
    private Button sleepTrackerButton, exerciseButton, getStartButton, mealsButton, removeItemButton;

    //Pane
    @FXML
    private Pane exercisePane, sleepTrackerPane, mealPane;
    
    //Exercise button
    @FXML
    private Button yogaButton, aerobicsButton, meditationButton, addActListButton, exerciseSearchButton;
    
    //For sleep inputs control
    ArrayList<TextField> allSleepInputsTextFields = new ArrayList<TextField>();

	private String s;

    //The function below takes in user inputs for their height and weights
    @FXML
    void getStart(ActionEvent event) throws FileNotFoundException, IOException{
    	//Validate input first
    	try {

			mainTracker.validateInput(userHeightInput.getText(), 215, 1);

			mainTracker.validateInput(userWeightInput.getText(), 130, 1);
			this.userHeight = userHeightInput.getText();
			mainTracker.setUserHeight(this.userHeight);
			this.userWeight = userWeightInput.getText();
			mainTracker.setUserWeight(this.userWeight);

		    switchScene("Main View");
			
		} catch (InvalidInputException iie) {
			hweightErrorText.setText(iie.getMessage());		
		}
   }

    
    /**
    * @param view (switch to main view)
     * @param  
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
	    	
			Scene scene = new Scene(root, 600, 420);
			
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
		boolean errorFree = true;
		sleepTracker = new SleepTracker();

		//Validate input
		for (TextField sleepInput: allSleepInputsTextFields) {
			try {
				mainTracker.validateInput(sleepInput.getText(), 24, 0);		
				
			} catch (InvalidInputException e1) {
				errorFree = false;
				sleepResult.setText(e1.getMessage());

			}
			
		}

		if (errorFree) {
			String sleepHoursTrack = sleepTracker.getSleepResult(allSleepInputsTextFields);
			sleepResult.setText(sleepHoursTrack);
			sleepResult.setVisible(true);
			userSleepStatus = sleepTracker.getSleepStatus();
			if (userSleepStatus != null) {
				healthStatusText.setText("Health status: " + userSleepStatus + " sleep");
				healthStatusText.setVisible(true);
			}
		}
		
		
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
		if (!mainTracker.getHealthStatus(userBMI).contains("normal")) {
			suggestionText.setText("Suggestion food: " + mainTracker.getFoodSuggestion() + "\n" 
			+ "Suggestion exercises: "+mainTracker.getExerciseSuggestion()); 
		}
		
		healthStatusText.setText("Health status: " + mainTracker.getHealthStatus(userBMI));
		
		sleepTrackerPane.setStyle(""
				+ "-fx-background-color:lightgray; "
				);
		if (sceneCode.equals("Sleep Tracker")) {
			//The below code turn off other feature's interface
			exercisePane.setVisible(false);
			mealPane.setVisible(false);
			
			//The below code open the interface of sleep tracker
			appName.setText("Sleep Tracker");
			
			//remove old data if there's any
			allSleepInputsTextFields.clear();
			sleepTrackerRoot.getChildren().clear();
			sleepTrackerRoot.getChildren().add(sleepResult);
			
			sleepTrackerPane.setVisible(true);
			
			
			for (int i = 0; i < 7; i++) {
				HBox sleepInputRow = new HBox();
				Label sleepInputLabel = new Label("Day " + (i+1)+ ": ");
				TextField sleepInputTextField = new TextField();
				
				allSleepInputsTextFields.add(sleepInputTextField);
				
				sleepInputRow.getChildren().addAll(sleepInputLabel, sleepInputTextField);
				sleepTrackerRoot.getChildren().add(sleepInputRow);
				
				
			}
		}
		else if (sceneCode.contains("inExercises")) {
			appName.setText("Exercise Recommendation");
			exercisePane.setVisible(true);
			healthStatusText.setVisible(true);
			addActListButton.setVisible(false);
			
			//Turn off other features
			sleepTrackerPane.setVisible(false);
			mealPane.setVisible(false);
			
			if (sceneCode.contains("opening")) {
				activitiesInfoText.setVisible(false);
			}
			
			//This feature is turned on based on the and also sleep results
			if (sceneCode.contains("much") || sceneCode.contains("little")) {// this indicates user had used sleep tracker
				yogaButton.setVisible(true);
				aerobicsButton.setVisible(true);
				meditationButton.setVisible(true);
				sleepActDescription.setVisible(true);
				sleepActDescription2.setVisible(true);
			}
			if (!sceneCode.contains("much") && !sceneCode.contains("little")) { //turn off when user has good sleep
				yogaButton.setVisible(false);
				aerobicsButton.setVisible(false);
				meditationButton.setVisible(false);
				sleepActDescription.setVisible(false);
				sleepActDescription2.setVisible(false);
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
				mealInfoText.setVisible(false);
				addToMenuButton.setVisible(false);
				
			}
			//Turn on scene depends on sleep status
			
			if (sceneCode.contains("much") || sceneCode.contains("little")) {
				sleepMealDes.setVisible(true);
				milkButton.setVisible(true);
				teaButton.setVisible(true);
				fruitButton.setVisible(true);
			}
			//Turn off suggestion for sleep if user has good sleep
			else if (!sceneCode.contains("much") && !sceneCode.contains("little")) {
				sleepMealDes.setVisible(false);
				milkButton.setVisible(false);
				teaButton.setVisible(false);
				fruitButton.setVisible(false);
			}
		}
		
	}
	/*The following method opens the right feature when a feature is clicked
	 * getSource method ensures the right button is associated with the right
	 * screen
	 */
    @FXML
    void openFeature(ActionEvent ae) {
    	if (ae.getSource() == exerciseButton) {
        	turnOnScene("inExercisesopening" + userSleepStatus);
    	}
    	if (ae.getSource() == mealsButton) {
    		turnOnScene("inMealopening" + userSleepStatus);
    	}
    	if (ae.getSource() == sleepTrackerButton) {
    		turnOnScene("Sleep Tracker");
    	}
    	
    }
 
 
    
    /*The following function get the information of 
     * each exercise and each user's weight
     */
    @FXML
    void getInfo(ActionEvent ae) {
    	String actCode = "";
    	addActListButton.setVisible(true);
    	if (ae.getSource() == exerciseComboBox) {
    		actCode = ((String) exerciseComboBox.getValue());
    	}

    	if (ae.getSource() == yogaButton) {
    		actCode = "Yoga";
    	}
    	if (ae.getSource() == meditationButton) {
    		actCode = "Meditation";
    	}
    	if (ae.getSource() == aerobicsButton) {
    		actCode = "Aerobics";
    	}
    	exercises.setCode(actCode);
    	exercises.setCaloriesInfo(exercises.getExerciseCalories(actCode, mainTracker.getUserWeight())); 
    	
		activitiesInfoText.setText("Info: " + exercises.getInfo() + ". Pressed the button below to add to your activities list");
    	activitiesInfoText.setVisible(true);
    }
    /*The following function get the basic information of each
     * food in the meal panel
     */
    @FXML
    void getMealInfo(ActionEvent ae) {
    	addToMenuButton.setVisible(true);
    	String mealCode = "";
    	String mealGroup = "";
    	double caloriesInfo = 0;
    	double proteinInfo = 0;
    	if (ae.getSource() == mealComboBox)mealCode = (String) mealComboBox.getValue();
    	if (ae.getSource() == fruitButton) {
    		mealCode = "fruit";
    		caloriesInfo = 71;
    		proteinInfo = 0.3;
    		mealGroup = "green";
    	}
    	if (ae.getSource() == milkButton) {
    		mealCode = "milk";
    		caloriesInfo = 42;
    		proteinInfo = 3.4;
    		
    	}
    	if (ae.getSource() == teaButton) {
    		mealCode = "tea";
    		caloriesInfo = 1;
    		proteinInfo = 0.1;
    		
    	}
    	if (mealCode.equals("Vegetable")) {
    		caloriesInfo = 65;
    		proteinInfo = 2.9;
    		mealGroup = "green";
    	}
    	if (mealCode.equals("Soup")){
    		caloriesInfo = 42;
    		proteinInfo = 4;
    		
    	}
    	if (mealCode.equals("Seed")) {
    		caloriesInfo = 559;
    		proteinInfo = 30;
    		mealGroup = "protein";
    	}
    	if (mealCode.equals("Chicken")) {
    		caloriesInfo = 239;
    		proteinInfo = 27;
    		mealGroup = "meat";
    	}
    	if (mealCode.equals("Beef")) {
    		caloriesInfo = 250;
    		proteinInfo = 26;
    		mealGroup = "meat";
    	}
    	if (mealCode.equals("Pork")) {
    		caloriesInfo = 242;
    		proteinInfo = 27;
    		mealGroup = "meat";
    	}
    	if (mealCode.equals("Rice")) {
    		caloriesInfo = 130;
    		proteinInfo = 2.7;
    		mealGroup = "protein";
    	}
    	if (mealCode.equals("Muffin")) {
    		caloriesInfo = 377;
    		proteinInfo = 4.5;
    		mealGroup = "dessert";
    	}
    	if (mealCode.equals("Pie")) {
    		caloriesInfo = 237;
    		proteinInfo = 1.9;
    		mealGroup = "dessert";
    	}
    	if (mealCode.equals("Pizza")) {
    		caloriesInfo = 266;
    		proteinInfo = 11;
    		mealGroup = "protein";
    	}
    	if (mealCode.equals("Hamburger")) {
    		caloriesInfo = 332;
    		proteinInfo = 17;
    		mealGroup = "protein";
    	}
    	if (mealCode.equals("Sushi")) {
    		caloriesInfo = 90;
    		proteinInfo = 2.9;
    		mealGroup = "protein";
    	}
    	if (mealCode.equals("Salmon")) {
    		caloriesInfo = 208;
    		proteinInfo = 20;
    		mealGroup = "seafood";
    	}
    	if (mealCode.equals("Shrimp")) {
    		caloriesInfo = 24;
    		proteinInfo = 2.9;
    		mealGroup = "seafood";
    	}
    	if (mealCode.equals("Noodles")) {
    		caloriesInfo = 138;
    		proteinInfo = 4.5;
    		mealGroup = "protein";
    	}
    	if (mealCode.equals("Apple juice")) {
    		caloriesInfo = 46;
    		proteinInfo = 0.1;
    		mealGroup = "green";
        
    	}
    	if (mealCode.equals("Lemonade")) {
    		caloriesInfo = 40;
    		proteinInfo = .4;
    		mealGroup = "green";

    	}
    	if (mealCode.equals("Peach")) {
    		caloriesInfo = 39;
    		proteinInfo = .6;
    		mealGroup = "green";

    	}
    	if (mealCode.equals("Watermelon")) {
    		caloriesInfo = 30;
    		proteinInfo = .6;
    		mealGroup = "green";

    	}
    	if (mealCode.equals("Mango")) {
    		caloriesInfo = 70;
    		proteinInfo = .8;
    		mealGroup = "green";

    	}
    	meal.setCode(mealCode);
    	meal.setProteinInfo(proteinInfo);
    	meal.setCaloriesInfo(caloriesInfo);
    	meal.setMealGroup(mealGroup);
		mealInfoText.setText("Info: " + meal.getInfo() + ". Pressed the button below to add to your activities list");
    	mealInfoText.setVisible(true);
    }

    //TODO final touch
    //List for the catalog
    //Add comments on each function
    //Include function which user can find max or min calories consumption and such
    //Sleep disorder function (if any entry is higher than 12 or lower than 1)
    //Hashmap for the catalog

    
    @FXML
    void addFoodToMenu(ActionEvent e) {
    	Meal foodToAdd = new Meal(meal.getCode(), meal.getCaloriesInfo(), "meal", meal.getProteinInfo());
    	mealGroupList.add(meal.getMealGroup());
    	String errorFree = mainTracker.addToTodo(foodToAdd);
    	mainTracker.addCalories(foodToAdd.getCaloriesInfo());
    	errorToDoText.setText(errorFree);
    	toDoDisplay.setText(mainTracker.getToDoList());
    	removeToDoText.setVisible(true);
    	removeItemButton.setVisible(true);
    	removeItemTextField.setVisible(true);
    	
    	int caloriesConsumption = (int)mainTracker.getCaloriesConsumption();
    	caloriesConsumptionText.setText("Total calories: " + caloriesConsumption);
    	weightChangeText.setText("After a month, you will gain " 
    	+ mainTracker.convertWeightChange(caloriesConsumption) + " kg per month");
    
    }
    @FXML
    void removeItemFromToDo(ActionEvent e) {
    	String indexToRemove = removeItemTextField.getText();
    	try {
			mainTracker.validateInput(indexToRemove, mainTracker.getToDoSize(), 1);
			mainTracker.remove(indexToRemove);
			errorToDoText.setText("");
		} catch (InvalidInputException e1) {
			errorToDoText.setText(e1.getMessage());
		}
    	//Update the scene
    	toDoDisplay.setText(mainTracker.getToDoList());
    	int caloriesConsumption = (int)mainTracker.getCaloriesConsumption();
    	caloriesConsumptionText.setText("Total calories "+ String.valueOf(caloriesConsumption));
    	weightChangeText.setText("After a month, you will gain " 
    	    	+ mainTracker.convertWeightChange(caloriesConsumption) + " kg per month");
    	
    	    	
    }
    @FXML
    void addExerciseToList(ActionEvent e) {
    	Exercises exerciseToAdd = new Exercises(exercises.getCode(), exercises.getCaloriesInfo(), "exercise");
    	String errorFree = mainTracker.addToTodo(exerciseToAdd);
    	if (errorFree == "")mainTracker.addCalories(-exerciseToAdd.getCaloriesInfo());
    	errorToDoText.setText(errorFree);

    	toDoDisplay.setText(mainTracker.getToDoList());
    	removeToDoText.setVisible(true);
    	removeItemButton.setVisible(true);
    	removeItemTextField.setVisible(true);
    	
    	int caloriesConsumption = (int)mainTracker.getCaloriesConsumption();
    	caloriesConsumptionText.setText("Total calories: " + caloriesConsumption);
    	weightChangeText.setText("With this, you will gain " 
    	+ mainTracker.convertWeightChange(caloriesConsumption) +" kg per month");	
    }

    @FXML 
    void searchItem(ActionEvent event){
    	if (event.getSource() == exerciseSearchButton) {
    		/**
    		if (mainTracker.inExerciseList(exerciseComboBox.getValue())) {
    			exercises.setCode(exerciseComboBox.getValue());
    			//Not quite done
    			//exercises.setCalories(120);
    		}
    		*/
    	}
    }
    
    @FXML
    void openChartWindow(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			
			VBox root = loader.load(new FileInputStream("src/application/ChartView.fxml"));
			ChartWindowController chartController = loader.getController();
			Stage chartWindow = new Stage();
			Scene scene = new Scene(root, 600, 420);
			
			if (event.getSource() == mealChart) {
	    		chartController.createPieChart(mealGroupList);		
	    	}
	    	else if (event.getSource() == sleepChart) {
	    		chartController.createLineChart(allSleepInputsTextFields);
	    	}
	    	
			chartWindow.setScene(scene);
			chartWindow.setTitle("Chart Window");
			
			
			chartWindow.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    
    }
   
}
