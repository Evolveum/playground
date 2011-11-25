<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>midPoint test JSP</title>

<script src="js/ajax.js" type="text/javascript"></script>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/evolveum.js" type="text/javascript"></script>
<script type="text/javascript">
	var object = null;
	var clicked;

	function fillB() {
		aa();
	}

	function aa() {
		var url = "Servlet?method=getContentOfObjectB";
		reqAjax(url, objB);
	}

	function objB(aa) {
		var object = aa;
		$("#text1").html("Integer is: " + object.count + "<br />");
		$("#text2").html("String is: " + object.variable + "<br />");

		var out = "List consist: <ul>";
		var list = object.list;

		for ( var i = 0; i < list.length; i++) {
			out += "<li>" + list[i] + "</li>";
		}
		out += "</ul>";
		$("#text3").html(out);
		$("#text4").html("HTML is: " + object.html + "<br />");
	}

	function fillC() {
		bb();
	}
	function bb() {
		var url = "Servlet?method=getContentOfObjectC";
		reqAjax(url, objC);
	}

	function objC(aa) {
		var object = aa;
		$("#text1").html("Integer is: " + object.count + "<br />");
		$("#text2").html("String is: " + object.variable + "<br />");

		var out = "List consist: <ul>";
		var list = object.list;

		for ( var i = 0; i < list.length; i++) {
			out += "<li>" + list[i] + "</li>";
		}
		out += "</ul>";
		$("#text3").html(out);
		$("#text4").html("HTML is: " + object.html + "<br />");
	}
	
</script>

</head>
<body>
	<input type="button" id="abcdef" value="click" onClick="fillB();">
	<input type="button" id="abcdef" value="click" onClick="fillC();">
	<br />
	<br />
	<span id="text1"></span>
	<br />
	<span id="text2"></span>
	<br />
	<span id="text3"></span>
	<br />
	<span id="text4"></span>

</body>
</html>