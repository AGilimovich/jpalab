package com.itechart.dao;

import com.itechart.entity.ExamResultEntity;

import javax.persistence.EntityManager;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public class JpaExamResultDao implements AbstractExamResultDao {
    private EntityManager entityManager;

    public JpaExamResultDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(ExamResultEntity examResultEntity) {
        entityManager.persist(examResultEntity);

    }

    @Override
    public ExamResultEntity readById(Integer id) {
        return entityManager.find(ExamResultEntity.class, id);

    }

    @Override
    public ExamResultEntity update(ExamResultEntity examResultEntity) {
        return entityManager.merge(examResultEntity);
    }

    @Override
    public void delete(ExamResultEntity examResultEntity) {
        entityManager.remove(examResultEntity);
    }
}
