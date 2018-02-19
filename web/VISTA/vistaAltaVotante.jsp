<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votaciones</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/style.css"/>
    </head>
    <body>
        <%@include file="../index.jsp"%>
        

        <section class="container">
            <div class="row col-5 justify-content-center offset-md-3">

                <form action="../controlAltaVotante" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Nombre</label>
                            <input type="text" class="form-control" name="nombreVotante" id="nombreVotante" placeholder="Nombre">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Apellidos</label>
                            <input type="text" class="form-control" name="apellidosVotante" id="apellidosVotante" placeholder="Apellidos">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAddress">Nif</label>
                        <input type="text" class="form-control" name="nifVotante" id="nifVotante" placeholder="Nif">
                    </div>
                    <div class="form-group">
                        <label for="inputAddress2">Contraseña</label>
                        <input type="password" class="form-control" name="passVotante" id="passVotante" placeholder="Password">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputCity">Fecha de nacimiento</label>
                            <input type="date" class="form-control" name="nacVotante" id="nacVotante">
                        </div>
                        <div class="row col-12"><button type="submit" value="Registro" name="botonAlta" class="btn btn-primary">Confirmar Alta</button></div>
                    </div>
                </form>

            </div>




        </section>
    </body>
</html>