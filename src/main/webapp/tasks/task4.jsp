<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="task4" method="post">
    <input type="text" name="company" value="company name">
    <input type="submit" value="filter">
</form>
<table>
    <thread>
        <tr>
            <th>Company</th>
            <th>order_id</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "t4q" items="${task4Result}">
        <tr>
            <td><c:out value="${t4q.company}"></c:out></td>
            <td><c:out value="${t4q.order_id}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>