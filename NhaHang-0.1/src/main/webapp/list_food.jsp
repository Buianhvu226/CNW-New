<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Food" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Danh sách món ăn</title>
</head>
<body>
    <h1>Danh sách món ăn</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên món ăn</th>
                <th>Giá</th>
                <th>Mô tả</th>
            </tr>
        </thead>
        <tbody>
            
            <% List<Food> foodList = (List<Food>) request.getAttribute("foodList");
               for (Food food : foodList) { %>
                <tr>
                    <td><%= food.getFoodID() %></td>
                    <td><%= food.getFoodName() %></td>
                    <td><%= food.getPrice() %></td>
                    <td><%= food.getDescription() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    
    <a href="FoodControllerServlet?action=index">Quay về</a>
</body>
</html>
