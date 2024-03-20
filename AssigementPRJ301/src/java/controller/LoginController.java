/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDao;
import dal.RoleDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Role;

/**
 *
 * @author Laptop K1
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    AccountDao dao = new AccountDao();
     RoleDao roleDao=new RoleDao();
    Account account = dao.findUseNameAndPassword(username, password);
    if (account != null) {
       
        HttpSession session = request.getSession();
        session.setAttribute("username", username) ;

      
        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);
        usernameCookie.setMaxAge(3600*24*7);
        passwordCookie.setMaxAge(3600*24*7);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);

       
        String roleName = roleDao.getRoleName(username);
        if (roleName != null) {
            switch (roleName) {
                case "management":
                    response.sendRedirect("ManagementHome");
                    break;
                case "lecturer":
                    response.sendRedirect("LecturerHome");
                    break;
                case "student":
                    response.sendRedirect("StudentHome");
                    break;
                default:
                    response.sendRedirect("AccessDenied");
            }
        } else {
            response.sendRedirect("AccessDenied");
        }
    } else {
        request.setAttribute("error", "Invalid username or password");
        response.sendRedirect("login.jsp");
    }
}

}
