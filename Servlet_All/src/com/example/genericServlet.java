package com.example;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/6/10 0010.
 */
/*@WebServlet(name = "genericServlet", urlPatterns = "/genericServlet",
    initParams = {
        @WebInitParam(name = "none", value="nothing")
})*/

/*Z直接继承Servlet扩展类GenericServlet而非实现Servlet接口，仅复写service()方法即可*/
/* 初始化参数在对象初始化时由Servlet容器(即运行Servlet的Server)自动填入
 * 每次访问均调用service()方法得到respons */
public class genericServlet extends GenericServlet {

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }*/

    private static final long serialVersionUID = 62500890L; //序列化/用于对象持久化

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        String value =  getServletConfig().getInitParameter("none");
        PrintWriter out  = servletResponse.getWriter();
        out.println("<html><head>servlet</head><body>");
        out.println("<p>"+"value=" + value + "</p></br>");
        out.println("<div>");
        out.println("<metadata>");
        out.println("<p>this is my jsp page from div</p>");
        out.println("</metadata>");
        out.println(this.getClass()); //反射机制:动态获取对象运行时状态//
        //out.println("<p>"+none+"="+nothing+"</p>");
        out.println("</div>");
        out.println("</body>"+"</html>");

        out.flush();
        out.close();
    }
}
