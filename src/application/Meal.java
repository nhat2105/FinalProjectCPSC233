package application;

public class Meal extends Activities {
	//Instances include protein information
	//and meal group for meal proportion
	private String mealGroup ="";
	private double protein = 0;
	
	//Lists for catalog info
	private String mealList[] = {"Chicken", "Pork", "Beef", "Soup", "Vegetable", "Seed", "Rice"
			, "Muffin", "Pie", "Salmon", "Pizza", "Hamburger", "Sushi", "Shrimp", "Noodles", "Spaghetti",
			"Apple Juice", "Peach Juice", "Watermelon", "Lemonade", "Mango", "Fruit", "Milk", "Tea"};
	private double mealCaloriesValue[] = {239.0, 242.0, 250.0, 42.0, 65.0, 559.0, 130.0
			, 377.0, 237.0, 208.0, 266.0, 332.0, 90.0, 24.0, 138.0, 158.0,
			46.0, 39.0, 30.0, 40.0, 70.0, 71.0, 42.0, 1.0};
	private double mealProteinValue[] = {27.0, 26.0, 26.0, 4.0, 2.9, 30.0, 2.7
			, 4.5, 1.9, 20.0, 11.0, 17.0, 2.9, 29.0, 4.5, 6.0,
			0.1, .6, .6, .4, .8, .3, 3.4, 0.1};
	private String mealGroupValue[] = {
			"meat", "meat", "meat", "protein", "green", "protein", "protein"
			, "dessert", "dessert", "seafood", "protein", "protein", "protein", "seafood", "protein", "protein",
			"green", "green", "green", "green", "green", "green", "dairy", "tea"
	};
	boolean inMenuList(String itemName) {
		for (int i = 0; i < mealList.length; i++) {
			if (mealList[i].equalsIgnoreCase(itemName)) {
				return true;
			}
		}
		return false;
	}
	public double getCaloriesInfo(String itemName) {
		for (int i = 0; i < mealList.length; i++) {
			if (itemName.equalsIgnoreCase(mealList[i])) {
				return mealCaloriesValue[i];
			}
		}
		return 0;
	}
	public double getProteinInfo(String itemName) {
		for (int i = 0; i < mealList.length; i++) {
			if (itemName.equalsIgnoreCase(mealList[i])) {
				return mealProteinValue[i];
			}
		}
		return 0;
	}
	public String getMealGroupInfo(String itemName) {
		for (int i = 0; i < mealList.length; i++) {
			if (itemName.equalsIgnoreCase(mealList[i])) {
				return mealGroupValue[i];
			}
		}
		return "";
	}
	
	//Constructor with parameters to set name, calories consumption, type of
	//activities and protein information of meal in that order
	public Meal(String code, double calories, String type, double protein) {
		super(code, calories, type);
		setProtein(protein);
	}
	public Meal(Meal another) {
		super(another);
		this.setProtein(another.getProtein());
	}
	
	//Setters and getters for protein and meal group
	public double getProtein() {
		return this.protein;
	} 
	public void setProtein(double protein) {//protein per 100g for now
		this.protein = protein;
	}
	public void setMealGroup(String group) {
		this.mealGroup = group;
	}
	public String getMealGroup() {
		return this.mealGroup;
	}
	//The method below get meal information based on
	//an item's name
	String getMealInfo(String code){
    	setCode(code);
    	setCalories(getCaloriesInfo(code)); 
    	setMealGroup(getMealGroupInfo(code));
    	setProtein(getProteinInfo(code));
		return ("Info: " + getInfo() + ". Pressed the button below to add to your activities list");
    }
	//String representation of get information method, get values based on current object value
	public String getInfo() {
		return "Per 100 gram of this food contains " + getProtein() + "g of protein and " + super.getCaloriesInfo() + " calories";
	}
	//String representation of this activity's name
	public String toString() {
		return "In your meal: " + getCode();
	}
}
