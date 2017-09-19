<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${dojo.name} Ninjas</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${ninjas}" var="ninja">
		<tr>
			<td><c:out value="${ninja.first_name} ${ninja.last_name}"/></td>
			<td><c:out value="${ninja.age}"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>