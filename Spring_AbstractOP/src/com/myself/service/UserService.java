package com.myself.service;

import com.myself.impl.UserDAOImpl;
import com.myself.model.User;
import com.myself.dao.UserDAO;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
/*-->strus/hibernate/spring*/
public class UserService {

    //使用时new多种接口实现
    private UserDAO userdao = new UserDAOImpl();

    public UserDAO getUserdao() {
        return userdao;
    }

    public void setUserDAO(UserDAO userdao) {
        this.userdao = userdao;
        System.out.println("UserService set userdao");

    }

    public void add(User u)
    {
        userdao.save(u);
    }

    public void delete(User u)
    {
        userdao.delete(u);
    }
}
