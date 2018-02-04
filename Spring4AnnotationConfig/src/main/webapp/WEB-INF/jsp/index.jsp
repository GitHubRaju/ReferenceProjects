
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring 4 Web MVC via Annotations</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />
      <script type="text/javascript">

 function register() {
var name= document.getElementById('name').value;
var password=document.getElementById('password').value;
	document.forms[0].action="register/"+name+"/"+password;
	document.forms[0].submit();
}

function user() {
	var ind = document.getElementById('msg').value;
	var name = document.getElementById('sucess').value;
	if(ind==='Y'){
	window.open("http://localhost:8080/Spring4AnnotationConfig/"+name);
	}
	
}
function login()
{
var name= document.getElementById('name').value;
var password=document.getElementById('password').value;
	document.forms[0].action="/Spring4AnnotationConfig/login/"+name+"/"+password;	
	document.forms[0].submit();
	}
	
</script>
       <%--  <script src="${cp}/resources/js/js.js"></script> --%>   
  </head>
    <body onload="user()">
        <h4>Spring 4 Web MVC via Annotations</h4>
        <a href="hello">click here</a>
        <form>
Name  :<input id="name" type="text" name="name"><br>
  <input id="msg" type="hidden" value='${msg}'/>
  <input id="sucess" type="hidden" value='${name}'/>
Password  :<input id= "password" type="text" name="password"><br>
<input type="button" value="register" onclick="register()"> <input type="button" value="login" onclick="login()">
</form>
        Site says: <span class="blue">${msg}</span>
    </body >
</html>
