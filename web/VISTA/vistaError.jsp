<%-- 
    Document   : vistaError
    Created on : 14-feb-2018, 19:31:55
    Author     : jdani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../index.jsp"%>
        <% String error = request.getParameter("Error"); %>
        <h1><%out.println(error);%></h1>
    </body>
</html>
