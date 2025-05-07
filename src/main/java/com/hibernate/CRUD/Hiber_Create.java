package com.hibernate.CRUD;

import com.hibernate.CRUD.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hiber_Create {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();

        try{
            tx.begin();

            Student student = new Student("Gunay", "Hashimove", 7.5);
            session.persist(student);

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
