import java.util.ArrayList;

public class Menu {
	//String[] listOfButties = {"Beef Pops with Pineapple and Parsley Sauce", "Pizza Skewers", "Cheese and bacon Pinwheels" ,"Quick Herb and Cheese Monkey Bread",
           // "Heston's BBQ Chicken Wings", "Scotch quail eggs", "Crispy Turnip Cake with Chilli Sauce", "Potage of vegetables with poached duck egg and fresh herbs","Chocolate Flapjack Cakes", "Parmesan Potato Pancake","Chilled avocado soup with tortilla chips", "Sweet and Sour Couscous-Stuffed Peppers"};
	public static Meal[] STARTERS = new Meal[]{
			new Meal(300,300,MealType.STARTER,"Beef Pops with Pineapple and Parsley Sauce"),
			new Meal(310,330,MealType.STARTER,"Pizza Skewers"),
			new Meal(330,330,MealType.STARTER,"Cheese and bacon Pinwheels"),
			new Meal(320,320,MealType.STARTER,"Quick Herb and Cheese Monkey Bread")
	};
	
	
	 //String[] listOfButties = {"Marsala Marinated Skirt Steak", "Orange and Milk-Braised Pork Carnitas", "Chicken and Pasta Casserole with Mixed Vegetable","Boneless Pork Chop with Shallot Mustard Sauce", "Pulled Pork Burritos", "Shrimp scampi with pasta", 
    //         "Chicken Marsala","Caprese Salad with Grilled Flank Steak", "Italian Hot Turkey Sausage and Black-Eyed Peas", "Swordfish a la Siciliana", "Linguine with Seafood and Sundried Tomatoes", "Pasta with Tuna, Sun-Dried Tomatoes, Artichoke Hearts, Lemon, and White Wine"};
	public static Meal[] MAINS = new Meal[]{
			new Meal(500,500,MealType.MAIN,"Marsala Marinated Skirt Steak"),
			new Meal(510,530,MealType.MAIN,"Orange and Milk-Braised Pork Carnitas"),
			new Meal(530,530,MealType.MAIN,"Chicken and Pasta Casserole with Mixed Vegetable"),
			new Meal(520,520,MealType.MAIN,"Boneless Pork Chop with Shallot Mustard Sauce")
	};
	
	
	//String[] listOfButties = {"Bitter sweet Chocolate Cheese Pie", "Croissant Bread Pudding", "Banana berries Foster", "Pineapple Cheesecake", "Nutella hazelnut spread and banana mini calzones",
	//"Blood orange polenta cake","Milk chocolate fudge cake","Sticky toffee pudding","Served with hot butterscotch sauce and vanilla ice cream", "Honeycomb Smash Cheesecake"};
	public static Meal[] DESSERTS = new Meal[]{
			new Meal(200,500,MealType.DESSERT,"Bitter sweet Chocolate Cheese Pie"),
			new Meal(210,230,MealType.DESSERT,"Croissant Bread Pudding"),
			new Meal(230,230,MealType.DESSERT,"Banana berries Foster"),
			new Meal(220,220,MealType.DESSERT,"Pineapple Cheesecake")
	};
	
	
    //String[] listOfButties = {"Orange and Passion Fruit", "Apple and Raspberry", "Ocean Spray", "Peach flavored ice tea", "Apple Juice", "Mango Juice", "Orange Juice", "Coke", "Pepsi", "Fanta", "Sprite"};
	public static Meal[] DRINKS = new Meal[]{
			new Meal(500,500,MealType.DRINKS,"Orange and Passion Fruit"),
			new Meal(510,530,MealType.DRINKS,"Apple and Raspberry"),
			new Meal(530,530,MealType.DRINKS,"Ocean Spray"),
			new Meal(520,520,MealType.DRINKS,"Peach flavored ice tea")
	};
	
	
	public static ArrayList<String> getMeals(int type){
		ArrayList<String> meals = new ArrayList<String>();
		Meal[] mealtype=null;
		switch(type){
		case MealType.STARTER:
			mealtype=Menu.STARTERS;
			break;
		case MealType.MAIN:
			mealtype=Menu.MAINS;
			break;
		case MealType.DESSERT:
			mealtype=Menu.DESSERTS;
			break;
		case MealType.DRINKS:
			mealtype=Menu.DRINKS;
			break;
		}
		for(Meal m:mealtype){
			meals.add(m.toString());
		}
		return meals;
	}
	
	public static Meal[] getMealsOfType(int type){
		Meal[] mealtype=null;
		switch(type){
		case MealType.STARTER:
			mealtype=Menu.STARTERS;
			break;
		case MealType.MAIN:
			mealtype=Menu.MAINS;
			break;
		case MealType.DESSERT:
			mealtype=Menu.DESSERTS;
			break;
		case MealType.DRINKS:
			mealtype=Menu.DRINKS;
			break;
		}
		return mealtype;
	}
}
