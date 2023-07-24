<%-- 
    Document   : shopping
    Created on : Apr 17, 2023, 3:04:26 PM
    Author     : T14
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sp.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="sp.bw.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping page</title>
    </head>
    <body>
        <%--
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"US".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.html");
                return;
            }
        %>
        --%>

        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>

        <form action="MainController">
            <input type="submit" name="action" value="Get all"/>
            <input type="submit" name="action" value="View cart"/>
        </form>
        <%--
            <%
                List<Product> listProduct = (List<Product>) request.getAttribute("LIST_PRODUCT");
                if (listProduct != null) {
                    if (listProduct.size() > 0) {
            %>
        --%>
        <c:if test="${requestScope.LIST_PRODUCT != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>Product</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Add</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%--
                        <%
                            int count = 1;
                            for (Product pro : listProduct) {
                        %>
                        --%>
                        <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_PRODUCT}">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${product.productID}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>
                                    <input type="number" name="quantity" value="${product.quantity}" max="${product.quantity}" min="1" required=""/>
                                </td>
                                <td>
                                    <input type="submit" name="action" value="Add"/>
                                    <input type="hidden" name="productID" value="${product.productID}"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
            ${requestScope.MESSAGE}
    </c:if>

</body>
</html>
