package com.hibernate.CollMappString;

import com.hibernate.CollMappString.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Create {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();

        try{
            tx.begin();

            List<String> frendNames = new ArrayList<>();
            frendNames.add("Chanel");
            frendNames.add("Leo");
            frendNames.add("Julia");

            Student student = new Student("Gunay", "Hashimove", 7.5, frendNames);
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
