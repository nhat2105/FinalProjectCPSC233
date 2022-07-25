package application;

public class BMIControl {
	public String getSuitableHealthStatus(double BMI) {
		if (BMI >= 25) {
			return "overWeight";
		}
		else if (BMI <= 18.5) {
			return "underWeight";
		}
		else {
			return "all";
		}
	}
	
}
