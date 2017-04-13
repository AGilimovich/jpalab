package com.itechart.dao;

import com.itechart.entity.StudentResultEntity;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public interface AbstractStudentResultDao {
    void create(StudentResultEntity studentResultEntity);

    StudentResultEntity readById(Integer id);

    StudentResultEntity update(StudentResultEntity studentResultEntity);

    void delete(StudentResultEntity studentResultEntity);
}
