<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   	<script>
	    function confirmDelete() {
	        return confirm("Bạn có chắc chắn muốn xóa User này?");
	    }
	</script>
	
    <style>
        .search-box {
            text-align: right;
        }
    </style>
    
</head>

<body>	
	<header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
            <div>
                <p class="navbar-brand"> Quản lý User  </p>
            </div>

            <ul class="navbar-nav">
                <li><a href="UserServlet?action=list" class="nav-link">Users</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">

        <div class="container">
            <h3 align="center">List of Users</h3>
            <hr>
		    <div class="search-box" >
		        <form action="UserServlet?action=list" method="get" class="form-inline">
		            <input type="hidden" name="action" value="search">
		            <div class="form-group mx-sm-3 mb-2">
		                <input type="text" class="form-control" name="searchKeyword" placeholder="Search">
		            </div>
		            <button type="submit" class="btn btn-primary mb-2">Search</button>
		        </form>
		    </div>
            <br>
            <table class="table table-bordered">
                <thead>
		            <tr>
		                <th class="col-2">User ID</th>
		                <th class="col-4">Username</th>
		                <th class="col-2">Password</th>
		                <th class="col-2">Delete</th>
		            </tr>
		        </thead>
                <tbody>
	                <% 
			        List<User> listUser = (ArrayList<User>) request.getAttribute("listUser"); 
			        
			        if (listUser == null || listUser.isEmpty()) {	        	
			        	response.sendRedirect("UserServlet?action=list");
			        } else {
			            for (int i = 0; i < listUser.size(); i++) { 
			        %> 
                        <tr>
                            <td><%= listUser.get(i).getUserID() %></td>
                            <td><%= listUser.get(i).getUsername() %></td>
                            <td><%= listUser.get(i).getPassword() %></td>

                            <td>
                                <a href="UserServlet?action=delete&userid=<%= listUser.get(i).getUserID() %>" onclick="return confirmDelete()">Delete</a>
                            </td>
                        </tr>
                    <% 
	                    } 
				    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
