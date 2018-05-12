package com.myself.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
@Entity
@Table(name="log")
public class Log {

    private int id;
    private String message;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {

        return message;
    }

}
