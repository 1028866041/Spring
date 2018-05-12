package com.myself.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
@Controller
@SessionAttributes("user")
public class UserLogin {

    @RequestMapping("/intercept/login")
    public String loginUser(String name,ModelMap map){
        map.addAttribute("user", name);
        return "forward:/WEB-INF/jsp/index.jsp";
    }

    @RequestMapping("/loginsuccess")
    public String toLogin(){
        return "forward:/WEB-INF/jsp/success.jsp";
    }

    @RequestMapping("/loginfail")
    public String hello(){
        return "forward:/WEB-INF/jsp/failed.jsp";
    }

}
