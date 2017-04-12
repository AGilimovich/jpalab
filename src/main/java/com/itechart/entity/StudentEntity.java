package com.itechart.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "student", schema = "students", catalog = "")
public class StudentEntity {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean sex;
    private Boolean hostelLive;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "sex")
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "hostel_live")
    public Boolean getHostelLive() {
        return hostelLive;
    }

    public void setHostelLive(Boolean hostelLive) {
        this.hostelLive = hostelLive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (sex != that.sex) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (hostelLive != null ? !hostelLive.equals(that.hostelLive) : that.hostelLive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (sex ? 1 : 0);
        result = 31 * result + (hostelLive != null ? hostelLive.hashCode() : 0);
        return result;
    }
}
