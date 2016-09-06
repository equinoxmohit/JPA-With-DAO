/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.persistance.DAO.impl;

import com.mohit.persistance.DAO.PatientDAO;
import com.mohit.persistance.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mohit
 */
public class PatientDAOImpl implements PatientDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistancePU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction trans = em.getTransaction();
    private List<Patient> patientList = new ArrayList<>();

    @Override
    public void insert(Patient p) {
        trans.begin();
        em.persist(p);
        em.flush();
        trans.commit();
        em.close();
    }

    @Override
    public void update(int id, Patient p) {
        trans.begin();
        p.setId(id);
        em.merge(p);
        em.flush();
        trans.commit();
        em.close();

    }

    @Override
    public void delete(int id) {
        trans.begin();
        Patient p = em.find(Patient.class, id);
        if (p != null) {
            em.remove(p);
        } else {
            System.out.println("Sorry the patient with the id  is not available");
        }
        trans.commit();
        em.close();
    }

    @Override
    public List<Patient> getAll() {
        Query q = em.createQuery("SELECT p FROM Patient p");
        patientList = q.getResultList();
        em.close();
        return patientList;
    }

    @Override
    public Patient getById(int id) {
        trans.begin();
        Patient p = em.find(Patient.class, id);
        trans.commit();
        em.close();
        return p;

    }

}
