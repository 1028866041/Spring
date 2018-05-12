package com.myself.impl;

import com.myself.dao.LogDAO;
import com.myself.model.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class LogDAOImpl extends HibernateDaoSupport implements LogDAO {

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

    /*若使用HibernateDaoSupport则setSessionFactory方法不可被复写*/
    /*@Resource(mappedName = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/

    public void save(Log l) {

        /*1:sessionFactory方式：*/
        /*Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(l);
        session.getTransaction().commit();*/

        /*2.HibernateDaoSupport方式：*/
        this.getHibernateTemplate().getSessionFactory().getCurrentSession().beginTransaction();
        this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(l);
        this.getHibernateTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();

        System.out.println("LogDAOImpl save message="+l.getMessage());
    }

    public void delete(Log l) {

        System.out.println("LogDAOImpl delete message="+l.getMessage());
    }

    public void init() {
        System.out.println("bean init");
    }

    public void destroy() {
        System.out.println("bean destroy");
    }
}
