import java.util.ArrayList;

public class Seat {

    private ArrayList<Meal> starter=new ArrayList<Meal>();
    private ArrayList<Meal> main=new ArrayList<Meal>();
    private ArrayList<Meal> dessert=new ArrayList<Meal>();
    private ArrayList<Meal> drinks= new ArrayList<Meal>();

    public ArrayList<Meal> getStarter() {
		return starter;
	}
	public void setStarter(ArrayList<Meal> starter) {
		this.starter = starter;
	}
	public ArrayList<Meal> getMain() {
		return main;
	}
	public void setMain(ArrayList<Meal> main) {
		this.main = main;
	}
	public ArrayList<Meal> getDessert() {
		return dessert;
	}
	public void setDessert(ArrayList<Meal> dessert) {
		this.dessert = dessert;
	}
	public ArrayList<Meal> getDrinks() {
		return drinks;
	}
	public void setDrinks(ArrayList<Meal> drinks) {
		this.drinks = drinks;
	}

	public float getTotal(SumType stype, int mtype){
		ArrayList<Meal> mealtype=null;
		switch(mtype){
		case MealType.STARTER:
			mealtype=this.starter;
			break;
		case MealType.MAIN:
			mealtype=this.main;
			break;
		case MealType.DESSERT:
			mealtype=this.dessert;
			break;
		case MealType.DRINKS:
			mealtype=this.drinks;
			break;
		}
		float total=0;
		switch(stype){
		case CALORIES:
			for(Meal m:mealtype){
				total+=m.getCalory();
			}
			break;
		case PRICE:
			for(Meal m:mealtype){
				total+=m.getPrice();
			}
			break;
		}
		return total;
	}

	public float getGTotal(SumType stype){
		float total=0;
		switch(stype){
		case CALORIES:
			total=this.getTotal(SumType.CALORIES, MealType.STARTER)
			+this.getTotal(SumType.CALORIES, MealType.MAIN)
			+this.getTotal(SumType.CALORIES, MealType.DESSERT)
			+this.getTotal(SumType.CALORIES, MealType.DRINKS);
			break;
		case PRICE:
			total=this.getTotal(SumType.PRICE, MealType.STARTER)
			+this.getTotal(SumType.PRICE, MealType.MAIN)
			+this.getTotal(SumType.PRICE, MealType.DESSERT)
			+this.getTotal(SumType.PRICE, MealType.DRINKS);
			break;
		}
		return total;
	}
    
	public ArrayList<Meal> getMealsOfType(int type){
		ArrayList<Meal> mealtype=null;
		switch(type){
		case MealType.STARTER:
			mealtype=this.starter;
			break;
		case MealType.MAIN:
			mealtype=this.main;
			break;
		case MealType.DESSERT:
			mealtype=this.dessert;
			break;
		case MealType.DRINKS:
			mealtype=this.drinks;
			break;
		}
		return mealtype;
	}
	
}
