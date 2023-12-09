package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Food;

public class FoodDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/NhaHang";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public ArrayList<Food> getListFood() {
        ArrayList<Food> listFood = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM Food";

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Food food = new Food();
                food.setFoodID(rs.getInt("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                food.setPrice(rs.getDouble("Price"));
                food.setDescription(rs.getString("Description"));

                listFood.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listFood;
    }
    
    public void addFood(Food food) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "INSERT INTO Food (FoodID, FoodName, Price, Description) VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, food.getFoodID());
            ps.setString(2, food.getFoodName());
            ps.setDouble(3, food.getPrice());
            ps.setString(4, food.getDescription());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean deleteFood(int foodID) {
        boolean deleted = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "DELETE FROM Food WHERE FoodID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, foodID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deleted;
    }
    
 // Trong lớp FoodDAO

    public Food getFoodByID(int foodID) {
        Food food = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM Food WHERE FoodID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, foodID);

            rs = ps.executeQuery();

            if (rs.next()) {
                food = new Food();
                food.setFoodID(rs.getInt("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                food.setPrice(rs.getDouble("Price"));
                food.setDescription(rs.getString("Description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return food;
    }

    
    public boolean updateFood(Food food) {
        boolean updated = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
        	conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            String query = "UPDATE food SET FoodName=?, Price=?, Description=? WHERE FoodID=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, food.getFoodName());
            ps.setDouble(2, food.getPrice());
            ps.setString(3, food.getDescription());
            ps.setInt(4, food.getFoodID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } catch (SQLException e) {
            // Xử lý lỗi SQL nếu có
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updated;
    }
    
    
    public List<Food> getFoodByName(String foodName) {
        List<Food> foodList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM Food WHERE FoodName LIKE ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + foodName + "%"); // Using "%" to match partially

            rs = ps.executeQuery();

            while (rs.next()) {
                Food food = new Food();
                food.setFoodID(rs.getInt("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                food.setPrice(rs.getDouble("Price"));
                food.setDescription(rs.getString("Description"));

                foodList.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return foodList;
    }

    
}
