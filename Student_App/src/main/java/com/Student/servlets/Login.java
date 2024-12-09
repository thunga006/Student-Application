package com.Student.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.Student.dao.*;
import com.Student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session
		HttpSession session=req.getSession();
		//PrintWriter out=resp.getWriter();
		//collect data from user
		String username=req.getParameter("mail");
		String passwword=req.getParameter("password");
		
		//jdbc implementation
		StudentDAO sdao=new StudentDAOImplementation();
		Student s=sdao.getStudent(username, passwword);
		if(s!=null) {
			//req.setAttribute("student", s);
			session.setAttribute("student", s);
			if(s.getId()==1) {
			RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, resp);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
				rd.forward(req, resp);
			}
			
		}
		else {
			req.setAttribute("failure", "LOGIN FAILED");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}

	
}

