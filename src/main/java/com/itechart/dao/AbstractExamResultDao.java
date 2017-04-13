package com.itechart.dao;

import com.itechart.entity.ExamResultEntity;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public interface AbstractExamResultDao {
    void create(ExamResultEntity examResultEntity);

    ExamResultEntity readById(Integer id);

    ExamResultEntity update(ExamResultEntity examResultEntity);

    void delete(ExamResultEntity examResultEntity);
}
