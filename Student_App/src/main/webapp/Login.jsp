<%@page import="com.Student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<head> 
<style> 
.heading { 
color: #000080; 
} 
.sub { 
color: #1e90ff; 
} 
</style> 
</head> 
<body bgcolor='#add8e6'> 
<div align="center"> 
<h1 class="heading">Pentagon Space</h1> 
<h3 class="sub">Login</h3> 
<% String failure=(String)request.getAttribute("failure"); 
if(failure!=null){%>
<%=failure %>
<%} %>
<%String logout=(String)request.getAttribute("logout");
if(logout!=null){%>
<%=logout %>
<%} %>
<form action="login" method="post"> 
<br> 
   <table> 
    <tr> 
     <td><b>Enter your mail ID:</b></td> 
     <td><input type="email" name="mail" 
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr> 
     <td><b>Enter the password:</b></td> 
     <td><input type="password" name="password" 
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr>
   
     <td><input type="submit" value="Login"></td> 
<td><a href="ForgotPin.jsp">forgot 
pin?</a></td> 
</tr> 
<tr> 
<td><br></td> 
<td><br></td> 
</tr> 
</table> 
Don't have a account?<a href="Signup.jsp">signup</a>  
</form> 
</div> 
</body> 
</html> 