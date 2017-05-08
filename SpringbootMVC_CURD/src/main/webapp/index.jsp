<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
<a href="#" id="Naresh" onclick="save(this);" >click</a>
<form action="/save" method="post" >
EMP ID :<input type="text" name="empId" value="${employee.empId }"/><br>
EMP NAME :<input type="text" name="empName" value="${employee.empName }"/><br>
EMP ADD: <input type="text" name="empAdd" value="${employee.empAdd }"/><br>
<input type="submit" value="save"/>
</form>

${name}<br><br>
<table border="2" >
<tr><th>EMPID</th><th>EMPAdd</th><th>EMPNAME</th></tr>

<c:forEach items="${empList}" var="employee">
<tr>
<td>${employee.empId}</td>
<td>${employee.empName}</td>
<td>${employee.empAdd}</td>
<td><a  href="getEmployeeToUpadte?id=${employee.empId}" >EDIT</a></td>
<td><a href="deleteEmployee?id=${employee.empId}">DELETE</a></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>