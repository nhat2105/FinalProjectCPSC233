package application;

public class Exercises extends Activities {
	private String[] exerciseList = {"Running", "Jogging", "Swimming", "Push up", "Squat",
			"Cycling", "Weight lifting", "Pulling up", "Tennis", "Basketball", "Soccer",
			"Rugby", "Badminton", "Volleyball", "Crunches", "Yoga", "Meditation", "Aerobics"};
	double getExerciseCalories(String exerciseName ,double userWeight){
		Double[] exerciseValue = {6.0375*userWeight, 2.625*userWeight, 250.0, 210.0, 240.0,
				3.78 * userWeight, 2.52 * userWeight, 2 * userWeight, 4.2 * userWeight, 274.0, 300.0,
				317.0, 114.0, 298.0, 214.0, 100.0, 35.0, 85.0};
		for (int i = 0; i < exerciseList.length; i++) {
			if (exerciseName.equalsIgnoreCase(exerciseList[i])) {
				return exerciseValue[i];
			}
		}
		return 0;
		
	}
	
	public Exercises(String code, double calories, String type) {
		super(code, calories, type);
	}
	
	boolean inExerciseList(String exerciseName) {
		for (int i = 0; i < exerciseList.length; i++) {
			if (exerciseList[i].equalsIgnoreCase(exerciseName)) {
				return true;
			}
		}
		return false;
	}
	

	public void setCaloriesInfo(double caloriesInfo) {
		this.calories = caloriesInfo;
	}

	//String representation of get information
	String getInfo() {
		return "This activity consumes " + getCaloriesInfo() + " calories in 30 minutes for you";
	}
	public String toString() {
		return "Your activity: " + getCode();
	}
}
