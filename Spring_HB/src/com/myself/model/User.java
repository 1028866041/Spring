package com.myself.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
@Entity
public class User {

    private int id;
    private String name;
    private String password;


    public void setId(int id) {
        this.id = id;
    }

    @Id
    /*对Spring而言是invoke/getId*/
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
