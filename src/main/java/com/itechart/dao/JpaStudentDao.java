package com.itechart.dao;

import com.itechart.entity.StudentEntity;

import javax.persistence.EntityManager;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public class JpaStudentDao implements AbstractStudentDao {
    private EntityManager entityManager;

    public JpaStudentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public StudentEntity create(StudentEntity studentEntity) {
        StudentEntity student = entityManager.merge(studentEntity);
        return student;
    }

    @Override
    public StudentEntity readById(Long id) {
        return null;
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        return null;
    }

    @Override
    public void delete(StudentEntity studentEntity) {

    }

}
