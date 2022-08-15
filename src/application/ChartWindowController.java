package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

public class ChartWindowController {
	//FXML instances
	@FXML
	private LineChart<String, Number> sleepLineChart;
	@FXML
	private PieChart mealPieChart; 
		
	//This method takes in all user sleep inputs in one week and create a line
	//chart based on that information
	//Cre (YouTube Channel): Cool IT Help
	public void createLineChart(ArrayList<TextField> allSleepInputs) {
		sleepLineChart.setVisible(true);
		mealPieChart.setVisible(false);
		XYChart.Series<String, Number> sleepSeries = new XYChart.Series<String, Number>();
		int dayNumber = 1;
		//Loop through the Array List and set information accordingly
		for (TextField sleepInput: allSleepInputs) {
			sleepSeries.getData().add(new XYChart.Data<String, Number>("Day " + dayNumber, Double.parseDouble(sleepInput.getText())));
			dayNumber++;
		}
		
		sleepLineChart.getData().add(sleepSeries);
	}
	//The method below creates a pie chart for user's meal proportion
	//based on a group list
	//Cre (YouTube Channel): Professor Saad
	public void createPieChart(ArrayList<String> mealGroupList) {
		//turn off other charts, turn on this chart
		sleepLineChart.setVisible(false);
		mealPieChart.setVisible(true);
		//Loop through the array list and add counter for each value
		int dessertValue = 0, seafoodValue = 0, meatValue = 0, proteinValue=0, greenValue = 0;
		for (String s: mealGroupList) {
			if (s.equals("green")) {
				greenValue++;
			}
			else if (s.equals("dessert")) {
				dessertValue++;
			}
			else if (s.equals("protein")) {
				proteinValue++;
			}
			else if (s.equals("seafood")) {
				seafoodValue++;
			}
			else if (s.equals("meat")) {
				meatValue++;
			}
		}
		//Create a pie chart accordingly from the data passed
		ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
				new PieChart.Data("Fruit and Vegetable", greenValue),
				new PieChart.Data("Seafood", seafoodValue),
				new PieChart.Data("Meat", meatValue),
				new PieChart.Data("Protein", proteinValue),
				new PieChart.Data("Dessert", dessertValue)
				);
		mealPieChart.setData(pieData);
	}
}
