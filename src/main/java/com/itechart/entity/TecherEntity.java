package com.itechart.entity;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<ExamResultEntity> examResults = new HashSet<>();
    private Set<ExamEntity> exams = new HashSet<>();
    private Set<TrainingCourseEntity> trainingCourses = new HashSet<>();

    public void addExamResult (ExamResultEntity examResultEntity) {
        examResults.add(examResultEntity);
    }
    public void addExam(ExamEntity examEntity) {
        exams.add(examEntity);
    }

    public void addTrainingCourses(TrainingCourseEntity trainingCourseEntity) {
        trainingCourses.add(trainingCourseEntity);
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

    @OneToMany(mappedBy = "teacher")
    public Set<TrainingCourseEntity> getTrainingCourses() {
        return trainingCourses;
    }

    public void setTrainingCourses(Set<TrainingCourseEntity> trainingCourses) {
        this.trainingCourses = trainingCourses;
    }

    @OneToMany(mappedBy = "teacher")
    public Set<ExamEntity> getExams() {
        return exams;
    }

    public void setExams(Set<ExamEntity> exams) {
        this.exams = exams;
    }

    @OneToMany(mappedBy = "teacher")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TecherEntity that = (TecherEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
