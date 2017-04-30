<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function update()
{
	document.forms[0].action="updateStudent.do";
	document.forms[0].submit();
	}
</script>
</head>
<body>
<form:form   action= ""      commandName="studentList">
<form:input type="hidden" path="sid"/>
<table border="2">
<tr><td>Student Name :</td><td><form:input  path="name"/></td></tr>
<tr><td>Email :</td><td><form:input  path="email"/></td></tr>
<tr><td></td><input  type="button"  value="Update"  onclick="update()"/></td></tr>
</table>
</fieldset>
</center>
</form:form>
</body>
</html>