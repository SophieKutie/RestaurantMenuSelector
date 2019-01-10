import java.util.ArrayList;

public class Order {
	private Table[] tables=new Table[1];
	
	public Order(int numberOfTables){	
	        tables=new Table[numberOfTables];
	        for (int i=0;i<tables.length;i++){
	            this.tables[i]=new Table();
	        }
	    }
	    public Order(){
	        for (int i=0;i<tables.length;i++){
	            this.tables[i]=new Table();
	        }
	    }
	
	public Table getTable(){
		return tables[0];
	}
	
	public Table[] getTables() {
		return tables;
	}

	public void setTables(Table[] tables) {
		this.tables = tables;
	}
	
	public String getDetails(OrderType otype) {
		StringBuilder sb=new StringBuilder();
		
		sb.append(otype==OrderType.ORDER?"\n======= YOUR ORDER =======":"\n======= YOUR RECEIPT =======");
		sb.append("\n\nStarters");
		sb.append("\n======================");
		ArrayList<Meal> theStarterMeals=this.getTable().getMeals().getStarter();
		for(Meal starter:theStarterMeals){
			sb.append("\n"+(otype==OrderType.ORDER?starter.toString():starter.toString(true)));
		}
		sb.append("\n======================");
		if(otype==OrderType.ORDER){
			sb.append("\nTotal Starter Calories="+this.getTable().getMeals().getTotal(SumType.CALORIES, MealType.STARTER));
		}
		sb.append("\nTotal Starter Price="+this.getTable().getMeals().getTotal(SumType.PRICE, MealType.STARTER));

		sb.append("\n\nMains");
		sb.append("\n======================");
		ArrayList<Meal> theMainMeals=this.getTable().getMeals().getMain();
		for(Meal main:theMainMeals){
			sb.append("\n"+(otype==OrderType.ORDER?main.toString():main.toString(true)));
		}
		sb.append("\n======================");
		if(otype==OrderType.ORDER){
			sb.append("\nTotal Mains Calories="+this.getTable().getMeals().getTotal(SumType.CALORIES, MealType.MAIN));
		}
		sb.append("\nTotal Mains Price="+this.getTable().getMeals().getTotal(SumType.PRICE, MealType.MAIN));
		
		sb.append("\n\nDesserts");
		sb.append("\n======================");
		ArrayList<Meal> theDessertMeals=this.getTable().getMeals().getDessert();
		for(Meal dessert:theDessertMeals){
			sb.append("\n"+(otype==OrderType.ORDER?dessert.toString():dessert.toString(true)));
		}
		sb.append("\n======================");
		if(otype==OrderType.ORDER){
			sb.append("\nTotal Desserts Calories="+this.getTable().getMeals().getTotal(SumType.CALORIES, MealType.DESSERT));
		}
		sb.append("\nTotal Desserts Price="+this.getTable().getMeals().getTotal(SumType.PRICE, MealType.DESSERT));
		
		sb.append("\n\nDrinks");
		sb.append("\n======================");
		ArrayList<Meal> theDrinkMeals=this.getTable().getMeals().getDrinks();
		for(Meal drink:theDrinkMeals){
			sb.append("\n"+(otype==OrderType.ORDER?drink.toString():drink.toString(true)));
		}
		sb.append("\n======================");
		if(otype==OrderType.ORDER){
			sb.append("\nTotal Drinks Calories="+this.getTable().getMeals().getTotal(SumType.CALORIES, MealType.DRINKS));
		}
		sb.append("\nTotal Drinks Price="+this.getTable().getMeals().getTotal(SumType.PRICE, MealType.DRINKS));
		
		
		sb.append("\n\n======================");
		if(otype==OrderType.ORDER)sb.append("\nTOTAL CALORIES ="+this.getTable().getMeals().getGTotal(SumType.CALORIES));
		sb.append("\nTOTAL PRICE ="+this.getTable().getMeals().getGTotal(SumType.PRICE));

		return sb.toString();
	}

}
