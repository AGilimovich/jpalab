package com.itechart;

import com.itechart.dao.DbDao;
import com.itechart.entity.StudentEntity;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Date;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    private DbDao dao = new DbDao();

    public void testApp() {
        StudentEntity student = new StudentEntity();
        student.setFirstName("Александр");
        student.setLastName("Гилимович");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
        DateTime dt = formatter.parseDateTime("12-11-1990");
        student.setBirthDate(new Date(dt.toDate().getTime()));
        student.setSex(true);
        StudentEntity studentFromDb = dao.add(student);
        assertEquals("Александр", studentFromDb.getFirstName());
        assertEquals("Гилимович", studentFromDb.getLastName());

    }
}
