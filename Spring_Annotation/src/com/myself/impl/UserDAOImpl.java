package com.myself.impl;

import com.myself.model.User;
import com.myself.dao.UserDAO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
@Component
public class UserDAOImpl implements UserDAO {
/*Component：UserDAOImpl做key值找生成的对象*/

    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;

    public void save(User u){

        System.out.println("UserDAOImpl save name="+u.getName());
    }

    public void delete(User u) {

        System.out.println("UserDAOImpl delete name="+u.getName());
    }

    public void setList(List<String> list) {
        this.list = list;
        System.out.println("UserDAOImpl setList");
    }

    public void setSet(Set<String> set) {
        this.set = set;
        System.out.println("UserDAOImpl setSet");
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
        System.out.println("UserDAOImpl setMap");
    }

    public List<String> getList() {
        return list;
    }

    public Set<String> getSet() {
        return set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    @PostConstruct
    public void init() {
        System.out.println("bean init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("bean destroy");
    }
}
