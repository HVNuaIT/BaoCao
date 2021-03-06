package control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Category;

/**
 * Servlet implementation class LoadControlCa
 */


@WebServlet(name = "LoadControlCa", urlPatterns = {"/loadCa"})
public class LoadControlCa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoadControlCa() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
     
       
       Category p = dao.getCategoryByID(id);
     
        request.setAttribute("list", p);
        request.getRequestDispatcher("managerCa").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
