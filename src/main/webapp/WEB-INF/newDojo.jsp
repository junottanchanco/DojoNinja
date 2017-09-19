<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<a href="/ninja/new"><button>New Ninja</button></a>
	<h1>Create a New Dojo</h1>
	
	<form:form action="/dojo/new" method="POST" modelAttribute="dojo">
		<form:input type="text" path="name" placeholder="Dojo Name"/>
		<br><input type="submit" value="Create">
	</form:form>
</body>
</html>