<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
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

  String name = request.getParameter("name");
  String password = request.getParameter("password");
  String confirmpassword = request.getParameter("confirmpassword");
  /*动态加载创建class对象*/
  Class.forName("com.mysql.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","mc","meichao");

  /*if(password != confirmpassword){
    response.sendRedirect("register_fail.jsp");
    conn.close();
    return;
  }*/
  String sql = "insert into register values(null,?,?)";
  PreparedStatement ps = conn.prepareStatement(sql);
  ps.setString(1,name);
  ps.setString(2,password);
  ps.executeUpdate();
  /*response.sendRedirect("register_success.jsp");*/
  ps.close();
  conn.close();
%>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form name="f" action="register_success.jsp.jsp" method="post">
      name:<input type="text" name="name">
      password:<input type="text" name="password">
      confirm password:<input type="text" name="confirmpassword">
      <br/>

    <input type="button" value="submit" onclick="javascript:document.f.action='/register.jsp';document.f.submit">
  </form>
    <br/>

  </body>
</html>
