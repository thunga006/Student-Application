package com.Student.servlets;

import java.io.IOException;
import com.Student.dao.*;
import com.Student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateAccount")
public class UpdateAccount extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=req.getParameter("name");
		String mail=req.getParameter("mail");
		String phone=req.getParameter("phone");
			long phonenum=Long.parseLong(phone);
		String branch=req.getParameter("branch");
		String location=req.getParameter("location");
		
		//by passing false new session is not created
		HttpSession session=req.getSession(false);
		Student s=(Student)session.getAttribute("student");
		//jdbc implementation
		StudentDAO sdao=new StudentDAOImplementation();
		s.setName(name);
		s.setPhone(phonenum);
		s.setMail_id(mail);
		s.setBranch(branch);
		s.setLocation(location);
		
		boolean result=sdao.updateStudent(s);
		if(result) {
			req.setAttribute("success", "Account updated successfully");
			//session.setAttribute("student", "Account updated successfully");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateAccount.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("failure", "Account not updated");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateAccount.jsp");
			rd.forward(req, resp);
		}
	}
}

