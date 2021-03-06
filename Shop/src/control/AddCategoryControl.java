package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;



@WebServlet(name = "AddCategoryControl", urlPatterns = {"/addCa"})
public class AddCategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddCategoryControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String cname = request.getParameter("cname");
	  
	        HttpSession session = request.getSession();
	        Account a = (Account) session.getAttribute("acc");
	        int sid = a.getId();
	        DAO dao = new DAO();
	       dao.insertCategory(cname);
	        response.sendRedirect("managerCa");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
