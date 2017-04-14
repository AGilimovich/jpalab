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
    public void create(StudentEntity studentEntity) {
        entityManager.persist(studentEntity);
    }

    @Override
    public StudentEntity readById(Integer id) {
        return entityManager.find(StudentEntity.class, id);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        return entityManager.merge(studentEntity);
    }

    @Override
    public void delete(StudentEntity studentEntity) {
        entityManager.remove(entityManager.contains(studentEntity) ? studentEntity : entityManager.merge(studentEntity));
      //  entityManager.remove(studentEntity);
    }

}
