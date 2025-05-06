package com.hibernate;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hiber_Delete {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();

        try{
            tx.begin();

            Student student = session.get(Student.class, 1);
            session.remove(student);

            tx.commit();
        }
        catch(Exception e){
            if(tx != null) {
                tx.rollback();
            }
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
