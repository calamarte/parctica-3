<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 09/02/2018
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: xavi
  Date: 31/01/18
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>


<div id="content">
    <%--<a href="/pollo">Pollo!</a>--%>
</div>

<script>
    var addClickEvent = function(){
        document.querySelectorAll('a').forEach(function(link){
            link.addEventListener('click',function(event){
                event.preventDefault();
                fetch(this.href,{
                    method:"GET",
                    headers:
                        {
                            "Content-type":"application/x-www-form-urlencoded",
                            "Authorization":"Basic " + localStorage.credentials
                        }
                })
                    .then(function(response){
                        response.text().then(function(text) {
                                document.querySelector('#content').innerHTML=text;
                            }
                        );
                    });
            }, false);
        })
    };
    var addFormEvent = function(){ document.querySelectorAll('form').forEach(function(link){
        link.addEventListener('submit',function(event){
            event.preventDefault();
            var formData = new FormData(this);
            fetch(this.action,{
                method:"POST",
                headers:
                    {
                        "Content-type":"application/x-www-form-urlencoded",
                        "Authorization":"Basic " +localStorage.credentials
                    },
                body: formData
            })
                .then(function(response){
                    response.text().then(function(text) {
                            document.querySelector('#content').innerHTML=text;
                        }
                    );
                });
        }, false);
    })
    };
    addClickEvent();
    addFormEvent();
    document.querySelector('#content').addEventListener("DOMSubtreeModified", addClickEvent);
    document.querySelector('#content').addEventListener("DOMSubtreeModified", addFormEvent);
</script>
</body>
</html>
