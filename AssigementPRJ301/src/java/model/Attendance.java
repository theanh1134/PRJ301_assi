/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Laptop K1
 */
public class Attendance {
    private int id;
    private Lession lession;
    private String description;
    private boolean isPresent;
    private Student student;
    public Attendance() {
    }

    public Attendance(int id, Lession lession, String description, boolean isPresent, Student student) {
        this.id = id;
        this.lession = lession;
        this.description = description;
        this.isPresent = isPresent;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lession getLession() {
        return lession;
    }

    public void setLession(Lession lession) {
        this.lession = lession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Attendance{" + "id=" + id + ", lession=" + lession + ", description=" + description + ", isPresent=" + isPresent + ", student=" + student + '}';
    }
    
    

   
            
}
