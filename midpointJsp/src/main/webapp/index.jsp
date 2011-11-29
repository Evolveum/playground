<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="template.jsp" flush="true" />
<script type="text/javascript">
	$(document).ready(function() {
		var url = "Servlet?method=getLoggedUser";
		reqAjax(url, fillUser);
	});
	function fillUser(user) {
		if (user.errorMessage == undefined) {
			$("#text0").html(
					"<u>User's login name is:</u> " + user.userName + "<br />");
			$("#text1").html(
					"<u>User's password is:</u> " + user.userPass + "<br />");
			$("#text2").html(
					"<u>User's first name is:</u> " + user.userFirstName
							+ "<br />");
			$("#text3").html(
					"<u>User's last name is:</u> " + user.userLastName
							+ "<br />");
			$("#text4").html(
					"<u>User's nick name is:</u> " + user.userNickName
							+ "<br />");
			$("#text5").html(
					"<u>User's birth date is:</u> " + user.userBirthDate
							+ "<br />");
		} else {
			$(window.location).attr('href', 'login.jsp');
		}
	}

	function logout() {
		var url = "Servlet?method=logout";
		reqAjax(url);
	}
</script>

</head>
<body>
	<div id="content">
		<a href="login.jsp" onclick="logout();">Logout</a> <br /> <br /> <span
			id="text0"></span> <br /> <span id="text1"></span> <br /> <span
			id="text2"></span> <br /> <span id="text3"></span> <br /> <span
			id="text4"></span> <br /> <span id="text5"></span>
	</div>
</body>
</html>