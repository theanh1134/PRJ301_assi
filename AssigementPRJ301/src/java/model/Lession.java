/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

import java.util.Date;

/**
 *
 * @authisor Laptop K1
 */
public class Lession {
    private int id;
    private StudentGroup group;
    private Date date;
    private TimeSlot slot;
    private Room room;
    private Lecturer lecturer;
    private Subject subject;
    private boolean attended;
    private ArrayList<Attendance> atts=new ArrayList<>();
    
    public Lession() {
    }

    public Lession(int id, StudentGroup group, Date date, TimeSlot slot, Room room, Lecturer lecturer, Subject subject, boolean attended) {
        this.id = id;
        this.group = group;
        this.date = date;
        this.slot = slot;
        this.room = room;
        this.lecturer = lecturer;
        this.subject = subject;
        this.attended = attended;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public ArrayList<Attendance> getAtts() {
        return atts;
    }

    public void setAtts(ArrayList<Attendance> atts) {
        this.atts = atts;
    }

    @Override
    public String toString() {
        return "Lession{" + "id=" + id + ", group=" + group + ", date=" + date + ", slot=" + slot + ", room=" + room + ", lecturer=" + lecturer + ", subject=" + subject + ", attended=" + attended + ", atts=" + atts + '}';
    }
    

}