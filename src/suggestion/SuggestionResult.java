package suggestion;

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
 * Servlet implementation class SuggestionResult
 */
@WebServlet("/SuggestionResult")
public class SuggestionResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestionResult() {
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
		String sql = "";

		ArrayList<SuggestionDB> arrayList=new ArrayList<SuggestionDB>();
		Dao dao = null;
		ResultSet rs = null;
		try{

			sql ="SELECT suggestion.count,product.image,suggestion.state,suggestion.price " +
					" FROM suggestion " +
					" INNER JOIN product ON suggestion.product_id = product.id " +
					" INNER JOIN area ON suggestion.area_id = area.id" +
					" WHERE area.id = "+area+" ORDER BY count ASC ;";

			dao = new Dao();
			rs = dao.execute(sql);
			while(rs.next()){
				SuggestionDB s = new SuggestionDB();
				s.setCount(rs.getInt("suggestion.count"));
				s.setImg(rs.getString("product.image"));
				s.setState(rs.getInt("suggestion.state"));
				s.setPrice(rs.getInt("suggestion.price"));
				arrayList.add(s);
			}

			request.setAttribute("RESULT",arrayList);
			RequestDispatcher rd=request.getRequestDispatcher("/SuggestionResult.jsp");
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
