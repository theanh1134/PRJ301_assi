package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Exam;
import model.Lecturer;
import model.Room;
import model.Subject;
import model.TimeSlot;
import model.TypeGrade;

public class ExamDao extends DBContext {

    public List<Exam> getAllListExam() {
        List<Exam> listExam = new ArrayList<>();
        try {
            connection = getConnection();
            String sql = "select ex.id,su.subname,ex.date,tg.name,r.rname,ts.tname,le.lname from Exam ex\n" +
"inner join Subject su\n" +
"on ex.subid=su.subid\n" +
"inner join TypeGrade tg\n" +
"on ex.grid=tg.id\n" +
"inner join room r\n" +
"on ex.rid=r.rid\n" +
"inner join TimeSlot ts\n" +
"on ex.tid=ts.tid\n" +
"inner join Lecturer le\n" +
"on ex.leid=le.lid";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Exam exam = new Exam();
                exam.setId(resultSet.getInt("id"));
                exam.setDate(resultSet.getDate("date"));
                        
                Subject subject = new Subject();
                subject.setName(resultSet.getString("subname"));
                exam.setSubject(subject);
                
                TypeGrade type = new TypeGrade();
                type.setName(resultSet.getString("name"));
                exam.setTypegrade(type);
                
                Room room = new Room();
                room.setName(resultSet.getString("rname"));
                exam.setRoom(room);
                
                TimeSlot slot = new TimeSlot();
                slot.setName(resultSet.getString("tname"));
                exam.setSlot(slot);
                 
                Lecturer lecturer = new Lecturer();
                lecturer.setName(resultSet.getString("lname"));
                exam.setLecturer(lecturer);
                
                listExam.add(exam);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AttendanceDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listExam;
    }
    
     public List<Exam> getAllListExamScheduleByid(int lecturerID) {
        List<Exam> listExam = new ArrayList<>();
        try {
            connection = getConnection();
            String sql = "select ex.id,su.subname,ex.date,tg.name,r.rname,ts.tname,le.lname from Exam ex\n" +
"inner join Subject su\n" +
"on ex.subid=su.subid\n" +
"inner join TypeGrade tg\n" +
"on ex.grid=tg.id\n" +
"inner join room r\n" +
"on ex.rid=r.rid\n" +
"inner join TimeSlot ts\n" +
"on ex.tid=ts.tid\n" +
"inner join Lecturer le\n" +
"on ex.leid=le.lid\n" +
"where le.lid=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, lecturerID);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Exam exam = new Exam();
                exam.setId(resultSet.getInt("id"));
                exam.setDate(resultSet.getDate("date"));
                        
                Subject subject = new Subject();
                subject.setName(resultSet.getString("subname"));
                exam.setSubject(subject);
                
                TypeGrade type = new TypeGrade();
                type.setName(resultSet.getString("name"));
                exam.setTypegrade(type);
                
                Room room = new Room();
                room.setName(resultSet.getString("rname"));
                exam.setRoom(room);
                
                TimeSlot slot = new TimeSlot();
                slot.setName(resultSet.getString("tname"));
                exam.setSlot(slot);
                 
                Lecturer lecturer = new Lecturer();
                lecturer.setName(resultSet.getString("lname"));
                exam.setLecturer(lecturer);
                
                listExam.add(exam);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AttendanceDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listExam;
    }
    
    
    
    public static void main(String[] args) {
        for (Exam exam : new ExamDao().getAllListExamScheduleByid(1)) {
            System.out.println(exam);
        }
    }
           
}
