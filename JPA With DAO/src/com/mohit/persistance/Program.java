/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.persistance;

import com.mohit.persistance.DAO.PatientDAO;
import com.mohit.persistance.DAO.impl.PatientDAOImpl;
import com.mohit.persistance.entity.Patient;

/**
 *
 * @author Mohit
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        Patient p = new Patient();
        PatientDAO pDao = new PatientDAOImpl();

        //Insert
        p.setId(0);
        p.setFirstName("Ram");
        p.setLastName("Lakhan");
        p.setEmailId("ram.lakhan@gmail.com");
        p.setContactNumber("9860253621");
        p.setStatus(true);
        pDao.insert(p);

        //Insert
        p.setId(0);
        p.setFirstName("Hari");
        p.setLastName("Lakhan");
        p.setEmailId("hari.lakhan@gmail.com");
        p.setContactNumber("986025221");
        p.setStatus(false);
        pDao = new PatientDAOImpl();
        pDao.insert(p);

        //Update
        p.setFirstName("Makhan");
        p.setLastName("Ravi");
        p.setEmailId("hari.lakhan@gmail.com");
        p.setContactNumber("986025221");
        p.setStatus(false);
        pDao = new PatientDAOImpl();
        pDao.update(2, p);

        //Delete
        pDao.delete(2);

        
        //GetAll
        pDao = new PatientDAOImpl();
        for (Patient ps : pDao.getAll()) {
            System.out.println(p.toString());
        }

        //GetById
        pDao = new PatientDAOImpl();
        p = pDao.getById(1);
        System.out.println(p.toString());
    }

}
