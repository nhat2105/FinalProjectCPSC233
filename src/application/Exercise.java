package application;

public class Exercise {
	public String getSuitableExercises(double BMI) {
		if (BMI >= 25) {
			return "overWeightExercises";
		}
		else if (BMI <= 18.5) {
			return "underWeightExercises";
		}
		else {
			return "allExercises";
		}
	}
	
}
