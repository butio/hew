package vendingmachine;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Dao;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase() {
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

		String coin = request.getParameter("coin");
		String drink = request.getParameter("drink");
		int MEMBER_ID = (int)session.getAttribute("MEMBER_ID");
		String fileJsp = "/out.jsp";

		 Billing r = new Billing();

		 Dao dao = null;
		 ResultSet rs = null;

		 try{

			 int price = 0;
			 dao = new Dao();
			 rs = dao.execute("SELECT price FROM stock WHERE count = "+ drink +" ;");
			 while(rs.next()){
					price = rs.getInt("price");
			 }

			 int intCoin = Integer.parseInt(coin);
			 r.setChange(intCoin, price);

			 if(r.errFlg){
				 System.out.println("購入");

				 //売り上げを追加
				 int productId = 0;
				 dao = new Dao();
				 rs = dao.execute("SELECT product_id FROM stock WHERE count = "+ drink +" ;");
				 while(rs.next()){
					 productId = rs.getInt("product_id");
				 }

				 int cnt = 0;
				 dao = new Dao();
				 rs = dao.execute("SELECT COUNT(*) FROM earnings;");
				 while(rs.next()){
				      cnt = rs.getInt("COUNT(*)");
				 }
				 cnt += 1;

				 System.out.println(5);

				 dao = new Dao();
				 dao.executeUpdate("INSERT INTO earnings(id, date, member_id, product_id, vending_id)VALUES('"+ cnt +"','"+ r.getDate() +"','"+MEMBER_ID +"','"+ productId +"','1');");

				 //在庫を減少
				 dao = new Dao();
				 dao.executeUpdate("UPDATE stock SET stock = stock - 1 WHERE count = '" + drink + "';");

				 System.out.println(r.getChange());
				session.setAttribute("CHANGE", r.getChange());

			 }else{
				 System.out.println("未購入");

				System.out.println(r.getCoin());
				session.setAttribute("COIN", r.getCoin());
				fileJsp = "/machine.jsp";

			 }
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

		request.setAttribute("BILLING",r);
		RequestDispatcher rd=request.getRequestDispatcher(fileJsp);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
