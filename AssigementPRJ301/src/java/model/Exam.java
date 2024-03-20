/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Date;

/**
 *
 * @author Laptop K1
 */
public class Exam {
    private int id;
    private Subject subject;
    private Date date;
    private TypeGrade typegrade;
    private Room room;
    private TimeSlot slot;
    private Lecturer lecturer;

    public Exam() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeGrade getTypegrade() {
        return typegrade;
    }

    public void setTypegrade(TypeGrade typegrade) {
        this.typegrade = typegrade;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "Exam{" + "id=" + id + ", subject=" + subject + ", date=" + date + ", typegrade=" + typegrade + ", room=" + room + ", slot=" + slot + ", lecturer=" + lecturer + '}';
    }
    
    
}
