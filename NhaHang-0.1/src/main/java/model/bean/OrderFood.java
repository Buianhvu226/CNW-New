package model.bean;

import java.util.Date;

public class OrderFood {

	private int orderID;
    private int userID;
    private int foodID;
    private int quantity;
    private Date orderDateTime;
    
    public OrderFood() {
    	
    }

	public OrderFood(int orderID, int userID, int foodID, int quantity, Date orderDateTime) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.foodID = foodID;
		this.quantity = quantity;
		this.orderDateTime = orderDateTime;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	@Override
	public String toString() {
		return "OrderFood [orderID=" + orderID + ", userID=" + userID + ", foodID=" + foodID + ", quantity=" + quantity
				+ ", orderDateTime=" + orderDateTime + "]";
	}
    
    
}
