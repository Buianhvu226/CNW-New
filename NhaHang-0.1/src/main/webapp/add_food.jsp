<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm món ăn mới</title>

</head>
<body>
	<h1>Thêm món ăn mới</h1>
	<form action="FoodControllerServlet?action=insert_food" method="post" >
		<label for="foodID">ID món ăn:</label> <input type="number"
			id="foodID" name="foodID" required><br>
		<br> <label for="foodName">Tên món ăn:</label> <input type="text"
			id="foodName" name="foodName" required><br>
		<br> <label for="price">Giá:</label> <input type="number"
			id="price" name="price" required><br>
		<br> <label for="description">Mô tả:</label>
		<textarea id="description" name="description"></textarea>
		<br>
		<br> <input type="submit" value="Thêm">
	</form>
	<a href="FoodControllerServlet?action=index">Quay về</a>
</body>
</html>
