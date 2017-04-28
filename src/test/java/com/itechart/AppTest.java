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
import java.util.List;
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
        teacher.setFirstName("Vladimir");
        teacher.setLastName("Bondar");

        course = new TrainingCourseEntity();
        course.setName("Physics");
        course.setTeacher(teacher);

        exam = new ExamEntity();
        DateTime dt = formatter.parseDateTime("13-04-2017");
        exam.setDate(new Timestamp(dt.toDate().getTime()));
        exam.setTeacher(teacher);
        exam.setTrainingCourse(course);

        student = new StudentEntity();
        student.setFirstName("Sergey");
        student.setLastName("Nosov");
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
            dataService.addStudentResult(studentResult);
            dataService.addExamResult(examResult);
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
    public void testStudentFindById() {
        StudentEntity fetchedStudent = null;
        try {
            fetchedStudent = dataService.findStudentById(student.getId());
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Sergey", fetchedStudent.getFirstName());
        assertEquals("Nosov", fetchedStudent.getLastName());
    }

    @Test
    public void testTeacherFindById() {
        TecherEntity fetchedTeacher = null;
        try {
            fetchedTeacher = dataService.findTeacherById(teacher.getId());
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Vladimir", fetchedTeacher.getFirstName());
        assertEquals("Bondar", fetchedTeacher.getLastName());
    }

    @Test
    public void testTrainingCourseFindById() {
        TrainingCourseEntity fetchedTrainingCourse = null;
        try {
            fetchedTrainingCourse = dataService.findCourseById(course.getId());
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Physics", fetchedTrainingCourse.getName());
    }

    @Test
    public void testStudentResultFindForStudent() throws DataException {
        StudentResultEntity studentResult = null;
        List<StudentResultEntity> fetchedStudentResults = dataService.findStudentResultsForStudent(student);
        if (fetchedStudentResults != null) {
            studentResult = fetchedStudentResults.iterator().next();
        }
        assertEquals(Byte.valueOf((byte) 10), studentResult.getResult());
    }

    @Test
    public void testExamResultFindByExamId() {
        ExamResultEntity examResult = null;
        try {
            Set<ExamResultEntity> fetchedExamResults = dataService.findExamResultByExamId(exam.getId());
            if (fetchedExamResults != null) {
                examResult = fetchedExamResults.iterator().next();
            }
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals(Byte.valueOf((byte) 5), examResult.getResult());
    }


    @Test
    public void testStudentUpdate() {
        student.setFirstName("Alexey");
        student.setLastName("Soloviov");
        student.setBirthDate(student.getBirthDate());
        student.setSex(false);
        StudentEntity updatedStudent = null;
        try {
            updatedStudent = dataService.updateStudent(student);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Alexey", updatedStudent.getFirstName());
        assertEquals("Soloviov", updatedStudent.getLastName());
        assertEquals(false, updatedStudent.getSex());
    }

    @Test
    public void testTeacherUpdate() {
        teacher.setFirstName("Andrei");
        teacher.setLastName("Zhukov");

        TecherEntity updatedTeacher = null;
        try {
            updatedTeacher = dataService.updateTeacher(teacher);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Andrei", updatedTeacher.getFirstName());
        assertEquals("Zhukov", updatedTeacher.getLastName());
    }

    @Test
    public void testExamUpdate() {
        DateTime dt = formatter.parseDateTime("16-04-2017");
        exam.setDate(new Timestamp(dt.toDate().getTime()));

        ExamEntity updatedExam = null;
        try {
            updatedExam = dataService.updateExam(exam);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals(new Timestamp((dt.toDate().getTime())), updatedExam.getDate());
    }

    @Test
    public void testTrainingCourseUpdate() {
        course.setName("Chemistry");
        TrainingCourseEntity updatedCourse = null;
        try {
            updatedCourse = dataService.updateCourse(course);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals("Chemistry", updatedCourse.getName());
    }

    @Test
    public void testStudentResultUpdate() {
        studentResult.setResult((byte) 9);
        StudentResultEntity updatedStudentResult = null;
        try {
            updatedStudentResult = dataService.updateStudentResult(studentResult);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals(Byte.valueOf((byte) 9), updatedStudentResult.getResult());

    }

    @Test
    public void testExamResultUpdate() {
        examResult.setResult((byte) 4);
        ExamResultEntity updatedExamResult = null;
        try {
            updatedExamResult = dataService.updateExamResult(examResult);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals(Byte.valueOf((byte) 4), updatedExamResult.getResult());
    }

}
