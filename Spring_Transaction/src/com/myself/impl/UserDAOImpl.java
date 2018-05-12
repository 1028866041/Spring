package com.myself.impl;

import com.myself.model.User;
import com.myself.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/6/11 0011.
 */

public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;

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

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void save(User u) {

        /*1:sessionFactory方式：*/
        Session session = sessionFactory.getCurrentSession();
        /*meichao:Spring4中即便已标注使用HibernateTransactionManager仍需启动Transaction*/
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();

        System.out.println("UserDAOImpl sessionFactory save name="+u.getName());

        /*2:hibernateTemplate方式：*/
        hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
        hibernateTemplate.save(u);
        hibernateTemplate.getSessionFactory().getCurrentSession().getTransaction().commit();
        System.out.println("UserDAOImpl hibernateTemplate save name="+u.getName());

        /*尝试抛出异常验证Transaction回滚*/
        //throw new RuntimeException();
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
