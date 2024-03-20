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
import java.util.Enumeration;
import model.Grade;

/**
 *
 * @author Laptop K1
 */
public class UpdateGradeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("testscore.jsp").forward(request, response);
    }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   
    Enumeration<String> parameterNames = request.getParameterNames();
    while (parameterNames.hasMoreElements()) {
        String paramName = parameterNames.nextElement();
        if (paramName.startsWith("gradeId_")) {
            // Lấy gradeId từ paramName
            int gradeId = Integer.parseInt(paramName.substring("gradeId_".length()));
            // Lấy gradeValue tương ứng với gradeId
            int gradeValue = Integer.parseInt(request.getParameter("gradeValue_" + gradeId));

            // Tạo đối tượng Grade và cập nhật dữ liệu
            Grade grade = new Grade();
            grade.setId(gradeId);
            grade.setGradevalue(gradeValue);

            // Lưu cập nhật vào cơ sở dữ liệu
            GradeDao gradeDao = new GradeDao();
            gradeDao.update(grade);
        }
    }

    // Chuyển hướng người dùng đến testscore.jsp
    request.getRequestDispatcher("testscore.jsp").forward(request, response);
}
}