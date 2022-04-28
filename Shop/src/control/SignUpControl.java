/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Account;
import entity.Category;
import entity.Product;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trinh
 */
@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  response.setContentType("text/html;charset=UTF-8");
          String user = request.getParameter("user");
          String pass = request.getParameter("pass");
          String re_pass = request.getParameter("repass");
          if(!pass.equals(re_pass)){
              response.sendRedirect("Login.jsp");
          }else{
              DAO dao = new DAO();
              Account a = dao.checkAccountExist(user);
              if(a == null){
                  //dc signup
                  dao.singup(user, pass);
                  response.sendRedirect("home");
              }else{
                  //day ve trang login.jsp
                  response.sendRedirect("Login.jsp");
              }
          }
          //sign up
    }

 

}
