package com.itechart.entity;

import javax.persistence.*;

/**
 * Created by Aleksandr on 12.04.2017.
 */
@Entity
@Table(name = "exam_result")
public class ExamResultEntity {
    private Integer id;
    private TecherEntity teacher;
    private StudentEntity student;
    private Byte result;
    private String note;
    private ExamEntity exam;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = false, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    public ExamEntity getExam() {
        return exam;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    public TecherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TecherEntity teacher) {
        this.teacher = teacher;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    @Column(name = "result", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
