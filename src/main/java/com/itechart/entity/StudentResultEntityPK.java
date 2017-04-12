package com.itechart.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Aleksandr on 12.04.2017.
 */
public class StudentResultEntityPK implements Serializable {
    private int studentId;
    private int trainingCourseId;

    @Column(name = "student_id")
    @Id
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Column(name = "training_course_id")
    @Id
    public int getTrainingCourseId() {
        return trainingCourseId;
    }

    public void setTrainingCourseId(int trainingCourseId) {
        this.trainingCourseId = trainingCourseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentResultEntityPK that = (StudentResultEntityPK) o;

        if (studentId != that.studentId) return false;
        if (trainingCourseId != that.trainingCourseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + trainingCourseId;
        return result;
    }
}
