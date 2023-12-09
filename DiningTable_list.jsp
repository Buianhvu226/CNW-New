<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.DiningTable" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DiningTable List</title>
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
   	<script>
	    function confirmDelete() {
	        return confirm("Bạn có chắc chắn muốn xóa diningtable này?");
	    }
	</script>
    <style>
        .search-box {
            text-align: end;
        }
    </style>
</head>
<body>	
	<header>
        <nav>
            <div align="center">
                <p class="navbar-brand"> Quản lý Diningtable  </p>
            </div>

            <ul class="navbar-nav">
                <li><a href="DiningTableServlet?action=list" class="nav-link">Diningtables</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">

        <div class="container">
            <h3 align="center">List of Diningtables</h3>
            <hr>
            <div>

                <a href="DiningTableServlet?action=add" class="btn btn-success">Add New Diningtable</a>
                
                <%
				    String searchKeyword = request.getParameter("search");
				    List<DiningTable> listDiningTable = (List<DiningTable>) request.getAttribute("listDiningTable");
				%>
                <form action="DiningTableServlet" method="get" class="search-box">
				    <input type="text" name="search" placeholder="Search" value="<%= searchKeyword %>">
				    <button type="submit">Search</button>
				</form>
				
            </div>
            <br>
            <table border="1" align="center">
                <thead>
                    <tr>
                        <th>Table ID</th>
                        <th>Table Name</th>
                        <th>Status</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
	                <% 
			        /* List<DiningTable> listDiningTable = (ArrayList<DiningTable>) request.getAttribute("listDiningTable"); */
			        
			        if (listDiningTable == null || listDiningTable.isEmpty()) {
			        	response.sendRedirect("DiningTableServlet?action=list");
			        } else {
			            for (int i = 0; i < listDiningTable.size(); i++) { 
			        %> 
                        <tr>
                            <td><%= listDiningTable.get(i).getTableID() %></td>
                            <td><%= listDiningTable.get(i).getTableName() %></td>
                            <td><%= listDiningTable.get(i).getStatus() %></td>
   
                            <td>
                                <a href="DiningTableServlet?action=edit&tableid=<%= listDiningTable.get(i).getTableID() %>">Edit</a>
                            </td>
                            <td>
                                <a href="DiningTableServlet?action=delete&tableid=<%= listDiningTable.get(i).getTableID() %>" onclick="return confirmDelete()">Delete</a>
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
