<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý món ăn</title>
</head>
<body>
    <h1>Quản lý món ăn</h1>
    <ul>
        <li><a href="FoodControllerServlet?action=list_food">Xem danh sách món ăn</a></li>
        <li><a href="FoodControllerServlet?action=add_food">Thêm món ăn mới</a></li>
        <li><a href="FoodControllerServlet?action=select_food_del">Xóa món ăn</a></li>
        <li><a href="FoodControllerServlet?action=select_food_upd">Chỉnh sửa món ăn</a></li>
        <li><a href="FoodControllerServlet?action=search_food_list">Tìm kiếm món ăn</a></li>
    </ul>
    
</body>
</html>
