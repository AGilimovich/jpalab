package com.itechart.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "techer")
public class TecherEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private Set<ExamResultEntity> examResults;
    private Set<ExamEntity> exams;
    private Set<TrainingCourseEntity> trainingCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = false, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    public Set<TrainingCourseEntity> getTrainingCourses() {
        return trainingCourses;
    }

    public void setTrainingCourses(Set<TrainingCourseEntity> trainingCourses) {
        this.trainingCourses = trainingCourses;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    public Set<ExamEntity> getExams() {
        return exams;
    }

    public void setExams(Set<ExamEntity> exams) {
        this.exams = exams;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    public Set<ExamResultEntity> getExamResults() {
        return examResults;
    }

    public void setExamResults(Set<ExamResultEntity> examResults) {
        this.examResults = examResults;
    }

    @Column(name = "first_name", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
