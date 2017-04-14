package com.itechart.dao;

import com.itechart.entity.TecherEntity;
import com.itechart.entity.TrainingCourseEntity;

import javax.persistence.EntityManager;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public class JpaTrainingCourseDao implements AbstractTrainingCourseDao {
    private EntityManager entityManager;

    public JpaTrainingCourseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(TrainingCourseEntity trainingCourseEntity) {
        entityManager.persist(trainingCourseEntity);
    }

    @Override
    public TrainingCourseEntity readById(Integer id) {
        return entityManager.find(TrainingCourseEntity.class, id);

    }

    @Override
    public TrainingCourseEntity update(TrainingCourseEntity trainingCourseEntity) {
        return entityManager.merge(trainingCourseEntity);

    }

    @Override
    public void delete(TrainingCourseEntity trainingCourseEntity) {
        entityManager.remove(entityManager.contains(trainingCourseEntity) ? trainingCourseEntity : entityManager.merge(trainingCourseEntity));
    }
}
