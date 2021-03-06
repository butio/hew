package suggestion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageVending.Area;

/**
 * Servlet implementation class Suggestion
 */
@WebServlet("/Suggestion")
public class Suggestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suggestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		ArrayList<ArrayList<String>> AreaList = new ArrayList<ArrayList<String>>();


		String Choise = "エリア";
		String ChoisePrice = ("area");

		AreaList = Area.AreaList();

		request.setAttribute("Choise",Choise);
		request.setAttribute("ChoisePrice",ChoisePrice);
		request.setAttribute("Result",AreaList);

		RequestDispatcher rd = request.getRequestDispatcher("/Suggestion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
