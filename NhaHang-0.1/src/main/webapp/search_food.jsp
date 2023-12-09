<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.bean.Food" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm món ăn</title>
</head>
<body>
    <h1>Tìm món ăn</h1>
    <form action="FoodControllerServlet?action=find_food" method="post">
        <label for="foodName">Tên món ăn:</label>
        <input type="text" id="foodName" name="foodName"><br><br>

        <input type="submit" value="Tìm kiếm">
    </form>

    <% 
        List<Food> foodList = (List<Food>) request.getAttribute("foodList");
        if (foodList != null && !foodList.isEmpty()) {
    %>
        <h2>Kết quả tìm kiếm</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên món ăn</th>
                    <!-- Thêm các cột thông tin khác nếu cần -->
                </tr>
            </thead>
            <tbody>
                <% for (Food food : foodList) { %>
                    <tr>
                        <td><%= food.getFoodID() %></td>
                        <td><%= food.getFoodName() %></td>
                        <!-- Thêm các ô thông tin khác nếu cần -->
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>
    <a href="FoodControllerServlet?action=index">Quay về</a>
</body>
</html>
