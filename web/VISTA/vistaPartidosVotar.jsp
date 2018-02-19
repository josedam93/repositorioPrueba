<%@page import="MODELO.Partido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../index.jsp"%>

        <div class="container">
            <h3>VOTANTE</h3>          
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
                    <% Votante Votante = (Votante) ArraySesion.getAttribute("Votante");%>
                    <tr class="warning">
                        <td><%=Votante.getNombre()%></td>
                        <td><%=Votante.getApellidos()%></td>
                        <td><%=Votante.getNif()%></td>
                        <td><%=Votante.getFecha_nac()%></td>
                        <td><%=Votante.getVotado()%></td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="container">
            <h3>PARTIDOS</h3>
            <p>Elige el partido al que quieres votar.</p>
            <form action="../controlVotar" method="post">           
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>NOMBRE</th>
                            <th>SIGLAS</th>
                            <th>LOGOTIPO</th>
                            <th>VOTAR</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% HttpSession ArraySesionV = request.getSession(true);%>
                        <% ArrayList<Partido> arrayListPartidos = (ArrayList<Partido>) ArraySesionV.getAttribute("arrayListPartidos");%>

                        <% for (int i = 0; i < arrayListPartidos.size(); i++) {
                        %>
                        <tr>
                            <td><%=arrayListPartidos.get(i).getNombre()%></td>
                            <td><%=arrayListPartidos.get(i).getSiglas()%></td>
                            <td><img src=<%=arrayListPartidos.get(i).getLogo()%>></td>
                            <td><input type="radio" name="partidos" value=<%=arrayListPartidos.get(i).getSiglas()%>></td>
                        </tr>
                        <%}%>
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th><input type="submit" value="Votar" name="botonVotar"/></th>
                        </tr>
                    </tbody>
                </table>
            </form> 
        </div>




    </body>
</html>
