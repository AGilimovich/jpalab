package com.itechart.dao;

import com.itechart.entity.StudentEntity;
import com.itechart.entity.StudentResultEntity;

import javax.persistence.EntityManager;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public class JpaStudentResultDao implements AbstractStudentResultDao {
    private EntityManager entityManager;

    public JpaStudentResultDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(StudentResultEntity studentResultEntity) {
        entityManager.persist(studentResultEntity);
    }

    @Override
    public StudentResultEntity readById(Integer id) {
        return entityManager.find(StudentResultEntity.class, id);
    }

    @Override
    public StudentResultEntity update(StudentResultEntity studentResultEntity) {
        return entityManager.merge(studentResultEntity);
    }

    @Override
    public void delete(StudentResultEntity studentResultEntity) {
        entityManager.remove(entityManager.contains(studentResultEntity) ? studentResultEntity : entityManager.merge(studentResultEntity));
    }
}
