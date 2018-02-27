
package userapp;

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
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
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

		User u = new User();
		u.setAge((String)request.getParameter("age"));
		String sex =request.getParameter("sex");
		String strJspName = "./machine.jsp";
		String sqlcnt="SELECT COUNT(*) FROM member;";

		 Dao dao = null;
		 ResultSet rs = null;

		 try{
				int cnt=0;

				 dao = new Dao();
				 rs = dao.execute(sqlcnt);
				 while(rs.next()){
			       cnt=rs.getInt("COUNT(*)");
				 }
				 cnt += 1;
				 session.setAttribute("MEMBER_ID",cnt);

				 String sql = "INSERT INTO member(id,birthyear,birthmonth,birthday,sex) " +
						"VALUES('"+cnt+"', '"+u.getBirthyear()+"', '"+u.getBirthmonth()+"', '"+u.getBirthday()+"', '"+sex+"');";

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
			RequestDispatcher rd=request.getRequestDispatcher(strJspName);
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
