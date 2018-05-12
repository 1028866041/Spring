<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/28 0028
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="description" content="This is my page">

    <!--<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#btn').click(function(){
                $.post("ajax.do",function(data){
                    $("#content").html(data);
                });
            });
        });
    </script>-->
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#btn').click(function(){
                $.post("json",function(data){
                    var html="";
                    for(var i=0;i<data.length;i++){
                        html+="<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].age+"</td></tr>"
                    }
                    $('#content').html(html);
                });
            });
        });
    </script>
  </head>
  <body>
  ${name}
  <p>index page</p><br/>

  <!--测试post方法-->
  <!--
  <form action="user.do" method="post">
    name:<input type="text" name="name"/>
    <input type="submit" nme="submit">
  </form>-->

  <form id="file" action="upload" method="post" enctype="multipart/form-data">
    fileload1:<input type="file" name="file"/><br/>
    fileload2:<input type="file" name="file"/><input type="submit" value="upload"/><br/>
  </form>

  <form id="ajax" action="ajax" method="post">
    ajax:<input type="text" name="name"/><input type="submit" value="ajax"/>
  </form>

  <!--<input type="button" id="btn" value="ajax.do"/><br>
  <div id="content"></div><br>-->

  <input type="button" id="btn" value="json">
  <table width="70%" align="center">
    <tr>
      <td>id</td>
      <td>name</td>
      <td>age</td>
    </tr>
    <tbody id="content"></tbody>
  </table><br/>

  <a href="intercept">Interceptor</a><br>
  <a href="intercept/user">Interceptor with user</a>

  </body>
</html>
