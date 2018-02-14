<%--
  Created by IntelliJ IDEA.
  User: rmariscal
  Date: 5/02/18
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Iniciar sessió</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <ditbuciv class="card">
            <h1 class="card-header">Iniciar sessió</h1>
            <div class="card-body">
                <form method="post" action="inici">
                    <input type="text" name="user" placeholder="Usuari">
                    <input type="password" name="pass" placeholder="Contrasenya">
                    <input type="submit" name="login" class="btn btn-primary" value="Entrar">
                </form>
            </div>
        </ditbuciv>
    <script>


        let peerFetch = fetch("${ip}", {
            method: "POST",
            headers:{
                "Content-type":"application/x-www-form-urlencoded",
                    "Authorization":"Basic " + (usuario:contraseña) a base64
            }
        })
            .then(res => res.json())
        .then(res => this.peers = res);
    </script>
    </body>
</html>
