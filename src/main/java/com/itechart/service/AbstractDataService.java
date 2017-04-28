package com.itechart.service;

import com.itechart.entity.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public interface AbstractDataService {

    void createNewStudent(StudentEntity studentEntity) throws DataException;

    void createNewCourse(TrainingCourseEntity trainingCourseEntity) throws DataException;

    void createNewExam(ExamEntity examEntity) throws DataException;

    void createNewTeacher(TecherEntity teacherEntity) throws DataException;

    void setExamResults(Set<ExamResultEntity> examResults) throws DataException;

    void addExamResult(ExamResultEntity examResult) throws DataException;

    void addStudentResult(StudentResultEntity result) throws DataException;

    void setStudentResults(Set<StudentResultEntity> results) throws DataException;

    StudentEntity updateStudent(StudentEntity studentEntity) throws DataException;

    TrainingCourseEntity updateCourse(TrainingCourseEntity trainingCourseEntity) throws DataException;

    ExamEntity updateExam(ExamEntity examEntity) throws DataException;

    ExamResultEntity updateExamResult(ExamResultEntity examResult) throws DataException;

    StudentResultEntity updateStudentResult(StudentResultEntity result) throws DataException;

    TecherEntity updateTeacher(TecherEntity techerEntity) throws DataException;

    void deleteStudent(StudentEntity studentEntity) throws DataException;

    void deleteCourse(TrainingCourseEntity trainingCourseEntity) throws DataException;

    void deleteExam(ExamEntity examEntity) throws DataException;

    void deleteExamResult(ExamResultEntity examResult) throws DataException;

    void deleteStudentResult(StudentResultEntity result) throws DataException;

    void deleteTeacher(TecherEntity teacher) throws DataException;

    StudentEntity findStudentById(Integer id) throws DataException;

    TrainingCourseEntity findCourseById(Integer id) throws DataException;

    ExamEntity findExamById(Integer id) throws DataException;

    Set<ExamResultEntity> findExamResultByExamId(Integer id) throws DataException;

    List<StudentResultEntity> findStudentResultsForStudent(StudentEntity studentEntity) throws DataException;

    TecherEntity findTeacherById(Integer id) throws DataException;


}
