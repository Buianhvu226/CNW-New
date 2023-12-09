<%@page import="model.bean.DiningTable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Diningtable Form</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

	<%
	    DiningTable dtable = (DiningTable) request.getAttribute("dtable");
	%>

	 <header>
	    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
	        <div>
	            <p class="navbar-brand"> Quản lý Diningtable </p>
	        </div>
	        <ul class="navbar-nav">
                <li><a href="DiningTableServlet?action=list" class="nav-link">Diningtables</a></li>
            </ul>
	    </nav>
	</header>
	<br>
	<div class="container col-md-5">
	    <div class="card">
	        <div class="card-body">
	            <%
	                if (dtable != null) {
	            %>
	            <form action="DiningTableServlet?action=update" method="post">
	            <%
	                }
	                if (dtable == null) {
	            %>
	            <form action="DiningTableServlet?action=insert" method="post">
	            <%
	                }
	            %>
	
	            <caption>
	                <h2>
	                    <%
	                        if (dtable != null) {
	                    %>
	                    Edit Diningtable
	                    <%
	                        }
	                        if (dtable == null) {
	                    %>
	                    Add New Diningtable
	                    <%
	                        }
	                    %>
	                </h2>
	            </caption>
	
	            <%
	                if (dtable != null) {
	            %>
	            <input type="text" name="tableid" value="<%=dtable.getTableID()%>" readonly/>
	            <%
	                }
	            %>
	
	            <fieldset class="form-group">
	                <label>Table Name</label> <input type="text" value="<%=dtable != null ? dtable.getTableName() : ""%>" class="form-control" name="tablename" required">
	            </fieldset>
	
	            <fieldset class="form-group">
	                <label>Status</label> <input type="text" value="<%=dtable != null ? dtable.getStatus() : ""%>" class="form-control" name="status" required>
	            </fieldset>

	
	            <button type="submit" class="btn btn-success">Add</button>
	            </form>
	        </div>
	    </div>
	</div>

</body>
</html>