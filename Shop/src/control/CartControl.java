package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Cart;
import entity.Product;

/**
 * Servlet implementation class CartControl
 */
@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DAO dao = new DAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		Cart cart = (Cart)sesion.getAttribute("cart");
		String msp  = request.getParameter("maSanPham");
		String command = request.getParameter("command");
		String  url = "";
		ArrayList<Long> listBuy  = null;
			try {
				listBuy  = (ArrayList<Long>)sesion.getAttribute("cartID");
				long idBuy = 0;
				if(request.getParameter("cartID") !=null) {
					idBuy  =Long.parseLong(request.getParameter("cartID"));
					Product sp = dao.getProduct(msp);
					switch(command) {
					case "insert":
						if(listBuy == null) {
							listBuy = new ArrayList<Long>();
							sesion.setAttribute("cartID", listBuy);
						}
						if(listBuy.indexOf(idBuy)==-1) {
							cart.themGioHang(sp, 1);
							listBuy.add(idBuy); 
							
						}
						url = "/Cart.jsp";
						break;
					case "plus":
						if(listBuy == null) {
							listBuy = new ArrayList<>();
							sesion.setAttribute("cart", listBuy);
						}if(listBuy.indexOf(idBuy)==-1) {
							cart.themGioHang(sp, 1);
							listBuy.add(idBuy);
						}url = "/Cart.jsp";
						break;
						
					case "sub":
						if(listBuy == null) {
							listBuy = new ArrayList<>();
							sesion.setAttribute("cart", listBuy);
						}if(listBuy.indexOf(idBuy)==-1) {
							cart.subToCart(sp, 1);
							listBuy.add(idBuy);
						}url = "/Cart.jsp";
						break;
					case "delete":
						break;
						default:
						break;
					}
					RequestDispatcher rd  = getServletContext().getRequestDispatcher(url);
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
