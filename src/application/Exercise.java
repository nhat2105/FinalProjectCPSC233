package application;

public class Exercise extends Activity {
	//Lists for catalog and their data
	private String[] exerciseList = {"Running", "Jogging", "Swimming", "Push up", "Squat",
			"Cycling", "Weight lifting", "Pulling up", "Tennis", "Basketball", "Soccer",
			"Rugby", "Badminton", "Volleyball", "Crunches", "Yoga", "Meditation", "Aerobics"};
	private double getExerciseCalories(String exerciseName ,double userWeight){
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
	
	
	//Constructor with parameters to set name, calories consumption
	//and type of exercise in that order
	public Exercise(String code, double calories, String type) {
		super(code, calories, type);
	}
	//Copy constructor
	public Exercise(Exercise another) {
		super(another);
	}
	//The method below get activity information based on
	//the catalog information, with argument passed as userWeight
    String getActivityInfo(String code, double userWeight){
    	setCode(code);
    	setCalories(getExerciseCalories(code, userWeight)); 
    	if (code == "notFound") {
    		return "Item not found";
    	}
		return ("Info: This activity consumes " + getCaloriesInfo() + " calories in 30 minutes for you" 
    	 + ". Pressed the button below to add to your activities list");

    	
    }
	//boolean to get whether an exercise is in exercise catalog
	boolean inExerciseList(String exerciseName) {
		for (int i = 0; i < exerciseList.length; i++) {
			if (exerciseList[i].equalsIgnoreCase(exerciseName)) {
				return true;
			}
		}
		return false;
	}
   	public String toString() {
		return "Your activity: " + getCode();
	}
}
