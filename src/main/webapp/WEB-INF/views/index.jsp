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

        <div id="app">
            <ul id="peerList">
                <li v-for="p in peers.peers">
                    <input v-model="peer" type="radio" :value="p">
                    <label>{{p.date}} {{p.ip}} {{p.name}}</label>
                </li>
            </ul>

            <table>
                <tr>
                    <td>Hash</td>
                    <td>Previous Hash</td>
                    <td>Data</td>
                    <td>Nonce</td>
                </tr>
                <tr v-for="block in blockchain">
                    <td>{{block.hash}}</td>
                    <td>{{block.previousHash}}</td>
                    <td>{{block.data}}</td>
                    <td>{{block.nonce}}</td>

                </tr>
            </table>


            <!--<p>{{blockchain}}</p>-->

            <div id="block"></div>
            <button v-on:click="showBlockchain">Show Blockchain</button>

            <button v-on:click="addBlock">Add Block</button>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.5.13/dist/vue.js"></script>
        <script>
            <%@ include file="/resources/js/script.js"%>
        </script>
        </div>

    </body>
</html>
