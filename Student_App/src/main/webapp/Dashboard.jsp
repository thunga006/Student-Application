<%@page import="com.Student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}
 .navbar
        {
        	padding: 5px;
            justify-content: center;
            background-color: indianred;
            width: 100%;
        }
        ul{
        	display: flex;
        	gap: 80px;
        	margin: 40px;
            margin-left: 300px;
        	align-items: center;
        }
        li
        {
        	font-size: 30px;
        	font-weight: bold;
        }
        h1{
            text-align: center;
            border: 5psx solid yellow;
            padding: 10px;
            margin: 10px;
        }
        button{
            height: auto;
            width: 100%;
           padding: 15px;
        }
        table{
        width: 100%;}
        
        th,td{
        
        padding: 18px;
        }
    
    </style>
</head>
<body>
    <div >
    
        <header>

            <% Student s=(Student)session.getAttribute("student"); %>
   	<h1><%="Welcome "+s.getName() %></h1> 
        </header>
        <nav class="navbar">
        <div>
        <ul type="none">
            <li><button>Admin Account</button></li>
            <li><button><a href="UpdateAccount.jsp">Update account</a> </button></li>
            <li><button><a href="ForgotPin.jsp">Reset password</a></button></li>
            <form action="logout" method="post">
            <li><button>Logout</button></li>
            </form>
        </ul>
        </div>
        </nav>
        <br>
        
    <br>
        <table border="2px solid blue">
        <tr>
        <th> ID</th>
        <th> NAME </th>
        <th> PHONE</th>
        <th> MAIL_ID</th>
        <th> BRANCH</th>
        <th> LOCATION</th>
        </tr>
        <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getPhone() %></td>
        <td><%= s.getMail_id() %></td>
        <td><%= s.getBranch() %></td>
        <td><%= s.getLocation() %></td>
        </tr>
        </table>
    </div>
</body>
</html>
    