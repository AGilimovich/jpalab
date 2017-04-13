package com.itechart.service;

import com.itechart.entity.*;

import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public interface AbstractDataService {

    void createNewStudent(StudentEntity studentEntity);

    void createNewCourse(TrainingCourseEntity trainingCourseEntity);

    void createNewExam(ExamEntity examEntity);

    void setExamResults(Set<ExamResultEntity> examResults);

    void setStudentResults(Set<StudentResultEntity> results);

    StudentEntity updateStudent(StudentEntity studentEntity);

    TrainingCourseEntity updateCourse(TrainingCourseEntity trainingCourseEntity);

    ExamEntity updateExam(ExamEntity examEntity);

    ExamResultEntity updateExamResult(ExamResultEntity examResult);

    StudentResultEntity updateStudentResult(StudentResultEntity result);

    void deleteStudent(StudentEntity studentEntity);

    void deleteCourse(TrainingCourseEntity trainingCourseEntity);

    void deleteExam(ExamEntity examEntity);

    void deleteExamResult(ExamResultEntity examResult);

    void deleteStudentResult(StudentResultEntity result);

    StudentEntity findStudentById(Integer id);

    TrainingCourseEntity findCourse(Integer id);

    ExamEntity findExam(Integer id);

    ExamResultEntity findExamResult(Integer id);

    StudentResultEntity findStudentResult(Integer id);


}
