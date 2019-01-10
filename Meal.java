public class Meal {

	private float calory;
	private float price;
	private int meal_type;
	private String meal_name;
	
	public Meal(float cal, float price, int type, String name){
		setCalory(cal);
		setMeal_name(name);
		setPrice(price);
		setMeal_type(type);
	}

	public float getCalory() {
		return calory;
	}

	public void setCalory(float calory) {
		this.calory = calory;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getMeal_type() {
		return meal_type;
	}

	public void setMeal_type(int meal_type) {
		this.meal_type = meal_type;
	}

	public String getMeal_name() {
		return meal_name;
	}

	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}
  	@Override public String toString(){
		return this.getMeal_name()+" calory="+this.getCalory()+" price="+this.getPrice();
    }
  	public String toString(boolean r){
  		if (!r)
  			return this.getMeal_name()+" calory="+this.getCalory()+" price="+this.getPrice();
  		else
  			return this.getMeal_name()+" price="+this.getPrice(); 
    }
}
