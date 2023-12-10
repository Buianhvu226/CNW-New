<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #2e59d9d1;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
		.loginPage{
			display:flex;
			border: 1px solid #ccc;
    		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    		border-radius:10px;
		}
        form {
        	display:flex;
        	flex-direction: column;
        	width:400px;
            background-color: #fff;
            padding: 38px;
            
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-top-right-radius: 10px;
	        border-bottom-right-radius: 10px;
        }
        form h2,form p{
        	font-style: italic;
        }
        form h2{
        	font-size:24px;
        }
        form p{
        	font-size:20px;
        }
		.imgLogin{
	        width: 440px;
	        height: 576px;
	        border-top-left-radius: 10px;
	        border-bottom-right-radius: 10px;
	    }
	    .imgLogin img{
	        width: 100%;
	        height: 576px;
	        object-fit: cover;
	        border-top-left-radius: 10px;
	        border-bottom-left-radius:10px;
	    }
	    
        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #2e59d9da;
            color: white;
            padding: 10px 15px;
            margin: 16px 0;
            border: none;
            border-radius: 999px;
            cursor: pointer;
            height:40px;
        }

        button:hover {
            background-color: #2e59d9;
        }

        input[type="text"],
        input[type="password"] {
            display: block;
            width: 100%;
            height:40px;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 999px;
        }
    </style>
</head>
<body>
	<div class="loginPage">
		<div class="imgLogin">
    		<img src="https://tenkujapan.vn/wp-content/uploads/2020/02/46Tenku_3226.jpg" >
    	</div>
    	<form action="" method="post">	
    		<h2>Chao mung tro lai</h2>
    		<p>Hay dang nhap tai khoan cua ban</p>
       	 	<input type="text" name="username" placeholder="Tai khoan" />
        	<input type="password" name="password" placeholder="Mat khau" />
        	<button type="submit" value="Login">Login</button>
        	<p>Neu ban chua co tai khoan, hay dang ky</p>
    	</form>
	</div>
	
</body>
</html>
