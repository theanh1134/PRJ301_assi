package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Lecturer;

public class LecturerDao extends DBContext {
     
  public List<Lecturer> findAll() {
    List<Lecturer> lecturerList = new ArrayList<>();
    try {
        connection = getConnection();
        String sql = "SELECT l.lid, l.lname, l.lgender, l.lemail, l.lphone, l.laddress, d.dename " +
                     "FROM Lecturer l " +
                     "INNER JOIN Department d ON l.deid = d.deid";
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Lecturer lecturer = new Lecturer();
            lecturer.setId(resultSet.getInt("lid"));
            lecturer.setName(resultSet.getString("lname"));
            lecturer.setGender(resultSet.getString("lgender"));
            lecturer.setEmail(resultSet.getString("lemail"));
            lecturer.setPhone(resultSet.getInt("lphone"));
            lecturer.setAddress(resultSet.getString("laddress"));

            // Thiết lập thông tin phòng ban
            Department department = new Department();
            department.setName(resultSet.getString("dename"));
            lecturer.setDepartment(department);

            lecturerList.add(lecturer);
        }
    } catch (SQLException ex) {
        Logger.getLogger(LecturerDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lecturerList;
}


    public Lecturer getLecturerById(int lid) {
        Lecturer lecturer = new Lecturer();
       Department department=new Department();

        try {
            connection = getConnection();
            String sql = "SELECT l.lid, l.lname, l.lgender, l.lemail, l.lphone, l.laddress, d.dename "
                       + "FROM Lecturer l INNER JOIN Department d ON l.deid = d.deid "
                       + "WHERE l.lid = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, lid);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                lecturer = new Lecturer();
                lecturer.setId(resultSet.getInt("lid"));
                lecturer.setName(resultSet.getString("lname"));
                lecturer.setGender(resultSet.getString("lgender"));
                lecturer.setEmail(resultSet.getString("lemail"));
                lecturer.setPhone(resultSet.getInt("lphone"));
                lecturer.setAddress(resultSet.getString("laddress"));
                department.setName(resultSet.getString("dename"));
                lecturer.setDepartment(department);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
   
        return lecturer;
    }
     
 public void insert(Lecturer entity) {
    try {
        connection = getConnection();
        String sql = "INSERT INTO [dbo].[Lecturer] " +
                     "([lid], [lname], [lgender], [lemail], [lphone], [laddress], [deid]) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, entity.getId());
        stm.setString(2, entity.getName());
        stm.setString(3, entity.getGender());
        stm.setString(4, entity.getEmail());
        stm.setInt(5, entity.getPhone());
        stm.setString(6, entity.getAddress());
        stm.setInt(7, entity.getDepartment().getId()); // Thêm giá trị cho cột deid
        
        stm.executeUpdate();
        System.out.println("Insert successful!");
    } catch (SQLException ex) {
        Logger.getLogger(LecturerDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}



   
   public void update(Lecturer entity) {
    try {
        connection = getConnection();
        String sql = "UPDATE [dbo].[Lecturer]\n" +
                     "   SET [lname] = ?,\n" +
                     "      [lgender] = ?,\n" +
                     "      [lemail] = ?,\n" +
                     "      [lphone] = ?,\n" +
                     "      [laddress] = ?,\n" +
                     "      [deid] = ?\n" + 
                     " WHERE lid = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, entity.getName());
        stm.setString(2, entity.getGender());
        stm.setString(3, entity.getEmail());
        stm.setInt(4, entity.getPhone());
        stm.setString(5, entity.getAddress());
        stm.setInt(6, entity.getDepartment().getId()); 
        stm.setInt(7, entity.getId()); 
        stm.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(LecturerDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}


 
    public void delete(Lecturer entity) {
        try {
            connection=getConnection();
            String sql = "DELETE FROM [dbo].[Lecturer]\n" +
"      WHERE lid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
    LecturerDao lecturerDao = new LecturerDao();
    List<Lecturer> lecturers = lecturerDao.findAll();

    if (lecturers.isEmpty()) {
        System.out.println("Aucun enseignant trouvé.");
    } else {
        System.out.println("Liste des enseignants :");
        for (Lecturer lecturer : lecturers) {
            System.out.println("ID: " + lecturer.getId());
            System.out.println("Nom: " + lecturer.getName());
            System.out.println("Genre: " + lecturer.getGender());
            System.out.println("Email: " + lecturer.getEmail());
            System.out.println("Téléphone: " + lecturer.getPhone());
            System.out.println("Adresse: " + lecturer.getAddress());
            System.out.println("Département: " + lecturer.getDepartment().getName());
            System.out.println("-------------------------------------");
        }
    }

   
       // Tạo một đối tượng giáo viên mới
Lecturer lecturer = new Lecturer();
lecturer.setId(5);
lecturer.setName("John Doe");
lecturer.setGender("Male");
lecturer.setEmail("john.doe@example.com");
lecturer.setPhone(123456789);
lecturer.setAddress("123 Main Street");

// Tạo một đối tượng phòng ban và đặt giá trị cho deid
Department department = new Department();
department.setId(1); // Thay id bằng giá trị phù hợp của phòng ban
lecturer.setDepartment(department);

// Thực hiện insert
lecturerDao.insert(lecturer);

System.out.println("Insert successful!");

}
}
