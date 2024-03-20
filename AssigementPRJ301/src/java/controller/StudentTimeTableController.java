package controller;

import dal.LessionDao;
import dal.TimeSlotDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Lession;
import model.TimeSlot;
import util.DateTimeHelper;

public class StudentTimeTableController extends HttpServlet {
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
        int sid;
        Date today = new Date();
        java.sql.Date from;
        java.sql.Date to;

        try {
            String sidString = request.getParameter("id");
            if (sidString == null || sidString.isEmpty()) {
                sid = 1;
            } else {
                sid = Integer.parseInt(sidString);
            }

            String raw_from = request.getParameter("from");
            if (raw_from == null || raw_from.isEmpty()) {
                from = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.getWeekStart(today));
            } else {
                from = java.sql.Date.valueOf(raw_from);
            }

            String raw_to = request.getParameter("to");
            if (raw_to == null || raw_to.isEmpty()) {
                to = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.addDaysToDate(DateTimeHelper.getWeekStart(today), 6));
            } else {
                to = java.sql.Date.valueOf(raw_to);
            }
        } catch (NumberFormatException ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID");
            return;
        }

        ArrayList<java.sql.Date> dates = DateTimeHelper.getDatesBetween(from, to);

        TimeSlotDao slotDB = new TimeSlotDao();
        ArrayList<TimeSlot> slots = slotDB.listTime();

        LessionDao lessionDB = new LessionDao();
        ArrayList<Lession> lessions = lessionDB.getLessionByIDSTudent(sid, from, to);

        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("lessions", lessions);
        request.getRequestDispatcher("studenttimetable.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("studenttimetable.jsp").forward(request, response);
       
        
    }
}
