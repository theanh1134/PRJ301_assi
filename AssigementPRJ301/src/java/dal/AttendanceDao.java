/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Lession;
import model.Student;
import model.StudentGroup;

/**
 *
 * @author Laptop K1
 */
public class AttendanceDao extends DBContext {

    public List<Attendance> getAttendanceForStudentID(int studentID) {
        List<Attendance> listAttendance = new ArrayList<>();
        try {
            connection = getConnection();
            String sql = "select s.sid,s.sname,s.semail,att.description,sg.gname,le.date from Attendance att\n"
                    + "inner join Student s\n"
                    + "on  att.sid=s.sid\n"
                    + "inner join Lession le on\n"
                    + "att.leid=le.leid\n"
                    + "inner join StudentGroup sg on\n"
                    + "sg.gid=le.gid\n"
                    + "where s.sid=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, studentID);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("sid"));
                student.setName(resultSet.getString("sname"));
                student.setEmail(resultSet.getString("semail"));

                Attendance attendance = new Attendance();
                attendance.setStudent(student);
                attendance.setDescription(resultSet.getString("description"));

                StudentGroup group = new StudentGroup();
                group.setName(resultSet.getString("gname"));

                Lession lession = new Lession();
                lession.setGroup(group);
                lession.setDate(resultSet.getDate("date"));

                attendance.setLession(lession);
                listAttendance.add(attendance);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAttendance;
    }

    public void updateTimetableByLession(int leid, ArrayList<Attendance> attendances) {

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            String sql_remove_atts = "DELETE Attendance WHERE leid = ?";
            PreparedStatement stm_remove_atts = connection.prepareStatement(sql_remove_atts);
            stm_remove_atts.setInt(1, leid);
            stm_remove_atts.executeUpdate();

            String sql_insert_atts = "INSERT INTO [Attendance] ([leid], [sid], [description], [isPresent])\n"
                    + "VALUES (? , ?, ? ,?);";
            for (Attendance attendance : attendances) {
                PreparedStatement stm_insert_att = connection.prepareStatement(sql_insert_atts);
                stm_insert_att.setInt(1, leid);
                stm_insert_att.setInt(2, attendance.getStudent().getId());
                stm_insert_att.setString(3, attendance.getDescription());
                stm_insert_att.setBoolean(4, attendance.isIsPresent());
                stm_insert_att.executeUpdate();
            }
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
