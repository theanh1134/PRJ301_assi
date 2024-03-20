/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Laptop K1
 */
public class Grade {
    private int id;
    private Student student;
    private StudentGroup group;
    private TypeGrade typegrade;
    private int gradevalue;

    public Grade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public TypeGrade getTypegrade() {
        return typegrade;
    }

    public void setTypegrade(TypeGrade typegrade) {
        this.typegrade = typegrade;
    }

    public int getGradevalue() {
        return gradevalue;
    }

    public void setGradevalue(int gradevalue) {
        this.gradevalue = gradevalue;
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", student=" + student + ", group=" + group + ", typegrade=" + typegrade + ", gradevalue=" + gradevalue + '}';
    }
    
}
