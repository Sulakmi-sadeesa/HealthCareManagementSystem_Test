package com.medihouse;

import com.medihouse.config.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestConnection {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Session session = null;

        try {

            System.out.println("--------------------------------");
            System.out.println("   MEDI HOUSE DATABASE TEST");
            System.out.println("--------------------------------");

            // Get Hibernate SessionFactory
            sessionFactory =
                    HibernateUtil.getSessionFactory();

            System.out.println(
                    "Hibernate SessionFactory created."
            );

            // Open database session
            session =
                    sessionFactory.openSession();

            System.out.println(
                    "Database connection successful!"
            );

            // Simple database test
            session.createNativeQuery(
                    "SELECT 1"
            ).getSingleResult();

            System.out.println(
                    "MySQL connection is working."
            );

            System.out.println("--------------------------------");
            System.out.println("       CONNECTION SUCCESS");
            System.out.println("--------------------------------");

        }

        catch (Exception e) {

            System.out.println("--------------------------------");
            System.out.println("       CONNECTION FAILED");
            System.out.println("--------------------------------");

            e.printStackTrace();

        }

        finally {

            // Close session
            if (session != null) {

                session.close();

            }

            // Close Hibernate
            HibernateUtil.shutdown();

        }
    }
}