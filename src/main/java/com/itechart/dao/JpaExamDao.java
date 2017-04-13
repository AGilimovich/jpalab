package com.itechart.dao;

import com.itechart.entity.ExamEntity;

import javax.persistence.EntityManager;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public class JpaExamDao implements AbstractExamDao {
    private EntityManager entityManager;

    public JpaExamDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(ExamEntity examEntity) {
        entityManager.persist(examEntity);
    }

    @Override
    public ExamEntity readById(Integer id) {
        return entityManager.find(ExamEntity.class, id);
    }

    @Override
    public ExamEntity update(ExamEntity examEntity) {
        return entityManager.merge(examEntity);
    }

    @Override
    public void delete(ExamEntity examEntity) {
        entityManager.remove(examEntity);
    }
}
