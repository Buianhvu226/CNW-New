package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.DiningTable;
import model.dao.DiningTableDAO;

public class DiningTableBO {
	DiningTableDAO diningTableDAO = new DiningTableDAO();

	public List<DiningTable> getDiningTableList() {
		return diningTableDAO.getDiningTableList();
	}

	public DiningTable getDiningTableIDBO(int tableID) {
		return diningTableDAO.getDiningTableID(tableID);
	}

	public void insertDiningTableBO(DiningTable diningTable) throws SQLException {
		diningTableDAO.insertDiningTable(diningTable);
	}

	public boolean deleteDiningTableBO(int tableID) throws SQLException {
		return diningTableDAO.deleteDiningTable(tableID);
	}

	public boolean updateDiningTableBO(DiningTable diningTable) throws SQLException {
		return diningTableDAO.updateDiningTable(diningTable);
	}

	public List<DiningTable> searchDiningTableBO(String keyword) {
		return diningTableDAO.searchDiningTable(keyword);
	}
}
