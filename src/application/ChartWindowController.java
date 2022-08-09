package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
public class ChartWindowController {
	@FXML
	LineChart<String, Number> sleepLineChart;
	
	
	public void createLineChart(ArrayList<TextField> allSleepInputs) {//take some inputs from other window, then create it
		XYChart.Series<String, Number> sleepSeries = new XYChart.Series<String, Number>();
		int dayNumber = 1;
		for (TextField sleepInput: allSleepInputs) {
			sleepSeries.getData().add(new XYChart.Data<String, Number>("Day " + dayNumber, Double.parseDouble(sleepInput.getText())));
			dayNumber++;
		}
		
		sleepLineChart.getData().add(sleepSeries);
	}

	public void createBarChart() {
	}

	public void createPieChart() {
		
		
	}
}
