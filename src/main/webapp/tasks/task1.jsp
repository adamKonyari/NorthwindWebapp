<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="task1" method="post">
    <input type="text" name="company" value="company name">
    <input type="submit" value="filter">
</form>
<table>
    <thread>
        <tr>
        <th>PRODUCT</th>
        <th>COMPANY</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "t1q" items="${task1Result}">
        <tr>
            <td><c:out value="${t1q.product}"></c:out></td>
            <td><c:out value="${t1q.company}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>