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
    public void createNewStudent(StudentEntity studentEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            studentDao.create(studentEntity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void createNewCourse(TrainingCourseEntity trainingCourseEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            trainingCourseDao.create(trainingCourseEntity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void createNewExam(ExamEntity examEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            examDao.create(examEntity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }

    }

    @Override
    public void createNewTeacher(TecherEntity teacherEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            teacherDao.create(teacherEntity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }


    @Override
    public void setExamResults(Set<ExamResultEntity> examResults) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            for (ExamResultEntity examResult : examResults) {
                examResultDao.create(examResult);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }

    }

    @Override
    public void setStudentResults(Set<StudentResultEntity> results) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            for (StudentResultEntity result : results) {
                studentResultDao.create(result);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            StudentEntity st = studentDao.update(studentEntity);
            tx.commit();
            return st;
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public TrainingCourseEntity updateCourse(TrainingCourseEntity trainingCourseEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            teacherDao.update(trainingCourseEntity.getTeacher());
            TrainingCourseEntity tc = trainingCourseDao.update(trainingCourseEntity);
            tx.commit();
            return tc;
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public ExamEntity updateExam(ExamEntity examEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            ExamEntity exam = examDao.update(examEntity);
            tx.commit();
            return exam;
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public ExamResultEntity updateExamResult(ExamResultEntity examResult) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            ExamResultEntity er = examResultDao.update(examResult);
            tx.commit();
            return er;
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public StudentResultEntity updateStudentResult(StudentResultEntity result) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            StudentResultEntity sr = studentResultDao.update(result);
            tx.commit();
            return sr;
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public TecherEntity updateTeacher(TecherEntity techerEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            TecherEntity t = teacherDao.update(techerEntity);
            tx.commit();
            return t;
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void deleteStudent(StudentEntity studentEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            studentDao.delete(studentEntity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void deleteCourse(TrainingCourseEntity trainingCourseEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            trainingCourseDao.delete(trainingCourseEntity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void deleteExam(ExamEntity examEntity) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            examDao.delete(examEntity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void deleteExamResult(ExamResultEntity examResult) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            examResultDao.delete(examResult);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void deleteStudentResult(StudentResultEntity result) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            studentResultDao.delete(result);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void deleteTeacher(TecherEntity teacher) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            teacherDao.delete(teacher);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public StudentEntity findStudentById(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentDao studentDao = new JpaStudentDao(entityManager);
        try {
            StudentEntity st = studentDao.readById(id);
            return st;
        } catch (Exception e) {
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public TrainingCourseEntity findCourseById(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTrainingCourseDao trainingCourseDao = new JpaTrainingCourseDao(entityManager);
        try {
            TrainingCourseEntity tc = trainingCourseDao.readById(id);
            return tc;
        } catch (Exception e) {
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public ExamEntity findExamById(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamDao examDao = new JpaExamDao(entityManager);
        try {
            ExamEntity exam = examDao.readById(id);
            return exam;
        } catch (Exception e) {
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public ExamResultEntity findExamResultById(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractExamResultDao examResultDao = new JpaExamResultDao(entityManager);
        try {
            ExamResultEntity er = examResultDao.readById(id);
            return er;
        } catch (Exception e) {
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public StudentResultEntity findStudentResultById(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractStudentResultDao studentResultDao = new JpaStudentResultDao(entityManager);
        try {
            StudentResultEntity sr = studentResultDao.readById(id);
            return sr;
        } catch (Exception e) {
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public TecherEntity findTeacherById(Integer id) throws DataException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AbstractTeacherDao teacherDao = new JpaTeacherDao(entityManager);
        try {
            TecherEntity t = teacherDao.readById(id);
            return t;
        } catch (Exception e) {
            throw new DataException(e);
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }


}
