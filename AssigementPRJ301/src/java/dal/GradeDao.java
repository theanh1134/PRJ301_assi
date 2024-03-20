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
import model.Exam;
import model.Grade;
import model.Lecturer;
import model.Room;
import model.Student;
import model.StudentGroup;
import model.Subject;
import model.TimeSlot;
import model.TypeGrade;

/**
 *
 * @author Laptop K1
 */
public class GradeDao extends DBContext {

    public List<Grade> getAllListGradeExamByStudentid(int studentID) {
        List<Grade> listgrade = new ArrayList<>();
        try {
            connection = getConnection();
            String sql = "select gr.id,sg.gname,s.sname,tg.name,tg.weight,gr.GradeValue from Grade gr\n"
                    + "inner join TypeGrade tg\n"
                    + "on gr.tgid=tg.id\n"
                    + "inner join Student s\n"
                    + "on s.sid=gr.sid\n"
                    + "inner join StudentGroup sg\n"
                    + "on s.gid=sg.gid\n"
                    + "where s.sid=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, studentID);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setId(resultSet.getInt("id"));
                grade.setGradevalue(resultSet.getInt("GradeValue"));
                
                StudentGroup group=new StudentGroup();
                group.setName(resultSet.getString("gname"));
                grade.setGroup(group);
                
                Student student=new Student();
                student.setName(resultSet.getString("sname"));
                grade.setStudent(student);
                
                TypeGrade type=new TypeGrade();
                type.setName(resultSet.getString("name"));
                type.setWeight(resultSet.getFloat("weight"));
                grade.setTypegrade(type);
                
                listgrade.add(grade);
 
              
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(GradeDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listgrade;
    }
     public List<Grade> getAllListGradeExamByGroupid(int GroupID) {
        List<Grade> listgrade = new ArrayList<>();
        try {
            connection = getConnection();
            String sql = "select gr.id,sg.gname,s.sname,tg.name,tg.weight,gr.GradeValue from Grade gr\n" +
"inner join TypeGrade tg\n" +
"on gr.tgid=tg.id\n" +
"inner join Student s\n" +
"on s.sid=gr.sid\n" +
"inner join StudentGroup sg\n" +
"on s.gid=sg.gid\n" +
"where sg.gid=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, GroupID);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setId(resultSet.getInt("id"));
                grade.setGradevalue(resultSet.getInt("GradeValue"));
                
                StudentGroup group=new StudentGroup();
                group.setName(resultSet.getString("gname"));
                grade.setGroup(group);
                
                Student student=new Student();
                student.setName(resultSet.getString("sname"));
                grade.setStudent(student);
                
                TypeGrade type=new TypeGrade();
                type.setName(resultSet.getString("name"));
                type.setWeight(resultSet.getFloat("weight"));
                grade.setTypegrade(type);
                
                listgrade.add(grade);
 
              
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(GradeDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listgrade;
    }
     
      public void update(Grade grade) {
    try {
        connection = getConnection();
        String sql = "UPDATE [dbo].[Grade]\n" +
"   SET [GradeValue] = ?\n" +
" WHERE id=?";
        PreparedStatement stm = connection.prepareStatement(sql);    
        stm.setInt(1, grade.getGradevalue());    
        stm.setInt(2, grade.getId()); 
        stm.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GradeDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}    
      public List<Grade> getAllListGrade() {
        List<Grade> listgrade = new ArrayList<>();
        try {
            connection = getConnection();
            String sql = "select gr.id,sg.gname,s.sname,tg.name,tg.weight,gr.GradeValue from Grade gr\n"
                    + "inner join TypeGrade tg\n"
                    + "on gr.tgid=tg.id\n"
                    + "inner join Student s\n"
                    + "on s.sid=gr.sid\n"
                    + "inner join StudentGroup sg\n"
                    + "on s.gid=sg.gid\n";
                   
            statement = connection.prepareStatement(sql);
       
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setId(resultSet.getInt("id"));
                grade.setGradevalue(resultSet.getInt("GradeValue"));
                
                StudentGroup group=new StudentGroup();
                group.setName(resultSet.getString("gname"));
                grade.setGroup(group);
                
                Student student=new Student();
                student.setName(resultSet.getString("sname"));
                grade.setStudent(student);
                
                TypeGrade type=new TypeGrade();
                type.setName(resultSet.getString("name"));
                type.setWeight(resultSet.getFloat("weight"));
                grade.setTypegrade(type);
                
                listgrade.add(grade);
 
              
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(GradeDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listgrade;
    }
      public static void main(String[] args) {
          for (Grade grade : new GradeDao().getAllListGrade()) {
              System.out.println(grade);
          }
    }
   
}
