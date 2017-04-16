package com.itechart.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "exam")
public class ExamEntity {
    private Integer id;
    private Timestamp date;
    private Set<ExamResultEntity> examResults = new HashSet<>();
    private TecherEntity teacher;
    private Set<StudentResultEntity> studentResults = new HashSet<>();
    private TrainingCourseEntity trainingCourse;

    public void addExamResult(ExamResultEntity examResultEntity) {
        examResults.add(examResultEntity);
    }
    public void addStudentResult (StudentResultEntity studentResultEntity) {
        studentResults.add(studentResultEntity);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = false, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    public Set<StudentResultEntity> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(Set<StudentResultEntity> studentResults) {
        this.studentResults = studentResults;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_course_id")
    public TrainingCourseEntity getTrainingCourse() {
        return trainingCourse;
    }

    public void setTrainingCourse(TrainingCourseEntity trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    public TecherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TecherEntity teacher) {
        this.teacher = teacher;
    }


    @OneToMany(mappedBy = "exam", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public Set<ExamResultEntity> getExamResults() {
        return examResults;
    }

    public void setExamResults(Set<ExamResultEntity> examResults) {
        this.examResults = examResults;
    }

    @Column(name = "date", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamEntity that = (ExamEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
