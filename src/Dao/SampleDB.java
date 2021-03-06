package Dao;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		int vendingId = 3;
		int MEMBER_ID = 164;
		int drink = 0;
		int EARNINGS＿ID = 0;
		String sql = "";

		Dao dao = null;
		ResultSet rs = null;


		try{

			for(int i=0;i<100;i++){
			drink = (int) (Math.floor(Math.random() * (1 - 12 + 1)) + 12) ;
			int productID = 0;
			dao = new Dao();
			rs = dao.execute("SELECT product_id FROM stock WHERE vending_id ="+vendingId+" ORDER BY RAND() LIMIT 1;");
			while(rs.next()){
				productID = rs.getInt("product_id");
			}
			dao = new Dao();
			rs = dao.execute("SELECT COUNT(*) FROM earnings;");
			while(rs.next()){
				EARNINGS＿ID = rs.getInt("COUNT(*)");
			}
			EARNINGS＿ID += 1;
			System.out.println(EARNINGS＿ID);
			sql = ("INSERT INTO earnings(id, date, member_id, product_id, vending_id, stock_count)" +
					"VALUES('"+ EARNINGS＿ID +"','2018/03/07 19:16:06','"+MEMBER_ID +"','"+ productID +"','"+vendingId+"','"+drink+"');");
			dao = new Dao();
			dao.executeUpdate(sql);
			}
			System.out.println("成功");
		}catch(Exception e){
			System.out.println("エラー");
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
