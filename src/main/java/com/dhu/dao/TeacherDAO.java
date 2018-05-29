package com.dhu.dao;


import java.util.List;

import javax.swing.JOptionPane;

import com.dhu.pojo.Teacher;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;

import com.dhu.pojo.Teacher;
import sun.awt.SunHints;


public class TeacherDAO {
    private Session session;
    private SessionFactory sessionFactory;
    private Transaction transaction;
    TeacherDAO getSession;



    public TeacherDAO(){
    }








    public void message(String mess){
        int type= JOptionPane.YES_NO_OPTION;
        String title="提示信息";
        JOptionPane.showMessageDialog(null, mess,title,type);
    }

    public void add(Teacher p) {
        List<Teacher> result = new ArrayList();

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
    public Teacher get( int id) {
        Teacher result = null;

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        result = (Teacher) s.get(Teacher.class, id);

        s.close();
        sf.close();
        return result;
    }



    public void delete(int id) {
        List<Teacher> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Teacher p = (Teacher) s.get(Teacher.class, id);

        s.delete(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public void update(Teacher p) {
        List<Teacher> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.update(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public List<Teacher> listTeacher() {
        List<Teacher> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from Teacher p");

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
        /*getSession=new TeacherDAO();
        sessionFactory=config();
        session=sessionFactory.openSession();*/
        Configuration configuration= new Configuration();
        Configuration cfg=configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session session = sf.openSession();


        try{
            String hqlsql="from Teacher as u where u.id=?";
            Query query=session.createQuery(hqlsql);
            query.setParameter(0, value);
            List list=query.list();
            transaction  = session.beginTransaction();
            transaction.commit();
            session.close();
            return list;
        }catch(Exception e){
            message("TeacherDAO类中有异常，异常为：:"+e);
            e.printStackTrace();
            return null;
        }
    }

    public String saveInfo(Teacher info){
        String mess="error";
        getSession=new TeacherDAO();

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
