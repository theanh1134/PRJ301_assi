/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.authentication;



import dal.RoleDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Account;
import model.Role;

/**
 *
 * @author sonnt
 */
public abstract class BaseRBACController extends BaseRequiredAuthenticationController {
    
    private ArrayList<Role> getRoles(HttpServletRequest req,Account account)
    {
        String url = req.getServletPath();
        RoleDao roleDB = new RoleDao();
        return roleDB.getByUsernanmeAndUrl(account.getUsername(), url);
    }

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, Account account,ArrayList<Role> roles) 
            throws ServletException, IOException;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        ArrayList<Role> roles = getRoles(req, account);
        if(roles.size()<=1)
        {
            resp.getWriter().println("access denied!");
        }
        else
        {
            doPost(req, resp, account, roles);
        }
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, Account account,ArrayList<Role> roles) 
            throws ServletException, IOException;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        ArrayList<Role> roles = getRoles(req, account);
        if(roles.size() <=1)
        {
            resp.getWriter().println("access denied!");
        }
        else
        {
            doGet(req, resp, account, roles);
        }
    }
    
}
