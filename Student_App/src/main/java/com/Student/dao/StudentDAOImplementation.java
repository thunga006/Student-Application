package com.Student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Student.connector.ConnectionFactory;
import com.Student.dto.Student;

//used to override all methods in dao interface
//jdbc logic is in this 
public class StudentDAOImplementation implements StudentDAO{
	
	private Connection con;
	//constructor 
	//used to make connection con object global to all methods
	public StudentDAOImplementation() {
		this.con = ConnectionFactory.requestConnection();
	}

	@Override
	public boolean insertStudent(Student s) {
		// JDBC logic for inserting
		String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		PreparedStatement ps=null;
		int res=0;// since it is executeUpdate method and its return type is int
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail_id());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			
			res=ps.executeUpdate(); //tells if the table is affected(returns 1) or not
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		String query="UPDATE STUDENT SET NAME=?,MAIL_ID=?, PHONE=?, BRANCH=?, LOCATION=?, PASSWORD=? WHERE ID=?";
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getMail_id());
			ps.setLong(3, s.getPhone());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			
			
			res=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res>0)
				{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteStudent(Student s) {
		// TODO Auto-generated method stub
		String query="DELETE FROM STUDENT WHERE ID=?";
		int res=0;
		
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, s.getId());
			
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Student getStudent(String mail_id, String password) {
		// TODO Auto-generated method stub
		String query="SELECT * FROM STUDENT WHERE MAIL_ID=? AND PASSWORD=?";
		PreparedStatement ps=null;
		Student s= null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,mail_id);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail_id(rs.getString("mail_id"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Student> getStudent() {
		List<Student> students=new ArrayList<Student>();
		String query="SELECT * FROM STUDENT";
		Student s= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail_id(rs.getString("mail_id"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				
				students.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return students;
	}

	@Override
	public Student getStudent(long phone, String mail_id) {
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL_ID=?";
		PreparedStatement ps=null;
		Student s= null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,phone);
			ps.setString(2, mail_id);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail_id(rs.getString("mail_id"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	

}

