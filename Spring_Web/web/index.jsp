<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/21 0021
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path= request.getContextPath();
  String basepath=  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <p>register goto:</p>
    <a href="<%=basepath %>register.jsp">register.jsp</a>

  </body>
</html>
