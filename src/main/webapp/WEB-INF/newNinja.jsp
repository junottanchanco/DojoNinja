<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
	<h1>Create New Ninja</h1>
	
	<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
		<form:label path="dojo">Dojo: 
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.id}">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</form:label><br>
		<form:errors path="first_name"/>
		<form:input type="text" path="first_name" placeholder="First Name"/><br>
		<form:errors path="last_name"/>
		<form:input type="text" path="last_name" placeholder="Last Name"/><br>
		<form:label path="age">Age:
			<form:errors path="age"/>
			<form:input type="number" path="age"/>
		</form:label><br>
		
		<br><input type="submit" value="Create">
	</form:form>
</body>
</html>