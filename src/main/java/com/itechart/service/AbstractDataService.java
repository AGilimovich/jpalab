package com.itechart.service;

import com.itechart.entity.StudentEntity;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public interface AbstractDataService {
    StudentEntity saveStudent(StudentEntity studentEntity);

    StudentEntity fetchStudentById(Integer id);

    void deleteStudent(StudentEntity studentEntity);

    StudentEntity updateStudent(StudentEntity studentEntity);



}
