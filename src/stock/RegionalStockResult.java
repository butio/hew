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
 * Servlet implementation class RegionalStockResult
 */
@WebServlet("/RegionalStockResult")
public class RegionalStockResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionalStockResult() {
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

		String area = request.getParameter("select");
		String action = request.getParameter("action");
		int state = Integer.parseInt(action);

		ArrayList<StockDB> arrayList=new ArrayList<StockDB>();
		String sql = "";

		Dao dao = null;
		ResultSet rs = null;
		try{
			if(state == 1){
				System.out.println(state);
				//地域ボーダーを超えていて、自販機ボーダーを切っている商品
				sql ="select area.area_place,vending.id,vending.area_id,vending.place,stock.count,product.name,stock.stock,stock.max_stock,(max_stock * 0.3) as vorder_stock " +
						" from stock inner join product on product.id = stock.product_id" +
						" inner join vending on vending.id = stock.vending_id" +
						" inner join area on area.id = vending.area_id" +
						" where stock.stock <= (max_stock * 0.3)" +
						" and not exists(select count(*),area.id,area.area_place,product.name,sum(stock.stock) as area_stock,sum(max_stock) as area_max,(sum(max_stock) * 0.3) as area_border " +
						" from stock inner join product on product.id = stock.product_id" +
						" inner join vending on vending.id = stock.vending_id" +
						" inner join area on area.id = vending.area_id" +
						" group by area.id,product.id" +
						" having sum(stock.stock) <= (sum(max_stock) * 0.3))" +
						" and vending.area_id = "+area+""+
						" group by vending.area_id,vending.id,stock.count;";


				System.out.println(sql);
			}else if(state == 2){
				System.out.println(state);
				//自動販売機ボーダーを超えていて、地域ボーダーを切っている商品
				sql ="select vending.id,stock.count,vending.area_id,area.area_place,stock.vending_id,vending.place,product.name,stock.stock,stock.max_stock,(max_stock * 0.3) as vorder_stock" +
						" from stock inner join product on product.id = stock.product_id" +
						" inner join vending on vending.id = stock.vending_id" +
						" inner join area on area.id = vending.area_id" +
						" where exists(select vending.id,vending.place,stock.count,product.name,stock.stock,stock.max_stock,(max_stock * 0.3) as vorder_stock from stock" +
						" inner join product on product.id = stock.product_id" +
						" inner join vending on vending.id = stock.vending_id" +
						" where stock.stock >= (max_stock * 0.3)" +
						" group by vending.id,stock.count)" +
						" and vending.area_id = "+area+"" +
						" group by area.id,product.id" +
						" having sum(stock.stock) <= (sum(max_stock) * 0.3);";

				System.out.println(sql);
			}

			dao = new Dao();
			rs = dao.execute(sql);
			while(rs.next()){
				StockDB s = new StockDB();
				s.setArea(rs.getString("area.area_place"));
				s.setPlace(rs.getString("vending.place"));
				s.setProductName(rs.getString("product.name"));
				s.setStock(rs.getInt("stock.stock"));
				s.setMaxStock(rs.getInt("stock.max_stock"));
				s.setStockBorder(rs.getInt("vorder_stock"));
				arrayList.add(s);
			}

			request.setAttribute("RESULT",arrayList);
			RequestDispatcher rd=request.getRequestDispatcher("/RegionalStockResult.jsp");
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