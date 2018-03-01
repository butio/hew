package earnings;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EarningVending
 */
@WebServlet("/EarningVending")
public class EarningVending extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EarningVending() {
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


		String jsp =("EarningTable.jsp");
		String choise = request.getParameter("choise");
		String action = request.getParameter("action");
		String select = request.getParameter("select");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year2 = request.getParameter("year2");
		String month2 = request.getParameter("month2");
		String day2 = request.getParameter("day2");
		String date ="";
		String date2 ="";


		if(year != null){
			date = year;
			if(!month.equals("")){
				date= date += ("-");
				date= date += (month);
				date= date += ("-");
				date= date += (day);
			}
		}
		System.out.println(date);

		if(year2 != null){
			date2 = year2;
			if(!month2.equals("")){
				date2= date2 += ("-");
				date2= date2 += (month2);
				date2= date2 += ("-");
				date2= date2 += (day2);
			}
		}
		System.out.println(date2);




		if(!action.equals("chart")){

		ArrayList<ArrayList<String>> EarningList = new ArrayList<ArrayList<String>>();

		System.out.println(select);
		System.out.println(choise);
		if(choise == null){
			if(date.equals("") && date2.equals("")){
				System.out.println("");
				EarningList = Earnings.earningProduct();
			}else{
				EarningList = Earnings.earningFixeddateProduct(date,date2);
			}
		}else if(choise.equals("vending")){
			if(date.equals("") && date2.equals("")){
				System.out.println("");
				EarningList = Earnings.earningVendingProduct(select);
			}else{
				EarningList = Earnings.earningVendingFixeddateProduct(select,date,date2);
			}
		}else if(choise.equals("area")){
			if(date.equals("") && date2.equals("")){
				System.out.println("");
				EarningList = Earnings.earningAreaProduct(select);
			}else{
				EarningList = Earnings.earningAreaFixeddateProduct(select,date,date2);
			}
		}



		request.setAttribute("Result",EarningList);
		request.setAttribute("vending",select);


		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		}else{



		}




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
