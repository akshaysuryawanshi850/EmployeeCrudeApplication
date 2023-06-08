package com.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.EmployeeDAO;
import com.hibernate.dao.EmployeeDAOImpl;
import com.hibernate.model.Employee;

@WebServlet("/update2")
public class update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new EmployeeDAOImpl();	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		String email=request.getParameter("email");
		
		
		Employee emp=new Employee(id,name,salary,email);
			
		Employee e=dao.update2(emp);
	request.getRequestDispatcher("jsp/display.jsp").forward(request, response);

	
	}

}
