<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="template.jsp" flush="true" />
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#userpass").keypress(
						function(event) {
							if (event.which == 13) {
								login();
							}
						});
			});

	function login() {
		var name = $("#username").val();
		var pass = $("#userpass").val();
		var url = "Servlet?method=login&login_name=" + name
				+ "&login_password=" + pass + "";
		reqAjax(url, objB);
	}

	function objB(aa) {
		if (aa.errorMessage == undefined) {
			$(window.location).attr('href', 'index.jsp');
		}
	}
</script>
</head>
<body>
	<table border="1" align="center"
		style="width: 200px; height: 50px; margin-top: 300px;">
		<tr>
			<td colspan="2" align="center"><h2>Login</h2></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><input id="username" type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input id="userpass" type="password" name="userpass"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				name="button" value="login" onclick="login();"></td>
		</tr>
	</table>

</body>
</html>