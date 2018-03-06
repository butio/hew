package Dao;

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

import vendingmachine.getVendingDB;

/**
 * Servlet implementation class SampleDB
 */
@WebServlet("/SampleDB")
public class SampleDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);

		Dao dao = null;
		ResultSet rs = null;

		ArrayList<getVendingDB> arrayList=new ArrayList<getVendingDB>();

		try{
			//x 以上 y 以下のランダムな整数 w を取得したい場合
			int birthyear = 0;
			birthyear = (int) (Math.floor(Math.random() * (1900 - 2000 + 1)) + 2000) ;

			int birthmonth = 0;
			birthmonth = (int) (Math.floor(Math.random() * (1 - 12 + 1)) + 12) ;

			int birthday = 0;
			birthday = (int) (Math.floor(Math.random() * (1 - 31 + 1)) + 31) ;

			int sex = 0;
			sex = (int) (Math.random() * 2 + 1) ;

			String sqlcnt="SELECT COUNT(*) FROM member;";
			int cnt=0;
			dao = new Dao();
			rs = dao.execute(sqlcnt);
			while(rs.next()){
				cnt=rs.getInt("COUNT(*)");
			}
			cnt += 1;

			String sql = "INSERT INTO member(id,birthyear,birthmonth,birthday,sex) " +
					"VALUES('"+cnt+"', '"+birthyear+"', '"+birthmonth+"', '"+birthday+"', '"+sex+"');";

			dao = new Dao();
			dao.executeUpdate(sql);

			String vendingId = "1";
			session.setAttribute("MEMBER_ID",cnt);
			session.setAttribute("VENDING_ID",vendingId);

			sql = "SELECT count,image,state,price FROM stock INNER JOIN product ON stock.product_id = product.id WHERE vending_id = '"+ vendingId +"' ORDER BY count ASC ;";

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
			RequestDispatcher dispatch = request.getRequestDispatcher("/machine.jsp");
			dispatch.forward(request, response);
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
