package com.itechart;

import com.itechart.entity.*;
import com.itechart.service.AbstractDataService;
import com.itechart.service.DataException;
import com.itechart.service.DataService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Unit test.
 */
public class AppTest {
    private AbstractDataService dataService = new DataService();
    private TecherEntity teacher;
    private TrainingCourseEntity course;
    private ExamEntity exam;
    private StudentEntity student;
    private ExamResultEntity examResult;
    private StudentResultEntity studentResult;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");


    @Before
    public void init() {
        teacher = new TecherEntity();
        teacher.setFirstName("Ivan");
        teacher.setLastName("Ivanov");

        course = new TrainingCourseEntity();
        course.setName("Physics");
        course.setTeacher(teacher);

        exam = new ExamEntity();
        DateTime dt = formatter.parseDateTime("13-04-2017");
        exam.setDate(new Timestamp(dt.toDate().getTime()));
        exam.setTeacher(teacher);
        exam.setTrainingCourse(course);

        student = new StudentEntity();
        student.setFirstName("Александр");
        student.setLastName("Гилимович");
        dt = formatter.parseDateTime("12-11-1990");
        student.setBirthDate(new Date(dt.toDate().getTime()));
        student.setSex(true);
        student.setHostelLive(false);

        examResult = new ExamResultEntity();
        examResult.setTeacher(teacher);
        examResult.setStudent(student);
        examResult.setExam(exam);
        examResult.setResult((byte) 5);

        studentResult = new StudentResultEntity();
        studentResult.setStudent(student);
        studentResult.setResult((byte) 10);
        studentResult.setTrainingCourse(course);
        studentResult.setExam(exam);
        dt = formatter.parseDateTime("13-04-2017");
        studentResult.setDate(new Date(dt.toDate().getTime()));

        student.addExamResult(examResult);
        student.addStudentResult(studentResult);
        course.setExam(exam);
        try {
            dataService.createNewStudent(student);
            dataService.createNewTeacher(teacher);
            dataService.createNewCourse(course);
            Set<ExamResultEntity> examResults = new HashSet<>();
            examResults.add(examResult);
            dataService.setExamResults(examResults);
            Set<StudentResultEntity> studentResults = new HashSet<>();
            studentResults.add(studentResult);
            dataService.setStudentResults(studentResults);
        } catch (DataException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destroy() {
        try {
            dataService.deleteStudent(student);
            dataService.deleteCourse(course);
            dataService.deleteTeacher(teacher);
        } catch (DataException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStudentFetch() {
        StudentEntity fetchedStudent = null;
        try {
            fetchedStudent = dataService.findStudentById(student.getId());
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Александр", fetchedStudent.getFirstName());
        assertEquals("Гилимович", fetchedStudent.getLastName());
    }

    @Test
    public void testStudentUpdate() {
        student.setFirstName("Иван");
        student.setLastName("Иванов");
        student.setBirthDate(student.getBirthDate());
        student.setSex(false);
        StudentEntity updatedStudent = null;
        try {
            updatedStudent = dataService.updateStudent(student);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Иван", updatedStudent.getFirstName());
        assertEquals("Иванов", updatedStudent.getLastName());
        assertEquals(false, updatedStudent.getSex());
    }

}
