<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form action="/registration" method="post">
        <label for="username">Name:
            <input type="text" name="name" id="username">
        </label>
        <label for="password">Password:
            <input type="password" name="password" id="password">
        </label>
        <label for="email">Email:
            <input type="email" name="email" id="email">
        </label>
        <button type="submit">Send</button>
    </form>
</body>
</html>