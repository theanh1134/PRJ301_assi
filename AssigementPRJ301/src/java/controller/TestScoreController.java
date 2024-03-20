/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.GradeDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Grade;

/**
 *
 * @author Laptop K1
 */
public class TestScoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         request.getRequestDispatcher("testscore.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String groupID = request.getParameter("gid");
        
         if(groupID==null){
            request.setAttribute("error", "You must enter sid is not null");
        }else{
             try {
                   int gid = Integer.parseInt(groupID);
                 GradeDao gradeDb=new GradeDao();
       
        ArrayList<Grade> testscore =  (ArrayList<Grade>) gradeDb.getAllListGradeExamByGroupid(gid);
        request.setAttribute("testscore", testscore);     
        request.getRequestDispatcher("testscore.jsp").forward(request, response);
             } catch (NumberFormatException e) {
                  response.getWriter().print("Please enter sid is integer >0");
             }
  
    }
    }
}
