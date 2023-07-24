<%-- 
    Document   : user
    Created on : Apr 13, 2023, 3:53:16 PM
    Author     : T14
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sp.bw.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>User Information</h1>
        <%--
        <% 
            UserDTO user = (UserDTO)session.getAttribute("LOGIN_USER");
            if (user==null || !"US".equals(user.getRoleID())){
                response.sendRedirect("login.html");
                return;
            }
        %>
        --%>
        <form action="MainController">
            <input type="submit" name="action" value="Show"/>
        </form>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        User ID: ${sessionScope.LOGIN_USER.userID}<br/>
        Full Name: ${sessionScope.LOGIN_USER.fullName}<br/>
        Role ID: ${sessionScope.LOGIN_USER.roleID}<br/>
        Password: ${sessionScope.LOGIN_USER.password}<br/>
        <a href="shopping.html">Shopping</a>
    </body>
</html>
