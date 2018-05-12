package com.myself.impl;

import com.myself.model.User;
import com.myself.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/6/11 0011.
 */

public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
    private SessionFactory sessionFactory;

    public DataSource getDataSource() {
        System.out.println("setDataSource");
        return dataSource;
    }

    public void setDataSource(DataSource datasource) {
        this.dataSource = datasource;
        System.out.println("setDataSource："+datasource);
    }

    @Resource(mappedName = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void save(User u) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();

        /*String sql = "";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            /*meichao for debug:
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "mc", "meichao");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);*/

            /*sql = "drop table user";
            ps.executeUpdate(sql);
            sql = "create table user(id int not null primary key," + "age int," + "name varchar(255)" + ")";
            ps.executeUpdate(sql);
            sql = "insert into user(id,name,age) values(1,'zhangsan',20)";
            ps.executeUpdate(sql);
            conn.close();
        }*/
        /*catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }*/

        System.out.println("UserDAOImpl save name="+u.getName());
    }

    public void delete(User u) {

        System.out.println("UserDAOImpl delete name="+u.getName());
    }

    public void init() {
        System.out.println("bean init");
    }

    public void destroy() {
        System.out.println("bean destroy");
    }
}
