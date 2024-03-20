/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semester;
import model.Student;
import model.StudentGroup;

/**
 *
 * @author Laptop K1
 */
public class StudentDao extends DBContext {

    public ArrayList<Student> getStudentByGroupID(int sgid) {
        ArrayList<Student> students = new ArrayList<>();
        connection = getConnection();
        String sql = "select s.sname,s.sgender,s.saddress,s.sphone,s.semail,sg.gname,se.sename from Student s \n"
                + "inner join Enrollment e\n"
                + "on  s.sid=e.sid\n"
                + "inner join StudentGroup sg\n"
                + "on s.gid=sg.gid\n"
                + "inner join Semester se\n"
                + "on s.seid=se.seid\n"
                + "where sg.gid= ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, sgid);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("sname"));
                student.setGender(resultSet.getString("sgender"));
                student.setAddress(resultSet.getString("saddress"));
                student.setPhone(resultSet.getInt("sphone"));
                student.setEmail(resultSet.getString("semail"));

                StudentGroup group = new StudentGroup();
                group.setName(resultSet.getString("gname"));
                student.setGroup(group);

                Semester semester = new Semester();
                semester.setName(resultSet.getString("sename"));
                student.setSemester(semester);

                students.add(student);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    public ArrayList<Student> listStudent(int lid) {
        ArrayList<Student> students = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT s.sid FROM Student s INNER JOIN Enrollment e ON s.[sid] = e.[sid]\n"
                + "                	INNER JOIN StudentGroup g ON g.gid = e.gid\n"
                + "                	INNER JOIN Lession les ON les.gid = g.gid\n"
                + "                WHERE les.leid = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, lid);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("sid"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return students;
    }

}
