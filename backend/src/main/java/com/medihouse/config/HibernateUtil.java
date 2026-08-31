package com.medihouse.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        try {

            sessionFactory =
                    new Configuration()
                            .configure("hibernate.cfg.xml")
                            .buildSessionFactory();

            System.out.println(
                    "Hibernate SessionFactory created successfully."
            );

        } catch (Throwable ex) {

            System.err.println(
                    "Failed to create Hibernate SessionFactory."
            );

            ex.printStackTrace();

            throw new ExceptionInInitializerError(ex);
        }
    }


    /**
     * Returns the Hibernate SessionFactory.
     */
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }


    /**
     * Closes Hibernate when the application shuts down.
     */
    public static void shutdown() {

        getSessionFactory().close();

        System.out.println(
                "Hibernate SessionFactory closed."
        );
    }
}