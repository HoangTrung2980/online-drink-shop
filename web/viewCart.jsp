<%-- 
    Document   : viewCart
    Created on : Apr 17, 2023, 4:45:31 PM
    Author     : T14
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sp.product.Product"%>
<%@page import="sp.shopping.Cart"%>
<%@page import="java.util.List"%>
<%@page import="sp.bw.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View cart page</title>
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
        <h1>Your shopping cart</h1>
        <%--
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
        %>
        --%>
        <c:if test="${sessionScope.CART !=null}">
            <c:if test="${not empty sessionScope.CART}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>Product</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%--
                        <%
                            int count = 1;
                            double total = 0;
                            for (Product pro : cart.getCart().values()) {
                                total += pro.getPrice() * pro.getQuantity();
                        %>
                        --%>

                        <c:forEach var="pro" varStatus="counter" items="${sessionScope.CART.getCart().values()}">
                            <c:set var="total" value="${total + pro.price * pro.quantity}"/>
                            <form action="MainController">
                                <tr>

                                    <td>${counter.count}</td>
                                    <td>
                                        <input type="text" name="productID" value="${pro.productID}" readonly=""/>
                                    </td>
                                    <td>${pro.name}</td>
                                    <td>${pro.price}</td>
                                    <td>
                                        <input type="number" name="quantity" value="${pro.quantity}" required=""/>
                                    </td>
                                    <td>
                                        ${pro.price * pro.quantity}
                                    </td>
                                    <td>
                                        <input type="submit" name="action" value="Edit"/>
                                    </td>
                                    <td>
                                        <input type="submit" name="action" value="Remove"/>
                                    </td>
                            </form>
                        </c:forEach>
                </tr>
            </tbody>
        </table>
        <h1>Total: ${total}</h1>
        <a href="MainController?action=Get all">Add more.</a> 
    </c:if>
</c:if>
</body>
</html>
