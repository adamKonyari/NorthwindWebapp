<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="task3" method="post">
    <input type="text" name="company" value="company name">
    <input type="submit" value="filter">
</form>
<table>
    <thread>
        <tr>
            <th>Company</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "t3q" items="${task3Result}">
        <tr>
            <td><c:out value="${t3q.company}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>