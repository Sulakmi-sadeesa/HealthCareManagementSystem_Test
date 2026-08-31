package com.medihouse.dao;

import com.medihouse.config.HibernateUtil;
import com.medihouse.entity.Patient;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDAO {


    // =====================================================
    // SAVE PATIENT
    // =====================================================

    public boolean savePatient(Patient patient) {

        Transaction transaction = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            transaction = session.beginTransaction();

            session.persist(patient);

            transaction.commit();

            session.close();

            System.out.println(
                    "Patient saved successfully."
            );

            return true;

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // FIND PATIENT BY ID
    // =====================================================

    public Patient getPatientById(Long id) {

        Patient patient = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            patient =
                    session.get(
                            Patient.class,
                            id
                    );

            session.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return patient;
    }


    // =====================================================
    // FIND PATIENT BY PATIENT ID
    // Example: MH-00482
    // =====================================================

    public Patient getPatientByPatientId(String patientId) {

        Patient patient = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            patient =
                    session.createQuery(
                            "FROM Patient WHERE patientId = :patientId",
                            Patient.class
                    )
                    .setParameter(
                            "patientId",
                            patientId
                    )
                    .uniqueResult();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return patient;
    }


    // =====================================================
    // FIND PATIENT BY USERNAME
    // =====================================================

    public Patient getPatientByUsername(String username) {

        Patient patient = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            patient =
                    session.createQuery(
                            "FROM Patient WHERE username = :username",
                            Patient.class
                    )
                    .setParameter(
                            "username",
                            username
                    )
                    .uniqueResult();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return patient;
    }


    // =====================================================
    // PATIENT LOGIN
    // =====================================================

    public Patient login(
            String username,
            String password
    ) {

        Patient patient = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            patient =
                    session.createQuery(
                            "FROM Patient " +
                            "WHERE username = :username " +
                            "AND password = :password " +
                            "AND status = 'ACTIVE'",
                            Patient.class
                    )
                    .setParameter(
                            "username",
                            username
                    )
                    .setParameter(
                            "password",
                            password
                    )
                    .uniqueResult();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return patient;
    }


    // =====================================================
    // GET ALL PATIENTS
    // =====================================================

    public List<Patient> getAllPatients() {

        List<Patient> patients = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            patients =
                    session.createQuery(
                            "FROM Patient",
                            Patient.class
                    )
                    .getResultList();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return patients;
    }


    // =====================================================
    // UPDATE PATIENT
    // =====================================================

    public boolean updatePatient(Patient patient) {

        Transaction transaction = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            transaction =
                    session.beginTransaction();

            session.merge(patient);

            transaction.commit();

            session.close();

            System.out.println(
                    "Patient updated successfully."
            );

            return true;

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // DELETE PATIENT
    // =====================================================

    public boolean deletePatient(Long id) {

        Transaction transaction = null;

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();

            transaction =
                    session.beginTransaction();


            Patient patient =
                    session.get(
                            Patient.class,
                            id
                    );


            if (patient != null) {

                session.remove(patient);

                transaction.commit();

                session.close();

                System.out.println(
                        "Patient deleted successfully."
                );

                return true;
            }


            transaction.rollback();

            session.close();

            return false;

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // CHECK USERNAME
    // =====================================================

    public boolean usernameExists(String username) {

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();


            Long count =
                    session.createQuery(
                            "SELECT COUNT(p) " +
                            "FROM Patient p " +
                            "WHERE p.username = :username",
                            Long.class
                    )
                    .setParameter(
                            "username",
                            username
                    )
                    .uniqueResult();


            session.close();


            return count != null && count > 0;


        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // CHECK EMAIL
    // =====================================================

    public boolean emailExists(String email) {

        try {

            Session session =
                    HibernateUtil
                            .getSessionFactory()
                            .openSession();


            Long count =
                    session.createQuery(
                            "SELECT COUNT(p) " +
                            "FROM Patient p " +
                            "WHERE p.email = :email",
                            Long.class
                    )
                    .setParameter(
                            "email",
                            email
                    )
                    .uniqueResult();


            session.close();


            return count != null && count > 0;


        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}