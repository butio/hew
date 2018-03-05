package restocking;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Dao;

/**
 * Servlet implementation class Restocking
 */
@WebServlet("/Restocking")
public class Restocking extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Restocking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String VENDING_ID = (String)session.getAttribute("VENDING_ID");

		ArrayList<RestockingDB> arrayList=new ArrayList<RestockingDB>();
		String sql = "";
		Dao dao = null;
		ResultSet rs = null;
		try{

			sql = "select vending.id, stock.count, area.area_place, vending.place, product.name, stock.price, stock.stock, stock.max_stock, stock.receiptdate from stock"+
					" inner join vending on vending.id = stock.vending_id"+
					" inner join area on area.id = vending.area_id"+
					" inner join product on product.id = stock.product_id" +
					" where vending.id = "+VENDING_ID+"" +
					" and stock.max_stock > stock.stock;";

			dao = new Dao();
			rs = dao.execute(sql);
			while(rs.next()){
				RestockingDB r = new RestockingDB();
				r.setVendingId(rs.getInt("vending.id"));
				r.setCount(rs.getInt("stock.count"));
				r.setArea(rs.getString("area.area_place"));
				r.setPlace(rs.getString("vending.place"));
				r.setProductName(rs.getString("product.name"));
				r.setStock(rs.getInt("stock.stock"));
				r.setMaxStock(rs.getInt("stock.max_stock"));
				r.setReceiptdate(rs.getString("stock.receiptdate"));
				arrayList.add(r);
			}

			request.setAttribute("RESULT",arrayList);
			RequestDispatcher rd=request.getRequestDispatcher("/RestockingInput.jsp");
			rd.forward(request, response);

		}catch(Exception e){
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				dao.close();
			}
			catch(Exception e){

			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
