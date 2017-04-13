package com.itechart.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "student")
public class StudentEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Boolean sex;
    private Boolean hostelLive;
    private Set<ExamResultEntity> examResults;
    private Set<StudentResultEntity> studentResults;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = false, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    public Set<StudentResultEntity> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(Set<StudentResultEntity> studentResults) {
        this.studentResults = studentResults;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
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

    @Column(name = "birth_date", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "sex", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Column(name = "hostel_live", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    public Boolean getHostelLive() {
        return hostelLive;
    }

    public void setHostelLive(Boolean hostelLive) {
        this.hostelLive = hostelLive;
    }


}
