/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import controller.authentication.BaseRBACController;
import controller.authentication.BaseRequiredAuthenticationController;
import dal.AttendanceDao;
import dal.LessionDao;
import dal.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Account;
import model.Attendance;
import model.Lession;
import model.Role;
import model.Student;

/**
 *
 * @author Laptop K1
 */
public class LecturerTakeAttendanceController extends BaseRequiredAuthenticationController{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet LecturerTakeAttendanceController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LecturerTakeAttendanceController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


   

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int leid = Integer.parseInt(req.getParameter("id"));
        StudentDao studentDB = new StudentDao();
        ArrayList<Student> students = studentDB.listStudent(leid);
        ArrayList<Attendance> attendances = new ArrayList<>();
        Lession lession = new Lession();
        lession.setId(leid);
        for (Student student : students) {
            Attendance attendance = new Attendance();
            attendance.setLession(lession);
            attendance.setStudent(student);
            attendance.setIsPresent(req.getParameter("present" + student.getId()).equals("yes"));
            attendance.setDescription(req.getParameter("description" + student.getId()));
            attendances.add(attendance);
        }
        AttendanceDao attendanceDB = new AttendanceDao();
        attendanceDB.updateTimetableByLession(leid, attendances);
        resp.sendRedirect("att?id=" + leid);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int leid = Integer.parseInt(req.getParameter("id"));
        LessionDao lessionDB = new LessionDao();
        ArrayList<Attendance> attendances = lessionDB.getAttendanceBy(leid);
        req.setAttribute("attendances", attendances);
        req.getRequestDispatcher("attendance.jsp").forward(req, resp);
    }

}
