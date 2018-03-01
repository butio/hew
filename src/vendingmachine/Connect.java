package vendingmachine;

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
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connect() {
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

		String vendingID = request.getParameter("vendingMachineID");
		session.setAttribute("VENDING_ID",vendingID);

		ArrayList<getVendingDB> arrayList=new ArrayList<getVendingDB>();

		Dao dao = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT count,image,state,price FROM stock INNER JOIN product ON stock.product_id = product.id WHERE vending_id = '"+ vendingID +"' ORDER BY count ASC ;";

			dao = new Dao();
			rs = dao.execute(sql);
			while(rs.next()){
				getVendingDB v = new getVendingDB();
				v.setCount(rs.getInt("count"));
				v.setImg(rs.getString("image"));
				v.setState(rs.getInt("state"));
				v.setPrice(rs.getInt("price"));
				arrayList.add(v);
			}

			request.setAttribute("RESULT",arrayList);
			RequestDispatcher rd=request.getRequestDispatcher("/machine.jsp");
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
