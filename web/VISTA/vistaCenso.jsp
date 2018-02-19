<%@page import="MODELO.Votante"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/style.css"/>
        <title>Elecciones</title>
    </head>
    <body>
        <%@include file="../index.jsp"%>
        <div class="container">
            <h3>CENSO ELECTORAL</h3>          
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>NOMBRE</th>
                        <th>APELLIDOS</th>
                        <th>DNI</th>
                        <th>FECHA NACIMIENTO</th>
                        <th>VOTADO S/N</th>
                    </tr>
                </thead>
                <tbody>
                    <% HttpSession ArraySesion = request.getSession(true);%>
                    <% ArrayList<Votante> arrayListVotante = (ArrayList<Votante>) ArraySesion.getAttribute("arrayListVotantes");%>
                    <% for (int i = 0; i < arrayListVotante.size(); i++) {
                    %>
                    <tr class="warning">
                        <td><%=arrayListVotante.get(i).getNombre()%></td>
                        <td><%=arrayListVotante.get(i).getApellidos()%></td>
                        <td><%=arrayListVotante.get(i).getNif()%></td>
                        <td><%=arrayListVotante.get(i).getFecha_nac()%></td>
                        <td><%=arrayListVotante.get(i).getVotado()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
