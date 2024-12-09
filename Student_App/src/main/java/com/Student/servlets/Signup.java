package com.Student.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.Student.dao.StudentDAO;
import com.Student.dao.StudentDAOImplementation;
import com.Student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		
		//collecting data from user
		String name=req.getParameter("name");
		String phonenumber=req.getParameter("phone");
		String email=req.getParameter("mail");
		String branch=req.getParameter("branch");
		String location =req.getParameter("loc");
		String password=req.getParameter("password");
		String confirm_pass=req.getParameter("confirm");
		
		//converting necessary dattatypes
		long phone=Long.parseLong(phonenumber);
//		PrintWriter out;
//		out = resp.getWriter();
		
		
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImplementation();
		if(password.equals(confirm_pass)) {

			
			s.setName(name);
			s.setPhone(phone);
			s.setMail_id(email);
			s.setBranch(branch);
			s.setLocation(location);
			s.setPassword(password);
			
			//JDBC Implememnation
			boolean result=sdao.insertStudent(s);
			if(result) {
				//out.println("<h1> DATA ADDED SUCCESSFULLY</h1>");
				req.setAttribute("succes", "Signup successful");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
				
			}
			else {
				//out.println("<h1> FAILED TO ADD DATA </h1>");
				req.setAttribute("failure", "Signup failed");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
			
		}
	}
	
}

