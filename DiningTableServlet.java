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

import model.bean.DiningTable;
import model.dao.DiningTableDAO;

@WebServlet("/DiningTableServlet")
public class DiningTableServlet extends HttpServlet {
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
			case "add":
				showAddForm(request, response);
				break;
			case "insert":
				insertDiningTable(request, response);
				break;
			case "delete":
				deleteDiningTable(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateDiningTable(request, response);
				break;
			case "list":
				listDiningTable(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDiningTable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		DiningTableDAO dao = new DiningTableDAO();

		String searchKeyword = request.getParameter("search");

		List<DiningTable> listDiningTable = dao.getDiningTableList();
		request.setAttribute("listDiningTable", listDiningTable);

		request.setAttribute("searchKeyword", searchKeyword);

		RequestDispatcher dispatcher = request.getRequestDispatcher("DiningTable_list.jsp");
		dispatcher.forward(request, response);
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("DiningTable_form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		DiningTableDAO dao = new DiningTableDAO();

		int id = Integer.parseInt(request.getParameter("tableid"));
		DiningTable existingDiningTable = dao.getDiningTableID(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DiningTable_form.jsp");
		request.setAttribute("dtable", existingDiningTable);

		dispatcher.forward(request, response);

	}

	private void insertDiningTable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		DiningTableDAO dao = new DiningTableDAO();

		String tableIdString = request.getParameter("tableid");
		int tableid = (tableIdString != null && !tableIdString.isEmpty()) ? Integer.parseInt(tableIdString) : 0;
		String tablename = request.getParameter("tablename");
		String status = request.getParameter("status");

		DiningTable newDiningTable = new DiningTable(tableid, tablename, status);
		dao.insertDiningTable(newDiningTable);

		response.sendRedirect("DiningTableServlet?action=list");
	}

	private void updateDiningTable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		DiningTableDAO dao = new DiningTableDAO();

		int tableid = Integer.parseInt(request.getParameter("tableid"));
		String tablename = request.getParameter("tablename");
		String status = request.getParameter("status");

		DiningTable diningTable = new DiningTable(tableid, tablename, status);
		dao.updateDiningTable(diningTable);

		response.sendRedirect("DiningTableServlet?action=list");
	}

	private void deleteDiningTable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		DiningTableDAO dao = new DiningTableDAO();

		int tableid = Integer.parseInt(request.getParameter("tableid"));
		dao.deleteDiningTable(tableid);

		response.sendRedirect("DiningTableServlet?action=list");

	}
}
