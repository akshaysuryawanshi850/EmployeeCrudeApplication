
<%@page import="com.hibernate.model.Employee"%>
<%@page import="com.hibernate.dao.EmployeeDAOFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.hibernate.dao.EmployeeDAOImpl"%>
<%@page import="com.hibernate.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
   body {
       background-color: lightblue;
   }
   table {
    
  border-collapse: collapse;
  width: 100%;
  
}
 
th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
tr:hover {background-color: #c0c0c0 ;}

h1{
	
	color: black;
}
 
   
  </style>
  </head>
<body bgcolor="red">
	<%!EmployeeDAO dao;

	public void jspInit() {

		dao = EmployeeDAOFactory.getInstance();

	}%>




	<%
	List<Employee> list = dao.findAllEmployess();

	application.setAttribute("list", list);
	%>

	<center>
		<h1>---EMPLOYEE LIST---</h1>
		<div class="container">
			<h3>
 			</h3>
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Salary</th>
					<th>email</th>
					<th>Update</th>
					<th>Delete</th>
					
				</tr>

				<c:forEach var="pro" items="${applicationScope.list }">
					<tr>
						<td><c:out value="${pro.id}"></c:out></td>
						<td><c:out value="${pro.name}"></c:out></td>
						<td><c:out value="${pro.salary}"></c:out></td>
					    <td><c:out value="${pro.email}"></c:out></td>
						
						<td><a
							href="${pageContext.request.contextPath}/updatedata?id=${pro.id}">UPDATE</a></td>
						<td><a
							href="${pageContext.request.contextPath}/deletedata?id=${pro.id}">DELETE</a></td>

					</tr>
					
				</c:forEach>
             <td> <a href='../Welcome.html'><input type="submit"value="REGISTER"></a></td>
			</table>
</body>
</html>