<%--
  Created by IntelliJ IDEA.
  User: fjrotgerl
  Date: 6/02/18
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Index</title>
        <style>
            <%@ include file="/resources/css/style.css"%>
        </style>
    </head>
    <body>
        <div class="wrapper">
            <p>Hola ${name}</p>

            <div>
                <h1>Peers</h1>
                <div id="peers"></div>
            </div>
        </div>
        <script>
            <%@ include file="/resources/js/script.js"%>
        </script>
    </body>
</html>
