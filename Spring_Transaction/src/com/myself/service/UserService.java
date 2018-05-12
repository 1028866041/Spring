package com.myself.service;

import com.myself.dao.LogDAO;
import com.myself.impl.LogDAOImpl;
import com.myself.impl.UserDAOImpl;
import com.myself.model.Log;
import com.myself.model.User;
import com.myself.dao.UserDAO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
/*-->strus/hibernate/spring*/
@Component
public class UserService {

    /*meichao:注入时需要默认无参构造器
     *因Spring通过反射机制实例化被注入类/如果此类没有无参构造器则无法反射实例化*/
    public UserService(){

    }

    //使用时new多种接口实现
    private UserDAO userdao = new UserDAOImpl();
    private LogDAO logdao = new LogDAOImpl();

    public UserService(UserDAO userdao){
        this.userdao = userdao;
        System.out.println("UserService set userdao init");
    }

    public UserService(LogDAO logdao){
        this.logdao = logdao;
        System.out.println("UserService set logdao init");
    }

    public UserDAO getUserdao() {
        return userdao;
    }

    public void setUserDAO(UserDAO userdao) {
        this.userdao = userdao;
        System.out.println("UserService set userdao set");
    }

    public LogDAO getLogdao() { return logdao; }

    public void setLogDAO(LogDAO logdao) {
        this.logdao = logdao;
        System.out.println("UserService set logdao set");
    }

    @Transactional
    public void add (User u)
    {
        try {
            userdao.save(u);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(User u)
    {
        userdao.delete(u);
    }

    @Transactional
    public void add (Log l)
    {
        try {
            logdao.save(l);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(Log l)
    {
        logdao.delete(l);
    }
}
