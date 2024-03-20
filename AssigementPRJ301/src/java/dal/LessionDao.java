/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Lecturer;
import model.Lession;
import model.Room;
import model.Student;
import model.StudentGroup;
import model.Subject;
import model.TimeSlot;
import java.sql.*;

/**
 *
 * @author Laptop K1
 */
public class LessionDao extends DBContext {

    public ArrayList<Lession> getLessionByIDSTudent(int sid, Date from, Date to) {
        ArrayList<Lession> list_Lession = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT \n"
                + "    l.date , \n"
                + "    r.rname , \n"
                + "    ts.tname , \n"
                + "    le.lname ,\n"
                + "    sub.subname ,\n"
                + "    gs.gname \n"
                + "FROM \n"
                + "    Lession l\n"
                + "INNER JOIN \n"
                + "    Room r ON l.rid = r.rid\n"
                + "INNER JOIN \n"
                + "    TimeSlot ts ON l.tid = ts.tid\n"
                + "INNER JOIN \n"
                + "    Lecturer le ON l.leid = le.lid\n"
                + "INNER JOIN \n"
                + "    Enrollment e ON l.gid = e.gid\n"
                + "INNER JOIN \n"
                + "    Student s ON e.sid = s.sid\n"
                + "INNER JOIN\n"
                + "    StudentGroup gs ON e.gid = gs.gid\n"
                + "INNER JOIN\n"
                + "    Subject sub ON gs.subid = sub.subid\n"
                + "WHERE \n"
                + "    s.sid = ? \n"
                + "    AND l.date >= ? \n"
                + "    AND l.date <= ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            statement.setDate(2, (java.sql.Date) from);
            statement.setDate(3, (java.sql.Date) to);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lession lession = new Lession();
                lession.setDate(resultSet.getDate("date"));

                Room room = new Room();
                room.setName(resultSet.getString("rname"));
                lession.setRoom(room);

                TimeSlot slot = new TimeSlot();
                slot.setName(resultSet.getString("tname"));
                lession.setSlot(slot);

                Lecturer lecturer = new Lecturer();
                lecturer.setName(resultSet.getString("lname"));
                lession.setLecturer(lecturer);

                Subject subject = new Subject();
                subject.setName(resultSet.getString("subname"));
                lession.setSubject(subject);

                StudentGroup group = new StudentGroup();
                group.setName(resultSet.getString("gname"));
                lession.setGroup(group);
                list_Lession.add(lession);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LessionDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list_Lession;
    }

    public ArrayList<Attendance> getAttendanceBy(int leid) {
        ArrayList<Attendance> atts = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT \n"
                + "    les.leid, s.sid, s.sname,\n"
                + "    a.attid, a.description, a.isPresent\n"
                + "FROM \n"
                + "    Student s \n"
                + "INNER JOIN Enrollment e ON s.sid = e.sid\n"
                + "INNER JOIN StudentGroup g ON g.gid = e.gid \n"
                + "INNER JOIN Lession les ON les.gid = g.gid\n"
                + "LEFT JOIN Attendance a ON a.leid = les.leid AND s.sid = a.sid\n"
                + "WHERE \n"
                + "    les.leid = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, leid);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Attendance attendance = new Attendance();

                Lession lession = new Lession();
                lession.setId(resultSet.getInt("leid"));
                attendance.setLession(lession);

                Student student = new Student();
                student.setId(resultSet.getInt("sid"));
                student.setName(resultSet.getString("sname"));
                attendance.setStudent(student);

                attendance.setId(resultSet.getInt("attid"));
                if (attendance.getId() != 0) {
                    attendance.setDescription(resultSet.getString("description"));
                    attendance.setIsPresent(resultSet.getBoolean("isPresent"));
                }

                atts.add(attendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public ArrayList<Lession> getBy(int lid, Date from, Date to) {
        ArrayList<Lession> lessions = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT  \n"
                + "    les.leid, les.isAttended, les.date,\n"
                + "    g.gid, g.gname, su.subid, su.subname,\n"
                + "    t.tid, t.tname,t.tfrom,t.tto,\n"
                + "    r.rid, r.rname,\n"
                + "    l.lid, l.lname\n"
                + "FROM Lession les \n"
                + "INNER JOIN StudentGroup g ON g.gid = les.gid\n"
                + "INNER JOIN [Subject] su ON su.subid = g.subid\n"
                + "INNER JOIN TimeSlot t ON t.tid = les.tid\n"
                + "INNER JOIN Room r ON r.rid = les.rid\n"
                + "INNER JOIN Lecturer l ON l.lid = les.lid\n"
                + "WHERE les.lid = ? AND les.date >= ? AND les.date <= ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, lid);
            statement.setObject(2, from);
            statement.setObject(3, to);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lession lession = new Lession();
                lession.setId(resultSet.getInt("leid"));
                lession.setAttended(resultSet.getBoolean("isAttended"));
                lession.setDate(resultSet.getDate("date"));

                StudentGroup group = new StudentGroup();
                group.setId(resultSet.getInt("gid"));
                group.setName(resultSet.getString("gname"));
                lession.setGroup(group);

                Subject subject = new Subject();
                subject.setId(resultSet.getInt("subid"));
                subject.setName(resultSet.getString("subname"));
                lession.setSubject(subject);

                TimeSlot slot = new TimeSlot();
                slot.setId(resultSet.getInt("tid"));
                slot.setName(resultSet.getString("tname"));
                slot.setTimeFrom(resultSet.getTime("tfrom").toLocalTime());
                slot.setTimeTo(resultSet.getTime("tto").toLocalTime());
                lession.setSlot(slot);

                Room room = new Room();
                room.setId(resultSet.getInt("rid"));
                room.setName(resultSet.getString("rname"));
                lession.setRoom(room);

                Lecturer lecturer = new Lecturer();
                lecturer.setId(resultSet.getInt("lid"));
                lecturer.setName(resultSet.getString("lname"));
                lession.setLecturer(lecturer);
                lessions.add(lession);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessions;
    }
  
        }
        
    
 

