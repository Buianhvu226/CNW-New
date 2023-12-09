package model.bean;

public class DiningTable {

	private int tableID;
    private String tableName;
    private String status;
    
    public DiningTable() {
    	
    }

	public DiningTable(int tableID, String tableName, String status) {
		super();
		this.tableID = tableID;
		this.tableName = tableName;
		this.status = status;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DiningTable [tableID=" + tableID + ", tableName=" + tableName + ", status=" + status + "]";
	}
    
    
}
