/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package CRUDController;

import dal.LecturerDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Department;
import model.Lecturer;

/**
 *
 * @author Laptop K1
 */
public class insertController extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insertController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    
   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    request.getRequestDispatcher("insert.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
   
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    int phone = Integer.parseInt(request.getParameter("phone"));
    String address = request.getParameter("address");
    int departmentId = Integer.parseInt(request.getParameter("departmentId")); 
    
   
    Lecturer lecturer = new Lecturer();
    lecturer.setId(id);
    lecturer.setName(name);
    lecturer.setGender(gender);
    lecturer.setEmail(email);
    lecturer.setPhone(phone);
    lecturer.setAddress(address);
    
   
    Department department = new Department();
    department.setId(departmentId);
    lecturer.setDepartment(department);
    
    
    LecturerDao lecturerDao = new LecturerDao();
    lecturerDao.insert(lecturer);
    
  
    response.sendRedirect("list");
}

}