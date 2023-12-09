<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Food" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chỉnh sửa món ăn</title>
    <script>
        function validateForm() {
            var radios = document.getElementsByName("selectedFoodID");
            var formValid = false;

            for (var i = 0; i < radios.length; i++) {
                if (radios[i].checked) {
                    formValid = true;
                    break;
                }
            }

            if (!formValid) {
                alert("Vui lòng chọn một món ăn trước khi gửi yêu cầu.");
            }

            return formValid;
        }
    </script>
</head>
<body>
    <h1>Chỉnh sửa món ăn</h1>
    <form action="FoodControllerServlet?action=process_update1" method="post" onsubmit="return validateForm()">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên món ăn</th>
                    <th>Giá</th>
                    <th>Mô tả</th>
                    <th>Chọn món ăn</th>
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
                        <td><input type="radio" name="selectedFoodID" value="<%= food.getFoodID() %>"></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <br>
        <input type="submit" value="Chỉnh sửa món ăn">
    </form>
    <a href="FoodControllerServlet?action=index">Quay về</a>
</body>
</html>
