/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import controller.authentication.BaseRequiredAuthenticationController;
import dal.LecturerDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Account;
import model.Lecturer;

/**
 *
 * @author Laptop K1
 */
public class ProfileController extends BaseRequiredAuthenticationController {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 


  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
  
    String idParam = req.getParameter("id");
    LecturerDao lecturerdb = new LecturerDao();

    if (idParam != null && !idParam.isEmpty()) {
        int id = Integer.parseInt(idParam);
        Lecturer lecturer = lecturerdb.getLecturerById(id);
        req.setAttribute("lecturer", lecturer);
    } else {
        List<Lecturer> lecturers = lecturerdb.findAll();
        req.setAttribute("lecturers", lecturers);
    }

    req.getRequestDispatcher("searchProfile.jsp").forward(req, resp);
}



@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
    String id_param = req.getParameter("id");
    if (id_param != null && !id_param.isEmpty()) {
        int id = Integer.parseInt(id_param);
        LecturerDao lecturerDao = new LecturerDao();
        Lecturer lecturer = lecturerDao.getLecturerById(id);
        if (lecturer != null) {
            req.setAttribute("lecturer", lecturer);
            req.getRequestDispatcher("lecturerProfile.jsp").forward(req, resp);
            return;
        }
    } else {
        LecturerDao lecturerDao = new LecturerDao();
        List<Lecturer> lecturers = lecturerDao.findAll();
        req.setAttribute("lecturers", lecturers);
        req.getRequestDispatcher("searchProfile.jsp").forward(req, resp);
        return;
    }

    resp.sendRedirect("searchProfile.jsp");
}
}