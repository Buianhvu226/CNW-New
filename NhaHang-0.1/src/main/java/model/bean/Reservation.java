package model.bean;

import java.util.Date;

public class Reservation {
	
	private int reservationID;
    private int userID;
    private int tableID;
    private Date reservationDateTime;
    
    public Reservation() {
    	
    }

	public Reservation(int reservationID, int userID, int tableID, Date reservationDateTime) {
		super();
		this.reservationID = reservationID;
		this.userID = userID;
		this.tableID = tableID;
		this.reservationDateTime = reservationDateTime;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public Date getReservationDateTime() {
		return reservationDateTime;
	}

	public void setReservationDateTime(Date reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}

	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", userID=" + userID + ", tableID=" + tableID
				+ ", reservationDateTime=" + reservationDateTime + "]";
	}
    
    

}
