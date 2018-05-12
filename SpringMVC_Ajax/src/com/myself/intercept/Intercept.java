package com.myself.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class Intercept implements /*WebRequestInterceptor*/ HandlerInterceptor{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null)
            return true;
        String path=request.getRequestURI();
        if(path.endsWith("user")) {
            response.sendRedirect("/SpringMVC_Ajax/loginsuccess");
        /*
        1.preHandle返回false则从当前拦截器往回执行前面拦截器afterCompletion方法再退出拦截器链。
        2.preHandle返回true则执行下一拦截器直到所有拦截器执行完；再运行被拦截的Controller，
            进入拦截器链运行所有拦截器的postHandle方法,最后从最终拦截器往回执行所有拦截器的afterCompletion方法。
        */
            return false;
        }
        response.sendRedirect("/SpringMVC_Ajax/loginfail");

        System.out.println("preHandle");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("afterCompletion");
    }

    /*
    void preHandle(WebRequest var1) throws Exception{

    }

    void postHandle(WebRequest var1, ModelMap var2) throws Exception{

    }

    void afterCompletion(WebRequest var1, Exception var2) throws Exception{

    }*/
}


