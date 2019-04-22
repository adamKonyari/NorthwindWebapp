<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="task5" method="post">
    <input type="text" name="product_name" value="product name">
    <input type="submit" value="filter">
</form>
<table>
    <thread>
        <tr>
            <th>company_name</th>
            <th>product_name</th>
            <th>unit_price</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "t5q" items="${task5Result}">
        <tr>
            <td><c:out value="${t5q.company_name}"></c:out></td>
            <td><c:out value="${t5q.product_name}"></c:out></td>
            <td><c:out value="${t5q.unit_price}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>