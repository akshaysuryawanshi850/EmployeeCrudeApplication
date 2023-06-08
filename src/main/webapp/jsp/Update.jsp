<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
   body {
       background-color:gray;
   }
   </style>
</head>

<body >
<center><h1>UPDATE EMPLOYEE</h1>
<hr>
<form action="update2"method="get">
EMPLOYEE ID:-<input type="text"name="id" value="${requestScope.emp.id}"readonly="readonly"><br>
EMPLOYEE NAME:-<input type="text"name="name" value="${requestScope.emp.name}"><br>
EMPLOYEE SALARY:-<input type="text"name="salary"value="${requestScope.emp.salary}"><br>
EMPLOYEE EMAILID:-<input type="text"name="email"value="${requestScope.emp.email}"><br>
<input type="submit"value="UPDATE"><br>

 </form>
 </center>
</body>
</html>