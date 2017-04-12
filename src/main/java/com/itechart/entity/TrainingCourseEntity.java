package com.itechart.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "training_course")
public class TrainingCourseEntity {
    private Integer id;
    private String name;
    private ExamEntity exam;
    private Set<StudentResultEntity> studentResults;
    private TecherEntity teacher;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = false, length = 50, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    public TecherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TecherEntity teacher) {
        this.teacher = teacher;
    }

    @OneToMany(mappedBy = "trainingCourse", cascade = CascadeType.ALL)
    public Set<StudentResultEntity> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(Set<StudentResultEntity> studentResults) {
        this.studentResults = studentResults;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "trainingCourse")
    public ExamEntity getExam() {
        return exam;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
    }

    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
