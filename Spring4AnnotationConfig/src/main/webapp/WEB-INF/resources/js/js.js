function user() {
	var mymsg = document.getElementById('msg').value;
	if (mymsg ==='Y') {
		window.open();
	}
}
function register() {
	var myString = document.getElementById('name').value;
	document.forms[0].action = "register/" + myString;
	document.forms[0].submit();
}
function login() {
	alert("Confirm ");
	document.forms[0].action = "selectcurd.do";
	document.forms[0].submit();
}
