package com.itechart.dao;

import com.itechart.entity.StudentResultEntity;
import com.itechart.entity.TecherEntity;

import javax.persistence.EntityManager;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public class JpaTeacherDao implements AbstractTeacherDao {
    private EntityManager entityManager;

    public JpaTeacherDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(TecherEntity techerEntity) {
        entityManager.persist(techerEntity);
    }

    @Override
    public TecherEntity readById(Integer id) {
        return entityManager.find(TecherEntity.class, id);

    }

    @Override
    public TecherEntity update(TecherEntity techerEntity) {
        return entityManager.merge(techerEntity);

    }

    @Override
    public void delete(TecherEntity techerEntity) {
        entityManager.remove(entityManager.contains(techerEntity) ? techerEntity : entityManager.merge(techerEntity));


    }
}
