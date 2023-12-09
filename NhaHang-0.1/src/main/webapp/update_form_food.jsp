<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.bean.Food" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật món ăn</title>
</head>
<body>
    <h1>Cập nhật món ăn</h1>
    
    <form action="FoodControllerServlet?action=process_update2" method="post">
        <% Food food = (Food) request.getAttribute("foodToUpdate"); %>
        <label for="foodName">ID món ăn:</label>
        <input type="text" readonly name="foodID" value="<%= food.getFoodID() %>">
        
        <label for="foodName">Tên món ăn:</label>
        <input type="text" id="foodName" name="foodName" value="<%= food.getFoodName() %>" required><br><br>

        <label for="price">Giá:</label>
        <input type="number" id="price" name="price" value="<%= food.getPrice() %>" required><br><br>

        <label for="description">Mô tả:</label>
        <textarea id="description" name="description"><%= food.getDescription() %></textarea><br><br>

        <input type="submit" value="Cập nhật">
    </form>
</body>
</html>
