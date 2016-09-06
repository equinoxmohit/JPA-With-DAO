/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.persistance.DAO;

import com.mohit.persistance.entity.Patient;
import java.util.List;

/**
 *
 * @author Mohit
 */
public interface PatientDAO {

    void insert(Patient p);

    void update(int id, Patient p);

    void delete(int id);

    List<Patient> getAll();

    Patient getById(int id);

}
