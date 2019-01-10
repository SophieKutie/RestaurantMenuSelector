import java.util.ArrayList;

public class Table {

	private int tableNo;
	private Seat[] seats=new Seat[2];
	
	public Table(int noOfSeats)
	{
		seats=new Seat[noOfSeats];
		for (int i = 0; i < seats.length;i++){
			this.seats [i] = new Seat();	
		}
	}
	public Table(){
		for (int i = 0; i < seats.length;i++){
			this.seats [i] = new Seat();	
		}
	}
	
	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public Seat[] getSeats() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}
	
	public void setMeal(int mealtype,int[]meals){
		ArrayList<Meal> mealsOfType=this.getMeals().getMealsOfType(mealtype);
		mealsOfType.clear();
		for(int i :meals){
			mealsOfType.add(Menu.getMealsOfType(mealtype)[i]);
		}
	}
	public Seat getMeals(){
		return this.seats[0];
	}
	public Seat getSeat(int zeroOrOne){
		if(zeroOrOne!=0 || zeroOrOne !=1)
			return this.seats[0];
		else
			return this.seats[zeroOrOne];
	}
}
 