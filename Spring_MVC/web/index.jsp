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
  </head>
  <body>
  ${name}
  <p>index page</p><br/>

  <!--测试post方法-->
  <form action="user.do" method="post">
    name:<input type="text" name="name"/>
    <input type="submit" nme="submit">

  </form>
  </body>
</html>
