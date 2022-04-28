/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
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
@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  response.setContentType("text/html;charset=UTF-8");
          //b1: get data from dao
          DAO dao = new DAO();
          List<Product> list = dao.getTop3();
          List<Category> listC = dao.getAllCategory();
          Product last = dao.getLast();
          
          //b2: set data to jsp
          request.setAttribute("listP", list);
          request.setAttribute("listCC", listC);
          request.setAttribute("p", last);
          request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doGet(request, response);
    }

    
}
