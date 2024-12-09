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
<h3 class="sub">Update Account</h3> 
<%Student s=(Student)session.getAttribute("student"); %>

<form action="updateAccount" method="post"> 
<% String success=(String)request.getAttribute("success"); 
if(success!=null){%>
<h3><%=success%></h3>
<%} %>
<% String failure=(String)request.getAttribute("failure"); 
if(failure!=null){%>
<h3><%=failure %></h3>
<%} %>
<br> 
   <table> 
    <tr> 
     <td><b>Enter mail id to update:</b></td> 
     <td><input type="email" name="mail" value="<%=s.getMail_id() %>"
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr> 
     <td><b>Enter Phone to update:</b></td> 
     <td><input type="tel" name="phone" 
required="required" value=<%=s.getPhone() %>></td> 
    </tr>
    <tr> 
     <td><b>Enter Name to update:</b></td> 
     <td><input type="text" name="name" 
required="required" value=<%=s.getName() %>></td> 
    </tr>  
    <tr> 
     <td><b>Enter Branch to update:</b></td> 
     <td><input type="text" name="branch" 
required="required" value=<%=s.getBranch() %>></td> 
    </tr> 
    <tr> 
     <td><b>Enter Location to update:</b></td> 
     <td><input type="text" name="location" 
required="required" value=<%=s.getLocation() %>></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr> 
     <td><input type="submit" value="Update Account"></td> 
<td><a href="Dashboard.jsp">Back</a></td> 
</tr> 
<tr> 
<td><br></td> 
<td><br></td> 
</tr> 
</table> 
Don't have a account?<a href="Signup.html">signup</a>  
</form> 
</div> 
</body> 
</html> 