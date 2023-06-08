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

 
@WebServlet("/deletedata")
public class deletedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
     EmployeeDAO dao;
     @Override
    	public void init() throws ServletException {
    	dao=new EmployeeDAOImpl();
     		super.init();
    	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
      response.sendRedirect("jsp/display.jsp");
		
		dao.deleteEmployeeById(id);
	}

}
