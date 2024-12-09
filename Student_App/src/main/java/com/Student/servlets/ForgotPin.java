package com.Student.servlets;

import com.Student.dao.*;
import com.Student.dto.Student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgotpin")
public class ForgotPin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//collect data from user
		String phone=req.getParameter("phone");
		String mail_id=req.getParameter("mailid");
		String password=req.getParameter("password");
		String confirm_password=req.getParameter("confirmpass");
		
		//chnage datattypes
		long phoneNumber=Long.parseLong(phone);
		
		//jdbc implemmetation
		//PrintWriter out=resp.getWriter();
		StudentDAO sdao=new StudentDAOImplementation();
		Student s=sdao.getStudent(phoneNumber, mail_id);
		
		if(s!=null && password.equals(confirm_password)) {
			
			s.setName(s.getName());
			s.setMail_id(s.getMail_id());
			s.setPhone(s.getPhone());
			s.setLocation(s.getLocation());
			s.setBranch(s.getBranch());
			s.setId(s.getId());
			s.setPassword(password);
			
			boolean result=sdao.updateStudent(s);
			if(result) {
				req.setAttribute("updatesuccess", s);
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
				//out.println("<h1> Pin updated successfully</h1>");
			}
			else {
				req.setAttribute("updatefail", "Pin updation unsuccesful");
				RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
				rd.forward(req, resp);
				//out.println("<h1> Pin updation unsuccessful</h1>");
			}
		}
		else {
			req.setAttribute("mismatch", "Password and confirm password mismatch");
			RequestDispatcher rd=req.getRequestDispatcher("ForgotPin.jsp");
			rd.forward(req, resp);
		}
		
		
	}

}
