package com.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.EmployeeDAO;
import com.hibernate.dao.EmployeeDAOImpl;
import com.hibernate.model.Employee;

@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new EmployeeDAOImpl();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/htmml");
		PrintWriter out = response.getWriter();

		List<Employee> list = dao.findAllEmployess();

		request.setAttribute("list", list);

		request.getRequestDispatcher("jsp/display.jsp").forward(request, response);
	}
}
