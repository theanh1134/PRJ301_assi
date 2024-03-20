/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author Laptop K1
 */
public class TimeSlot {
    private int id;
    private String name;
    private LocalTime timeFrom;
    private LocalTime timeTo;

    public TimeSlot() {
    }

    public TimeSlot(int id, String name, LocalTime timeFrom, LocalTime timeTo) {
        this.id = id;
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    @Override
    public String toString() {
        return "TimeSlot{" + "id=" + id + ", name=" + name + ", timeFrom=" + timeFrom + ", timeTo=" + timeTo + '}';
    }
   
}
