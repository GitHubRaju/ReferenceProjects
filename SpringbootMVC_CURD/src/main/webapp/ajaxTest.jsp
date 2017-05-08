<html>
<script type="text/javascript">
function save(val)
{
	var a=document.getElementById(val).value;
	var url="/get?name="+a;
	alert(a);
	var requestObj = false;
	requestObj = new XMLHttpRequest();
	requestObj.onreadystatechange = function()
	{
		if(requestObj.readyState == 4 && requestObj.statua !== 200) {
			document.getElementById("name").innerHTML=requestObj.responseText;
			alert(requestObj.responseText);
			retrun;
			console.log(requestObj.responseText)
		}
	}
	//requestObj.open('GET', '/get', true);
	requestObj.open('GET', url, true);
	requestObj.send(' ');
}

</script>
<body>
<h2>Hello World!</h2>

Enter Name :<input id="name" type="text" onkeyup="save(this.id)">
</body>
</html>
