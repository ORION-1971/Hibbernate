package com.hibernate.CollMappObject;

import com.hibernate.CollMappObject.entity.Friend;
import com.hibernate.CollMappObject.entity.Student;
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

            List<Friend> friends = new ArrayList<>();
            Friend friend1 = new Friend("Chanel", "Join", 23);
            Friend friend2 = new Friend("Leo", "Grid", 32);
            Friend friend3 = new Friend("Julia", "Black", 28);
            friends.add(friend1);
            friends.add(friend2);
            friends.add(friend3);

            Student student = new Student("Gunay", "Hashimove", 7.5, friends);
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
