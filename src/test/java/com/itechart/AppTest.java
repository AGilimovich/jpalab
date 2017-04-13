package com.itechart;

import com.itechart.entity.*;
import com.itechart.service.AbstractDataService;
import com.itechart.service.DataService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        teacher.setFirstName("sd");
        teacher.setLastName("ll1");

        course = new TrainingCourseEntity();
        course.setName("Physics");
        course.setTeacher(teacher);

        exam = new ExamEntity();
        DateTime dt = formatter.parseDateTime("13-04-2017");
        exam.setDate(new Timestamp(dt.toDate().getTime()));
        exam.setTeacher(teacher);
        exam.setTrainingCourse(course);

        student = new StudentEntity();
        student.setFirstName("Александр2");
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
        examResult.setNote("note");

        studentResult = new StudentResultEntity();
        studentResult.setStudent(student);
        studentResult.setResult((byte) 10);
        studentResult.setTrainingCourse(course);
        studentResult.setExam(exam);
        dt = formatter.parseDateTime("13-04-2017");
        studentResult.setDate(new Date(dt.toDate().getTime()));
        studentResult.setNote("note");

        dataService.createNewStudent(student);
        dataService.createNewCourse(course);
        dataService.createNewExam(exam);
        Set<ExamResultEntity> examResults = new HashSet<>();
        examResults.add(examResult);
        dataService.setExamResults(examResults);
        Set<StudentResultEntity> studentResults = new HashSet<>();
        studentResults.add(studentResult);
        dataService.setStudentResults(studentResults);
    }

    @Test
    public void testUpdate() {
        student.setFirstName("Иван");
        student.setLastName("Иванов");
        dataService.updateStudent(student);
        assertEquals("Иван", student.getFirstName());
        assertEquals("Иванов", student.getLastName());
    }

    @Test
    public void testFetch() {
        StudentEntity fetchedStudent = dataService.findStudentById(student.getId());
        assertEquals("Иванов", fetchedStudent.getLastName());
        assertEquals("Иван", fetchedStudent.getLastName());
    }
//
//    @Test
//    public void testDelete() {
//        dataService.deleteStudent(student);
//        dataService.deleteCourse(course);
//        dataService.deleteExamResult(examResult);
//        dataService.deleteExam(exam);
//        dataService.deleteStudentResult(studentResult);
//        StudentEntity fetchedStudent = dataService.findStudentById(student.getId());
//        assertNull(fetchedStudent);
//    }


}
