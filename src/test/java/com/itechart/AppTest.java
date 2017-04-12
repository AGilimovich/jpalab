package com.itechart;

import com.itechart.entity.StudentEntity;
import com.itechart.service.AbstractDataService;
import com.itechart.service.DataService;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Date;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    private AbstractDataService dataService = new DataService();


    public void testStudentSaving() {
        StudentEntity student = new StudentEntity();
        student.setFirstName("Александр");
        student.setLastName("Гилимович");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
        DateTime dt = formatter.parseDateTime("12-11-1990");
        student.setBirthDate(new Date(dt.toDate().getTime()));
        student.setSex(true);

        StudentEntity savedStudent = dataService.saveStudent(student);
        StudentEntity fetchedStudent = dataService.fetchStudentById(savedStudent.getId());

        assertEquals("Александр", fetchedStudent.getFirstName());
        assertEquals("Гилимович", fetchedStudent.getLastName());
        assertEquals(formatter.parseDateTime("12-11-1990"), new DateTime(fetchedStudent.getBirthDate()));
    }

    public void testStudentDeleting() {
        StudentEntity student = new StudentEntity();
        student.setFirstName("Александр");
        student.setLastName("Гилимович");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
        DateTime dt = formatter.parseDateTime("12-11-1990");
        student.setBirthDate(new Date(dt.toDate().getTime()));
        student.setSex(true);
        StudentEntity savedStudent = dataService.saveStudent(student);
        dataService.deleteStudent(savedStudent);
        StudentEntity removedStudent = dataService.fetchStudentById(savedStudent.getId());
        assertNull(removedStudent);
    }


}
