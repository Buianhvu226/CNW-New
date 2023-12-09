<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Food" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xóa món ăn</title>
</head>
<body>
    <h1>Xóa món ăn</h1>
    <form action="FoodControllerServlet?action=delete_food" method="post">
    
        <% List<Food> foodList = (List<Food>) request.getAttribute("foodList");
           for (Food food : foodList) { %>
            <label>
                <input type="checkbox" name="foodIDs" value="<%= food.getFoodID() %>">
                <%= food.getFoodName() %>
            </label>
            <br>
        <% } %>

        <input type="submit" value="Xóa món ăn">
    </form>
    <a href="FoodControllerServlet?action=index">Quay về</a>
</body>
</html>
