package com.dhu.dao;


import java.util.List;

import javax.swing.JOptionPane;

import com.dhu.pojo.Baseinformation;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;

import com.dhu.pojo.Baseinformation;
import sun.awt.SunHints;


public class BaseinformationDAO {
    private Session session;
    private SessionFactory sessionFactory;
    private Transaction transaction;
    BaseinformationDAO getSession;



    public BaseinformationDAO(){
    }








    public void message(String mess){
        int type= JOptionPane.YES_NO_OPTION;
        String title="提示信息";
        JOptionPane.showMessageDialog(null, mess,title,type);
    }

    public void add(Baseinformation p) {
        List<Baseinformation> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        s.save(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

        //测试可能无法用到模板函数，不能通过改为 String,username
    public Baseinformation get( int id) {
        Baseinformation result = null;

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        result = (Baseinformation) s.get(Baseinformation.class, id);

        s.close();
        sf.close();
        return result;
    }



    public void delete(int id) {
        List<Baseinformation> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Baseinformation p = (Baseinformation) s.get(Baseinformation.class, id);

        s.delete(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public void update(Baseinformation p) {
        List<Baseinformation> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.update(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public List<Baseinformation> listBaseinformation() {
        List<Baseinformation> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from Baseinformation p");

        result = q.list();

        s.close();
        sf.close();
        return result;
    }

    /*public SessionFactory config(){
        try{
            Configuration configuration= new Configuration();
            Configuration configure=configuration.configure("hibernate.cfg.xml");
            return configure.buildSessionFactory();
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }*/

    //回头再想用法
    public List queryInfo(String type,Object value){
        /*getSession=new BaseinformationDAO();
        sessionFactory=config();
        session=sessionFactory.openSession();*/
        Configuration configuration= new Configuration();
        Configuration cfg=configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session session = sf.openSession();


        try{
            String hqlsql="from Baseinformation as u where u.name=?";
            Query query=session.createQuery(hqlsql);
            query.setParameter(0, value);
            List list=query.list();
            transaction  = session.beginTransaction();
            transaction.commit();
            session.close();
            return list;
        }catch(Exception e){
            message("BaseinformationDAO类中有异常，异常为：:"+e);
            e.printStackTrace();
            return null;
        }
    }

    public String saveInfo(Baseinformation info){
        String mess="error";
        getSession=new BaseinformationDAO();

        try{
            transaction = session.beginTransaction();
            session.save(info);
            transaction.commit();
            mess="success";
            return mess;
        }catch(Exception e){
            message("RegisterInfo.error:"+e);
            e.printStackTrace();
            return null;
        }
    }
}
