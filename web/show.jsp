<%-- 
    Document   : show
    Created on : Apr 25, 2023, 3:55:56 PM
    Author     : T14
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="sp.bw.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Page</title>
    </head>
    <body>
    
    <c:if test="${requestScope.LIST_USER != null}">
        <c:if test="${not empty requestScope.LIST_USER}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>User ID</th>
                        <th>Full Name</th>
                        <th>Role ID</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
                   

                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                <input type="text" name="userID" value="${user.userID}" readonly="">
                            </td>
                            <td>
                                <input type="text" name="fullName" value="${user.fullName}"/>
                            </td>
                            <td>
                                <input type="text" name="roleID" value="${user.roleID}"/>
                            </td>
                            <td>
                                ${user.password}
                            </td>
                        </tr>
                   
                </c:forEach>

                </tbody>
            </table>
            ${requestScope.ERROR}

        </c:if>
    </c:if>
</body>
</html>
