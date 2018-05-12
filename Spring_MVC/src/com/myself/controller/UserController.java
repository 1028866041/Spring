package com.myself.controller;

import javax.servlet.ServletException;

import com.myself.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
@Controller
/*使用xml方式需实现Controller接口/(注意bean name)*/
class UserController /*implements org.springframework.web.servlet.mvc.Controller*/ {

    @RequestMapping("/user.do")
    /*meichao:仅在使用ModelAndView中setViewName方法时才需配置渲染器*/
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user","user");
        modelAndView.setViewName("user");
        return modelAndView;
        //return new ModelAndView("/user.jsp");
    }

    @RequestMapping("/request")
    public void handleRequest1(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.setAttribute("user","request");
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("request1")
    public void handleRequest2(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().println("user request");
    }

    @RequestMapping("/user1")
    public String user1(/*@RequestParam("uname")*/ String name){
        /*转到action或jsp均可*/
        System.out.println(name);
        return "forward:index.jsp";
    }

    @RequestMapping("/user2")
    public String user2(){
        return "redirect: index.jsp";
    }

    @RequestMapping("/user3")
    /*表单传递对象方式:*/
    public String user3(User user){
        System.out.println(user.getId()+" "+user.getName()+" "+user.getAge());
        return "user";
    }

    @RequestMapping("/user4")
    /*ModelAndView与ModelView:ModelAndVie可指定要跳转视图需渲染器/ModelView不需要*/
    public String user4(String name, ModelMap modelMap){
        /*同request.setAttribute()*/
        modelMap.addAttribute("name",name);
        System.out.println(name);
        return "forward:index.jsp";
    }

    /*Restfull风格url:轻量、安全、效率高*/
    /*此处从broswer传值到server故用get方法/不可用post*/
    @RequestMapping(value = "/user5/{id}/{name}", method = RequestMethod.GET)
    public String user5(@PathVariable int id,@PathVariable String name ){
        System.out.println("restfull "+id+" "+name);
        return "user";
    }

}
