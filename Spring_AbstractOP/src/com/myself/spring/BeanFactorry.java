package com.myself.spring;

import com.myself.dao.UserDAO;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public interface BeanFactorry {

    public UserDAO getBean(String name);
}
