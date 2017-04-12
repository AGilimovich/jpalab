package com.itechart.entity;

import javax.persistence.*;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "exam_result", schema = "students", catalog = "")
public class ExamResultEntity {
    private int id;
    private byte result;
    private String note;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        ExamResultEntity that = (ExamResultEntity) o;

        if (id != that.id) return false;
        if (result != that.result) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (int) result;
        result1 = 31 * result1 + (note != null ? note.hashCode() : 0);
        return result1;
    }
}
