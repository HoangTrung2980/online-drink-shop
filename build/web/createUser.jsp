<%-- 
    Document   : createUser
    Created on : Apr 15, 2023, 3:27:57 PM
    Author     : T14
--%>

<%@page import="sp.bw.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        Create new user:
        <%
            UserError userError = (UserError)request.getAttribute("USER_ERROR");
            if(userError == null) userError = new UserError();
            %>
        <form action="MainController" method="POST">
            User ID: <input type="text" name="userID" required=""/>
            ${requestScope.USER_ERROR.userIDError}<br>
            Full name: <input type="text" name="fullName" required=""/>
            ${requestScope.USER_ERROR.fullNameError}<br>
            RoleID: <input type="text" name="roleID" value="US" readonly=""/>
            ${requestScope.USER_ERROR.roleIDError}<br>
            Password: <input type="password" name="password" required=""/><br>
            Confirm: <input type="password" name="confirm" required=""/>
            ${requestScope.USER_ERROR.confirmError}<br>
            <input type="submit" name="action" value="Create"/>
            <input type="Reset" value="Reset"/>
            ${requestScope.USER_ERROR.error}<br>
        </form>
    </body>
</html>
