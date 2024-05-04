<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <h1>hello world!</h1>
    <%@include file="footer.jsp" %>

    <p>randomUser: ${requestScope["user"]}</p>
    <p>jsessionid: ${cookie["JSESSIONID"]}</p>
    <p>${param["id"]}</p>
</body>
</html>