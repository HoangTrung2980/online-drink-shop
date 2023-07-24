<%-- 
    Document   : login
    Created on : Apr 13, 2023, 3:50:23 PM
    Author     : T14
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="MainController" method="POST">
            UserID: <input type="text" name="userID"/><br/>
            Password: <input type="password" name="password"/><br/>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
            <input type="submit" name="action" value="Show"/><br/>
            <a href="createUser.jsp">Create user</a>
        </form>
        ${requestScope.ERROR}
    </body>
</html>