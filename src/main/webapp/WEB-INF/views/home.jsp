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
        <h1> home.jsp </h1>

    <form action="<c:url value='/login'/>" name="login_form" method="POST">
        <c:choose>
        <c:when test="${mainVo} != null">
             이름 <input type="text" name="name" value="${mainVo.name}"/>
             이메일 <input type="text" name="email" value="${mainVo.email}" />
             비밀번호 <input type="text" name="password" value="${mainVo.password}" />
             주소 <input type="text" name="address" value="${mainVo.address}" />
        </c:when>
        <c:otherwise>
            이름 <input type="text" name="name"/>
            이메일 <input type="text" name="email" />
            비밀번호 <input type="text" name="password" />
            주소 <input type="text" name="address" />
        </c:otherwise>
        </c:choose>
        <button type="submit">제출</button>
    </form>

    </body>
</html>

