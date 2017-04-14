package com.itechart.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "student_result")
public class StudentResultEntity implements Serializable {
    private StudentEntity student;
    private TrainingCourseEntity trainingCourse;
    private Byte result;
    private Date date;
    private String note;
    private ExamEntity exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    public ExamEntity getExam() {
        return exam;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_course_id")
    public TrainingCourseEntity getTrainingCourse() {
        return trainingCourse;
    }

    public void setTrainingCourse(TrainingCourseEntity trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    @Column(name = "result", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    @Column(name = "date", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
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

        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (trainingCourse != null ? !trainingCourse.equals(that.trainingCourse) : that.trainingCourse != null)
            return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return note != null ? note.equals(that.note) : that.note == null;

    }

    @Override
    public int hashCode() {
        int result1 = student != null ? student.hashCode() : 0;
        result1 = 31 * result1 + (trainingCourse != null ? trainingCourse.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (date != null ? date.hashCode() : 0);
        result1 = 31 * result1 + (note != null ? note.hashCode() : 0);
        return result1;
    }
}
