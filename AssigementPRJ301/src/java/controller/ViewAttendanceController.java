/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AttendanceDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Attendance;

/**
 *
 * @author Laptop K1
 */
public class ViewAttendanceController extends HttpServlet {
   
 

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         request.getRequestDispatcher("viewatt.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String studentid = request.getParameter("sid");
         if(studentid==null){
            request.setAttribute("error", "You must enter sid is not null");
        }else{
             try {
                   int sid = Integer.parseInt(studentid);
                 AttendanceDao attDB=new AttendanceDao();
       
        ArrayList<Attendance> attendances =  (ArrayList<Attendance>) attDB.getAttendanceForStudentID(sid);
        request.setAttribute("attendances", attendances);     
        request.getRequestDispatcher("viewatt.jsp").forward(request, response);
             } catch (NumberFormatException e) {
                  response.getWriter().print("Please enter sid is integer >0");
             }
  
    }
    }

   
}
