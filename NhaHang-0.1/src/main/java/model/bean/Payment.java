package model.bean;

import java.util.Date;

public class Payment {

	private int paymentID;
    private int userID;
    private double totalAmount;
    private Date paymentDateTime;
    
    public Payment() {
    	
    }

	public Payment(int paymentID, int userID, double totalAmount, Date paymentDateTime) {
		super();
		this.paymentID = paymentID;
		this.userID = userID;
		this.totalAmount = totalAmount;
		this.paymentDateTime = paymentDateTime;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(Date paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", userID=" + userID + ", totalAmount=" + totalAmount
				+ ", paymentDateTime=" + paymentDateTime + "]";
	}
    
    
}
