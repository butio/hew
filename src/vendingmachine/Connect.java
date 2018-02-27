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

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String vendingID = request.getParameter("vendingMachineID");
		System.out.println(vendingID);

		ArrayList<ArrayList<String>> tbl=new ArrayList<ArrayList<String>>();
		 Dao dao = null;
		 ResultSet rs = null;
		 try{
			 String sql = "SELECT count,name FROM stock INNER JOIN product ON stock.product_id = product.id WHERE vending_id = '"+ vendingID +"' ORDER BY count ASC ;";

			 dao = new Dao();
			 rs = dao.execute(sql);
			 while(rs.next()){
				 ArrayList<String> rec=new ArrayList<String>();
				 rec.add(rs.getString("count"));
				 rec.add(rs.getString("name"));
				 tbl.add(rec);
			 }

			 request.setAttribute("RESULT",tbl);
			 RequestDispatcher rd=request.getRequestDispatcher("/machineSample.jsp");
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
