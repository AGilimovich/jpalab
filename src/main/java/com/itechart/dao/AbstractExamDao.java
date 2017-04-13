package com.itechart.dao;

import com.itechart.entity.ExamEntity;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public interface AbstractExamDao {
    void create(ExamEntity examEntity);

    ExamEntity readById(Integer id);

    ExamEntity update(ExamEntity examEntity);

    void delete(ExamEntity examEntity);
}
