package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FindUser_HQL {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        //typecasting needed since aggregate function will give to move fr
        String hqlQuery = "Select MAX(u.salary) from User u";
        Query q = session.createQuery(hqlQuery);
        double myData = (Double) q.getSingleResult();
        System.out.println("myData: " + myData);
        //Close resources
        factory.close();
        session.close();
    }
}