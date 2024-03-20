package CRUDController;


import dal.LecturerDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Department;
import model.Lecturer;

public class updateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LecturerDao lecturerDao=new LecturerDao();
          List<Lecturer> lecturerList = lecturerDao.findAll();
        request.setAttribute("lecturerList", lecturerList);
        request.getRequestDispatcher("updateOption.jsp").forward(request, response);
    }

  @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Lấy dữ liệu từ request parameter
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    int phone = Integer.parseInt(request.getParameter("phone"));
    String address = request.getParameter("address");
    int departmentId = Integer.parseInt(request.getParameter("departmentId"));
    
    // Tạo đối tượng giảng viên với dữ liệu mới
    Lecturer lecturer = new Lecturer();
    lecturer.setId(id);
    lecturer.setName(name);
    lecturer.setGender(gender);
    lecturer.setEmail(email);
    lecturer.setPhone(phone);
    lecturer.setAddress(address);
    
    // Tạo đối tượng Department với ID
    Department department = new Department();
    department.setId(departmentId);
    
    // Gán department cho giảng viên
    lecturer.setDepartment(department);
    
    // Gọi phương thức update trong DAO để cập nhật thông tin giảng viên
    LecturerDao lecturerDao = new LecturerDao();
    lecturerDao.update(lecturer);
    
    // Chuyển hướng người dùng đến trang cần thiết sau khi cập nhật thành công
    response.sendRedirect("list");
}
}