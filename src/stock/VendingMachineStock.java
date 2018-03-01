package stock;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;

/**
 * Servlet implementation class VendingMachineStock
 */
@WebServlet("/VendingMachineStock")
public class VendingMachineStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendingMachineStock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String vendingID = request.getParameter("vendingMachineID");

		ArrayList<StockDB> arrayList=new ArrayList<StockDB>();

		Dao dao = null;
		ResultSet rs = null;
		try{
			String sql = "select area.area_place,vending.place,product.name,stock.price,stock.stock,stock.max_stock,stock.receiptdate from stock" +
							" inner join vending on vending.id = stock.vending_id"+
							" inner join area on area.id = vending.area_id"+
							" inner join product on product.id = stock.product_id"+
							" where vending.id = "+vendingID+";";

			dao = new Dao();
			rs = dao.execute(sql);
			while(rs.next()){
				StockDB s = new StockDB();
				s.setArea(rs.getString("area.area_place"));
				s.setPlace(rs.getString("vending.place"));
				s.setProductName(rs.getString("product.name"));
				s.setPrice(rs.getInt("stock.price"));
				s.setStock(rs.getInt("stock.stock"));
				s.setMaxStock(rs.getInt("stock.max_stock"));
				s.setReceiptdate(rs.getString("stock.receiptdate"));
				arrayList.add(s);
			}

			request.setAttribute("RESULT",arrayList);
			RequestDispatcher rd=request.getRequestDispatcher("/VendingMachineStock.jsp");
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
