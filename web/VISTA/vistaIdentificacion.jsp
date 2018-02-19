
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
        <section class="container">
            <div class="row col-5 justify-content-center offset-md-3">
                <h3 class="row col-12 offset-md-2">Identificaci&oacuten del votante</h3>
                <form action="../controlIdentificacion" method="post">
                    <div class="form-group">
                        <label for="inputAddress">Nif</label>
                        <input type="text" class="form-control" name="nifVotante" id="nifVotante" placeholder="Nif">
                    </div>
                    <div class="form-group">
                        <label for="inputAddress2">Contrase&ntildea</label>
                        <input type="password" class="form-control" name="passVotante" id="passVotante" placeholder="Password">
                    </div>
                    <div class="form-row">
                        <div class="row col-12 offset-md-2"><button type="submit" value="Indentificacion" name="botonIdentificacion" class="btn btn-primary">Indentificarse</button></div>
                    </div>
                </form>

            </div>
        </section>
    </body>
</html>
