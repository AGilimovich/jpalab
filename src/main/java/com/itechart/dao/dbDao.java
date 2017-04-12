package com.itechart.dao;

import com.itechart.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public class DbDao {
    public EntityManager entityManager = Persistence.createEntityManagerFactory("jpaLab").createEntityManager();

    public StudentEntity add(StudentEntity studentEntity){
        entityManager.getTransaction().begin();
        StudentEntity student = entityManager.merge(studentEntity);
        entityManager.getTransaction().commit();
        return student;
    }

}
