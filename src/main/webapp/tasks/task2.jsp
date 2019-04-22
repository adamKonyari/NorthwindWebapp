<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="task2" method="post">
    <input type="number" name="numberOfProducts">
    <input type="submit" value="filter">
</form>
<table>
    <thread>
        <tr>
            <th>Company</th>
            <th>NumberOfProducts</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "t2q" items="${task2Result}">
        <tr>
            <td><c:out value="${t2q.company}"></c:out></td>
            <td><c:out value="${t2q.numberOfProducts}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>