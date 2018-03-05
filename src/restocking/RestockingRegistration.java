package restocking;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Dao;

/**
 * Servlet implementation class RestockingRegistration
 */
@WebServlet("/RestockingRegistration")
public class RestockingRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestockingRegistration() {
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

		Tool t = new Tool();
		String VENDING_ID = (String)session.getAttribute("VENDING_ID");

		Enumeration<String> en = request.getParameterNames();
		while ( en.hasMoreElements() ) {
			String stockCnt = (String) en.nextElement();
			String sql ="";

			Dao dao = null;
			ResultSet rs = null;

			try{

				sql = "UPDATE stock SET stock=stock+"+request.getParameter(stockCnt)+",receiptdate="+t.getDate()+"" +
						" WHERE vending_id="+VENDING_ID+""+
						" AND count="+stockCnt+";";

				dao = new Dao();
				dao.executeUpdate(sql);

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

		RequestDispatcher rd=request.getRequestDispatcher("./VendingMachineStock?vendingMachineID="+VENDING_ID+"");
		rd.forward(request, response);
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
