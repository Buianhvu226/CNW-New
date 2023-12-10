package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();

	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	public User getUserID(int userID) {
		return userDAO.getUserID(userID);
	}

	public boolean deleteUser(int userID) throws SQLException {
		return userDAO.deleteUser(userID);
	}

	public List<User> searchUser(String keyword) {
		return userDAO.searchUser(keyword);
	}
}
