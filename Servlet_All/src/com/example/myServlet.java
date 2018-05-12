package com.example;

import com.sun.org.apache.bcel.internal.classfile.ConstantUtf8;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
/*@WebServlet(name = "myServlet",urlPatterns = "/myServlet",
    initParams = {
        @WebInitParam(name = "none", value = "nothing")
})*/
public class myServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pra = request.getParameter("str");
        System.out.println("pra="+pra);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("Utf8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>jsp</title>");
        out.println("</head>");
        out.println("<p>this is my jsp page</p><p>你好</p>");
        out.println("<div>");
        out.println("<metadata>");
        out.println("<p>this is my jsp page from div</p>");
        out.println("</metadata>");
        out.println(this.getClass()); //get class of servlet object
        //out.println("<p>"+none+"="+nothing+"</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
    }
}
