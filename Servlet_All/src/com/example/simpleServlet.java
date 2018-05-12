package com.example;


import javax.servlet.*;
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
/*@WebServlet(name = "simpleServlet", urlPatterns="/simpleServlet",
    initParams = {
        @WebInitParam(name="none", value="nonething")
}
)*/

public class simpleServlet  implements Servlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }*/

    private ServletConfig  config;
    public void init(ServletConfig servletCfg) throws ServletException {
        this.config = servletCfg;
            //getServletConfig(); cause null pointer
    }

    public ServletConfig getServletConfig(){
        return config;
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String value = getServletConfig().getInitParameter("none");
        PrintWriter out = response.getWriter();
        out.println("<html><head>servlet</head><body>");
        out.println("<p>"+"value=" + value + "</p></br>");
        out.println("<div>");
        out.println("<metadata>");
        out.println("<p>this is my jsp page from div</p>");
        out.println("</metadata>");
        out.println(this.getClass()); //get class of servlet object
        //out.println("<p>"+none+"="+nothing+"</p>");
        out.println("</div>");
        out.println("</body>"+"</html>");
        out.flush();
        out.close();
    }

    public String getServletInfo(){
        return this.getServletInfo();
    }

    public void destroy(){

    }
}
