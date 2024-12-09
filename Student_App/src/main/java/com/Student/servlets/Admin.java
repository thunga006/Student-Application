package com.Student.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.Student.dao.*;
import com.Student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin")
public class Admin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		System.out.println(session);
		String username=req.getParameter("mail");
		String passwword=req.getParameter("password");
		
		StudentDAO sdao=new StudentDAOImplementation();
		List<Student> studentList=sdao.getStudent();
	
			session.setAttribute("slist", studentList);
			RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, resp);
		}
		
	
}

