package com.itechart.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "exam")
public class ExamEntity {
    private Integer id;
    private Timestamp date;
    private Set<ExamResultEntity> examResults;
    private TecherEntity teacher;
    private Set<StudentResultEntity> studentResults;
    private TrainingCourseEntity trainingCourse;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = false, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    public Set<StudentResultEntity> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(Set<StudentResultEntity> studentResults) {
        this.studentResults = studentResults;
    }

    @OneToOne
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


    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
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


}
