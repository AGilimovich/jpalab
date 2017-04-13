package com.itechart.service;

import com.itechart.dao.*;
import com.itechart.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public class DataService implements AbstractDataService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaLab");


    @Override
    public void createNewStudent(StudentEntity studentEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        studentDao.create(studentEntity);
        tx.commit();
    }

    @Override
    public void createNewCourse(TrainingCourseEntity trainingCourseEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        teacherDao.create(trainingCourseEntity.getTeacher());
        trainingCourseDao.create(trainingCourseEntity);
        tx.commit();
    }

    @Override
    public void createNewExam(ExamEntity examEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        examDao.create(examEntity);
        tx.commit();

    }


    @Override
    public void setExamResults(Set<ExamResultEntity> examResults) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        for (ExamResultEntity examResult : examResults) {
            examResultDao.create(examResult);
        }
        tx.commit();

    }

    @Override
    public void setStudentResults(Set<StudentResultEntity> results) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        for (StudentResultEntity result : results) {
            studentResultDao.create(result);
        }
        tx.commit();
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        StudentEntity st = studentDao.update(studentEntity);
        tx.commit();
        return st;
    }

    @Override
    public TrainingCourseEntity updateCourse(TrainingCourseEntity trainingCourseEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        teacherDao.update(trainingCourseEntity.getTeacher());
        TrainingCourseEntity tc = trainingCourseDao.update(trainingCourseEntity);
        tx.commit();
        return tc;
    }

    @Override
    public ExamEntity updateExam(ExamEntity examEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        ExamEntity exam = examDao.update(examEntity);
        tx.commit();
        return exam;
    }

    @Override
    public ExamResultEntity updateExamResult(ExamResultEntity examResult) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        ExamResultEntity er = examResultDao.update(examResult);
        tx.commit();
        return er;
    }

    @Override
    public StudentResultEntity updateStudentResult(StudentResultEntity result) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        StudentResultEntity sr = studentResultDao.update(result);
        tx.commit();
        return sr;
    }

    @Override
    public void deleteStudent(StudentEntity studentEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        studentDao.delete(studentEntity);
        tx.commit();
    }

    @Override
    public void deleteCourse(TrainingCourseEntity trainingCourseEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // TODO: 13.04.2017 on delete cascade??
        teacherDao.delete(trainingCourseEntity.getTeacher());
        trainingCourseDao.delete(trainingCourseEntity);
        tx.commit();
    }

    @Override
    public void deleteExam(ExamEntity examEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        examDao.delete(examEntity);
        tx.commit();
    }

    @Override
    public void deleteExamResult(ExamResultEntity examResult) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        examResultDao.delete(examResult);
        tx.commit();
    }

    @Override
    public void deleteStudentResult(StudentResultEntity result) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        studentResultDao.delete(result);
        tx.commit();
    }

    @Override
    public StudentEntity findStudentById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        StudentEntity st = studentDao.readById(id);
        tx.commit();
        return st;
    }

    @Override
    public TrainingCourseEntity findCourse(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        TrainingCourseEntity tc = trainingCourseDao.readById(id);
        tx.commit();
        return tc;
    }

    @Override
    public ExamEntity findExam(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        ExamEntity exam = examDao.readById(id);
        tx.commit();
        return exam;
    }

    @Override
    public ExamResultEntity findExamResult(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        ExamResultEntity er = examResultDao.readById(id);
        tx.commit();
        return er;
    }

    @Override
    public StudentResultEntity findStudentResult(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        StudentResultEntity sr = studentResultDao.readById(id);
        tx.commit();
        return sr;
    }


}
