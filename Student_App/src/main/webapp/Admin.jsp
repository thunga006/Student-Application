<%@page import="java.util.ListIterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.Student.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
border: 2px solid black;
        width: 100%;}
        
        th,td{
        
        padding: auto;
        }</style>
</head>
<body>
<h1> ADMIN PAGE</h1>
<div>
<h2 style="text-align: center;">USER DETAILS</h2>
<form action="admin" method="post">
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PHONE</th>
			<th> MAIL ID</th>
			<th> BRANCH</th>
			<th> LOCATION</th>
			</tr>
			</thead>
			<tbody>
			<%List<Student> students=(List<Student>)session.getAttribute("slist");
			if(students!=null){
			ListIterator<Student> itr=students.listIterator();
			while(itr.hasNext()){
				Student student=itr.next();%>
			<tr>
				<td><%=student.getId() %></td>
				<td><%=student.getName() %></td>
				<td><%=student.getPhone() %></td>
				<td><%=student.getMail_id() %></td>
				<td><%=student.getBranch() %></td>
				<td><%=student.getLocation() %></td>
			</tr>
			<%} 
			} else {%>
			<td><h1><%="NO RECORD FOUND" %></h1></td>
			<%} %>
			</tbody>
	</table>
	</form>
</div>
</body>
</html>