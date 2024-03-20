/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import controller.authentication.BaseRequiredAuthenticationController;
import dal.LecturerDao;
import dal.LessionDao;
import dal.TimeSlotDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Lecturer;
import model.Lession;
import model.TimeSlot;
import util.DateTimeHelper;

/**
 *
 * @author Laptop K1
 */
public class TimeTableController extends BaseRequiredAuthenticationController {

    /**
     * Processes reqs for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req servlet req
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimeTableController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeTableController at " + req.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        doGet(req, resp, account);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int lid;
        Date today = new Date();
        java.sql.Date from;
        java.sql.Date to;

        try {
            String lidString = req.getParameter("id");
            if (lidString == null || lidString.isEmpty()) {
                lid = 1;
            } else {
                lid = Integer.parseInt(lidString);
            }

            String raw_from = req.getParameter("from");
            if (raw_from == null || raw_from.isEmpty()) {
                from = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.getWeekStart(today));
            } else {
                from = java.sql.Date.valueOf(raw_from);
            }

            String raw_to = req.getParameter("to");
            if (raw_to == null || raw_to.isEmpty()) {
                to = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.addDaysToDate(DateTimeHelper.getWeekStart(today), 6));
            } else {
                to = java.sql.Date.valueOf(raw_to);
            }
        } catch (NumberFormatException ex) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID");
            return;
        }

        ArrayList<java.sql.Date> dates = DateTimeHelper.getDatesBetween(from, to);

        TimeSlotDao slotDB = new TimeSlotDao();
        ArrayList<TimeSlot> slots = slotDB.listTime();
      
        LessionDao lessionDB = new LessionDao();
        ArrayList<Lession> lessions = lessionDB.getBy(lid, from, to);
        
        LecturerDao lecDB=new LecturerDao();
        List<Lecturer> lecturers = lecDB.findAll();
        
        req.setAttribute("lecturers", lecturers);
        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.setAttribute("slots", slots);
        req.setAttribute("dates", dates);
        req.setAttribute("lessions", lessions);
        req.getRequestDispatcher("timetable.jsp").forward(req, resp);
    }
}
