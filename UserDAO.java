package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.User;

public class UserDAO {
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

	public List<User> getUserList() {
		ConnectDB();
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("UserID");
				String name = rs.getString("Username");
				String pass = rs.getString("Password");
				users.add(new User(id, name, pass));
			}
			CloseDB();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	public User getUserID(int userID) {
		ConnectDB();
		User user = null;
		String query = "SELECT * FROM users WHERE UserID = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, userID);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("Username");
				String pass = rs.getString("Password");
				user = new User(userID, name, pass);
			}
			CloseDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean deleteUser(int userID) throws SQLException {
		ConnectDB();
		boolean rowDeleted;
		String query = "DELETE FROM users WHERE UserID = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, userID);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		CloseDB();
		return rowDeleted;
	}

	public List<User> searchUser(String keyword) {
		ConnectDB();
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users WHERE UserID LIKE ? OR Username LIKE ? OR Password LIKE ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();

				int id = rs.getInt("UserID");
				String name = rs.getString("Username");
				String pass = rs.getString("Password");
				users.add(new User(id, name, pass));
			}
			CloseDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
