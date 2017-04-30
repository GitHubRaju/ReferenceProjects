<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function save() {
		document.forms[0].action = "saveStudent.do";
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<center>
		<fieldset>
			<legend>
				<h3>Student Info</h3>
			</legend>
			<form:form action="" commandName="student" >
				<form:input type="hidden" path="sid" ></form:input>

				<table border="2">
					<tr>
						<td>Student Name :</td>
						<td><form:input  path="name" ></form:input></td>
					</tr>

					<tr>
						<td>Email :</td>
						<td><form:input  path="email" ></form:input></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="button" onclick="save()" value="save" /></td>
					</tr>
				</table>
			</form:form>
		</fieldset>
	</center>
	<br>
	<fieldset>
		<center>
			<legend>Student Details</legend>
			<table border="2" bordercolor="green">
				<tr>
					<th>S.NO</th>
					<th>S Name</th>
					<th>Email</th>
					<th>update</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${studentList }" var="student">
					<tr>
						<td>${student.sid}</td>
						<td>${student.name}</td>
						<td>${student.email}</td>
						<td><a href="getById.do?sid=${student.sid}">EDIT</a></td>
						<td><a href="deleteStudent.do?sid=${student.sid}">DELETE</a></td>
					</tr>
				</c:forEach>

			</table>
		</center>
	</fieldset>
${student.sid}
</body>
</html>