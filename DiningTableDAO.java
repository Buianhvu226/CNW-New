package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.DiningTable;

public class DiningTableDAO {
	public Connection connection;

	public void ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/nhahang", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void CloseDB() throws SQLException {
		connection.close();
	}

	public List<DiningTable> getDiningTableList() {
		ConnectDB();
		List<DiningTable> dtables = new ArrayList<>();
		String query = "SELECT * FROM diningtable";
		// Step 1: Establishing a Connection
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("TableID");
				String name = rs.getString("TableName");
				String status = rs.getString("Status");
				dtables.add(new DiningTable(id, name, status));
			}
			CloseDB();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtables;

	}

	public DiningTable getDiningTableID(int tableID) {
		ConnectDB();
		DiningTable dtable = null;
		String query = "SELECT * FROM diningtable WHERE TableID = ?";
		// Step 1: Establishing a Connection
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, tableID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("TableName");
				String status = rs.getString("Status");
				dtable = new DiningTable(tableID, name, status);
			}
			CloseDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtable;
	}

	public void insertDiningTable(DiningTable diningTable) throws SQLException {
		ConnectDB();
		String query = "INSERT INTO diningtable (TableName, Status) VALUES (?, ?)";
		System.out.println(query);
		// try-with-resource statement will auto close the connection.
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, diningTable.getTableName());
			preparedStatement.setString(2, diningTable.getStatus());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseDB();

	}

	public boolean deleteDiningTable(int tableid) throws SQLException {
		ConnectDB();
		boolean rowDeleted;
		String query = "DELETE FROM diningtable WHERE TableID = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, tableid);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		CloseDB();
		return rowDeleted;
	}

	public boolean updateDiningTable(DiningTable diningTable) throws SQLException {
		ConnectDB();
		boolean rowUpdated;
		String query = "UPDATE diningtable SET TableName = ?,Status= ? WHERE TableID = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, diningTable.getTableName());
			preparedStatement.setString(2, diningTable.getStatus());
			preparedStatement.setInt(3, diningTable.getTableID());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		CloseDB();
		return rowUpdated;
	}

	public List<DiningTable> searchDiningTable(String keyword) {
		ConnectDB();
		List<DiningTable> dtables = new ArrayList<>();
		String query = "SELECT * FROM diningtable WHERE TableID LIKE '%?%' OR TableName LIKE '%?%' OR Status LIKE '%?%'";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			{
				while (rs.next()) {
					DiningTable dtable = new DiningTable();

					int id = rs.getInt("TableID");
					String name = rs.getString("TableName");
					String status = rs.getString("Status");
					dtables.add(new DiningTable(id, name, status));
				}
				CloseDB();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtables;
	}
}
