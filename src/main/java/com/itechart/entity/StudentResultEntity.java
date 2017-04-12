package com.itechart.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "student_result", schema = "students", catalog = "")
@IdClass(StudentResultEntityPK.class)
public class StudentResultEntity {
    private int studentId;
    private int trainingCourseId;
    private byte result;
    private Date date;
    private String note;

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "training_course_id")
    public int getTrainingCourseId() {
        return trainingCourseId;
    }

    public void setTrainingCourseId(int trainingCourseId) {
        this.trainingCourseId = trainingCourseId;
    }

    @Basic
    @Column(name = "result")
    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentResultEntity that = (StudentResultEntity) o;

        if (studentId != that.studentId) return false;
        if (trainingCourseId != that.trainingCourseId) return false;
        if (result != that.result) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = studentId;
        result1 = 31 * result1 + trainingCourseId;
        result1 = 31 * result1 + (int) result;
        result1 = 31 * result1 + (date != null ? date.hashCode() : 0);
        result1 = 31 * result1 + (note != null ? note.hashCode() : 0);
        return result1;
    }
}
