package com.itechart.dao;

import com.itechart.entity.TrainingCourseEntity;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public interface AbstractTrainingCourseDao {
    void create(TrainingCourseEntity trainingCourseEntity);

    TrainingCourseEntity readById(Integer id);

    TrainingCourseEntity update(TrainingCourseEntity trainingCourseEntity);

    void delete(TrainingCourseEntity trainingCourseEntity);
}
