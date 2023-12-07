<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>home</title>
</head>
    <body>
        <h1> check.jsp </h1>

    <form action="<c:url value='/check'/>" method="GET">
        <button type="submit">쿠키 확인</button>
    </form>
       <p>이름 ${userinfo.name}</p>
       <p>이메일 ${userinfo.email}</p>
       <p>비번 ${userinfo.password}</p>
       <p>주소 ${userinfo.address}</p>
    </body>
</html>

