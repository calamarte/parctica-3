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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            <%@ include file="/resources/css/style.css"%>
        </style>
    </head>
    <body>
        <div id="app">
            <ul id="peerList">
                <li v-for="p in peers">
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

            <div id="block"></div>
            <button v-on:click="showBlockchain">Show Blockchain</button>
            <input v-model="data" type="text">
            <button v-on:click="addBlock">Add Block</button>

        </div>

        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Login</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <label for="user">User</label>
                        <input type="email" class="form-control" id="user" placeholder="Enter user">
                        <label for="pass">Password</label>
                        <input type="password" class="form-control" id="pass" placeholder="Password">
                    </div>
                    <div class="modal-footer">
                        <button id="save" type="button" class="btn btn-primary">Save</button>
                    </div>
                </div>
            </div>
        </div>




        <script src="https://cdn.jsdelivr.net/npm/vue@2.5.13/dist/vue.js"></script>
        <script>
            <%@ include file="/resources/js/script.js"%>
        </script>
    </body>
</html>
