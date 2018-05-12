package com.myself.impl;

import com.myself.model.User;
import com.myself.dao.UserDAO;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class UserDAOImpl implements UserDAO {

    public void save(User u){

        System.out.println("UserDAOImpl save name="+u.getName());
    }

    public void delete(User u) {

        System.out.println("UserDAOImpl delete name="+u.getName());
    }

}
