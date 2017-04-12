package com.itechart.dao;

import com.itechart.entity.StudentEntity;

/**
 * Created by Aleksandr on 12.04.2017.
 */

public interface AbstractStudentDao {

    StudentEntity create(StudentEntity studentEntity);

    StudentEntity readById(Long id);

    StudentEntity update(StudentEntity studentEntity);

    void delete(StudentEntity studentEntity);

}
