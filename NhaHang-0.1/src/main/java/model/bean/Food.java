package model.bean;

public class Food {

	private int foodID;
    private String foodName;
    private double price;
    private String description;
    
    public Food() {
    	
    }

	public Food(int foodID, String foodName, double price, String description) {
		super();
		this.foodID = foodID;
		this.foodName = foodName;
		this.price = price;
		this.description = description;
	}

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Food [foodID=" + foodID + ", foodName=" + foodName + ", price=" + price + ", description=" + description
				+ "]";
	}
    
    
}
