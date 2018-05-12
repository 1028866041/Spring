package com.myself.controller;

import com.myself.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
@Controller
public class Ajax {

    @RequestMapping("/ajax")
    public String ajax(@RequestParam("name")String name, HttpServletResponse response){

        System.out.println(name);
        if(name.equals("ok"))
        {
            return "/WEB-INF/jsp/success.jsp";
        }
        else
        {
            return "/WEB-INF/jsp/failed.jsp";
        }
    }

    @RequestMapping("/ajax.do")
    public String ajax(HttpServletResponse response){

        System.out.println("ajax.do");
        return "/WEB-INF/jsp/success.jsp";
    }

    @RequestMapping("/json")
    /*ResponseBody将HTTP请求正文转换为适合的HttpMessageConverter对象*/
    public @ResponseBody List<User> json(){

        List<User> list = new ArrayList<>();
        list.add(new User(1,"zhangsan",20));
        list.add(new User(2,"lisi",21));
        list.add(new User(3,"wangwu",22));

        return list;
    }
}
