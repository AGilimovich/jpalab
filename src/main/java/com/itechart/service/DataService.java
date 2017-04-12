package com.itechart.service;

import com.itechart.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public class DataService implements AbstractDataService {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("jpaLab").createEntityManager();


    @Override
    public StudentEntity saveStudent(StudentEntity studentEntity) {
        StudentEntity savedStudent = null;
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        savedStudent = entityManager.merge(studentEntity);
        tx.commit();
        return savedStudent;
    }

    @Override
    public StudentEntity fetchStudentById(Integer id) {
        return entityManager.find(StudentEntity.class, id);
    }

    @Override
    public void deleteStudent(StudentEntity studentEntity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(studentEntity);
        tx.commit();
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity) {
        StudentEntity updatedStudent = null;
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        updatedStudent = entityManager.merge(studentEntity);
        tx.commit();
        return updatedStudent;
    }


}
