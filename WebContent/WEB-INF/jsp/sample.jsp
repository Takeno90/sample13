<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="model.Employee,java.util.List,java.util.ArrayList" %>
<%
	List<Employee> empList = (List<Employee>)request.getAttribute("empList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%for(Employee emp : empList) {%>
			<%= emp.getId() %><br>
			<%= emp.getName() %><br>
			<%= emp.getAge() %><br>
		<%} %>
	</div>
</body>
</html>