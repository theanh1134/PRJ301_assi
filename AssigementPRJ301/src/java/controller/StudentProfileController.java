/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author Laptop K1
 */
public class StudentProfileController extends HttpServlet {
   
  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         request.getRequestDispatcher("studentprofile.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String gid = request.getParameter("gid");
         if(gid==null){
            response.getWriter().print("Please enter gid you want search");
        }else{
             try {
                   int groupId = Integer.parseInt(gid);
        StudentDao studentDao=new StudentDao();
       
        ArrayList<Student> students = studentDao.getStudentByGroupID(groupId);     
        request.setAttribute("students", students);     
        request.getRequestDispatcher("studentprofile.jsp").forward(request, response);
             } catch (NumberFormatException e) {
                  response.getWriter().print("Please enter gid is integer >0");
             }
  
    }
    }

   

}
