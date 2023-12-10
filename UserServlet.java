package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bo.UserBO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			action = "list";
		}

		try {
			switch (action) {
			case "delete":
				deleteUser(request, response);
				break;
			case "search":
				searchUser(request, response);
				break;
			case "list":
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		UserBO bo = new UserBO();

		List<User> listUser = bo.getUserList();
		request.setAttribute("listUser", listUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("User_list.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		UserBO bo = new UserBO();

		int userid = Integer.parseInt(request.getParameter("userid"));
		bo.deleteUser(userid);

		response.sendRedirect("UserServlet?action=list");

	}

	private void searchUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBO bo = new UserBO();
		String keyword = request.getParameter("searchKeyword");

		List<User> listUser = bo.searchUser(keyword);
		request.setAttribute("listUser", listUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("User_list.jsp");
		dispatcher.forward(request, response);
	}

}
