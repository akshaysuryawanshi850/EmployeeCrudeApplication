 
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

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new EmployeeDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		double salary = Double.parseDouble(request.getParameter("salary"));

		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmail(email);
		emp.setSalary(salary);
		dao.saveEmployee(emp);
		 response.sendRedirect("jsp/display.jsp");
	}

}
