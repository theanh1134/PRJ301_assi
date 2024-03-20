/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ExamDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Exam;

/**
 *
 * @author Laptop K1
 */
public class ExamScheduleController extends HttpServlet {
   
 
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         request.getRequestDispatcher("viewschedule.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String lecturerid = request.getParameter("lid");
         if(lecturerid==null){
            request.setAttribute("error", "You must enter lid is not null");
        }else{
             try {
                   int lid = Integer.parseInt(lecturerid);
                   ExamDao examDb=new ExamDao();
       
        ArrayList<Exam> examList =  (ArrayList<Exam>) examDb.getAllListExamScheduleByid(lid);
        request.setAttribute("examList", examList);     
        request.getRequestDispatcher("viewschedule.jsp").forward(request, response);
             } catch (NumberFormatException e) {
                  response.getWriter().print("Please enter sid is integer >0");
             }
  
    }
    }

   
}
