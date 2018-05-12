package com.myself.dao;

import com.myself.model.User;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public interface UserDAO {

    public void save(User u) throws SQLException;

    public void delete(User u);

}
