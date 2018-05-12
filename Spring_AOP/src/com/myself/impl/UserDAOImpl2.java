package com.myself.impl;

import com.myself.model.User;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class UserDAOImpl2 extends UserDAOImpl {
    @Override
    public void save(User u) {

        System.out.println("UserDAOImpl2 save name="+u.getName());
        super.save(u);
    }

    @Override
    public void delete(User u) {
        super.delete(u);
    }
}
