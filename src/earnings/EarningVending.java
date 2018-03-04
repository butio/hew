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


		String jsp =("EarningTable.jsp");
		String choise = request.getParameter("choise");
		String action = request.getParameter("action");
		String select = request.getParameter("select");
		String age = request.getParameter("Age");
		String sex = request.getParameter("sex");

		String year = request.getParameter("year");
		int intyear = 0;
		int intyear2 = 0;
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year2 = request.getParameter("year2");
		String month2 = request.getParameter("month2");
		String day2 = request.getParameter("day2");
		String date = "";
		String date2 = "";
		String Message = ("");



		ArrayList<ArrayList<String>> EarningList = new ArrayList<ArrayList<String>>();


		System.out.println(action);
		System.out.println(select);
		System.out.println(choise);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(year2);
		System.out.println(month2);
		System.out.println(day2);

		if((year != "" && month != "" && day !="") || (year != "" && month == "" && day =="")){
			if(year != null){
				date = year;
				if(year2 == "" && month =="" && day ==""){
					intyear= Integer.parseInt(year) - 1;
					year = Integer.toString(intyear);
					date= year;
					date= date += ("-");
					date= date += ("12");
					date= date += ("-");
					date= date += ("31");
				}
				if(!month.equals("")){
					date= date += ("-");
					date= date += (month);
					date= date += ("-");
					date= date += (day);
				}
			}
		}else if(!(year == "" && month == "" && day =="")){
			Message = ("期間の選択形式が誤っています。期間の選択は反映せずに表示します。");
		}

		if((year2 != "" && month2 != "" && day2 !="") || (year2 != "" && month2 == "" && day2 =="")){
			if(year2 != null){
				date2 = year2;
				if(year == "" && month2 =="" && day2 ==""){
					intyear2= Integer.parseInt(year2) + 1;
					year2 = Integer.toString(intyear2);
					date2= year2;
					date2= date2 += ("-");
					date2= date2 += ("01");
					date2= date2 += ("-");
					date2= date2 += ("01");
				}
				if(!month2.equals("")){
					date2= date2 += ("-");
					date2= date2 += (month2);
					date2= date2 += ("-");
					date2= date2 += (day2);
				}
			}
		}else if(!(year2 == "" && month2 == "" && day2 =="")){
			Message = ("期間の選択形式が誤っています。期間の選択は反映せずに表示します。");
		}




		if(!action.equals("chart")){

		EarningList = new ArrayList<ArrayList<String>>();


		if(choise == null){
			if(date.equals("") && date2.equals("")){
				if((sex == "" && age == "") || (sex == null && age == null)){
				EarningList = Earnings.earningProduct();
				}else if(sex == "" && age != ""){
					EarningList = Earnings.earningAgeProduct(age);
				}else if(sex != "" && age == ""){
					EarningList = Earnings.earningSexProduct(sex);
				}
//				}else{
//					EarningList = Earnings.earningSexAgeProduct(sex);
//				}
			}else if(sex == "" && age == ""){
				EarningList = Earnings.earningFixeddateProduct(date,date2);
			}else if(sex == "" && age != ""){
				EarningList = Earnings.earningAgeFixeddateProduct(date,date2,age);
			}else if(sex != "" && age == ""){
				EarningList = Earnings.earningSexFixeddateProduct(date,date2,age);
			}
//			}else{
//				EarningList = Earnings.earningSexAgeFixeddateProduct(date,date2,age);
//			}
		}else if(choise.equals("vending")){
			if(date.equals("") && date2.equals("")){
				if((sex == "" && age == "") || (sex == null && age == null)){
				EarningList = Earnings.earningVendingProduct(select);
				}else if(sex == "" && age != ""){
					EarningList = Earnings.earningAgeVendingProduct(select,age);
				}else if(sex != "" && age == ""){
					EarningList = Earnings.earningSexVendingProduct(select,sex);
				}else{
					EarningList = Earnings.earningSexAgeVendingProduct(select,sex,age);
				}
			}else if(sex == "" && age == ""){
				EarningList = Earnings.earningVendingFixeddateProduct(select,date,date2);
			}else if(sex == "" && age != ""){
				EarningList = Earnings.earningAgeVendingFixeddateProduct(select,date,date2,age);
			}else if(sex != "" && age == ""){
				EarningList = Earnings.earningSexVendingFixeddateProduct(select,date,date2,sex);
			}else{
				EarningList = Earnings.earningSexAgeVendingFixeddateProduct(select,date,date2,sex,age);
			}

		}else if(choise.equals("area")){
			if(date.equals("") && date2.equals("")){
				if((sex == "" && age == "") || (sex == null && age == null)){
				EarningList = Earnings.earningAreaProduct(select);
				}else if(sex == "" && age != ""){
					EarningList = Earnings.earningAgeAreaProduct(select,age);
				}else if(sex != "" && age == ""){
					EarningList = Earnings.earningSexAreaProduct(select,sex);
				}else{
					EarningList = Earnings.earningSexAgeAreaProduct(select,sex,age);
				}

			}else if(sex == "" && age == ""){
				EarningList = Earnings.earningAreaFixeddateProduct(select,date,date2);
			}else if(sex == "" && age != ""){
				EarningList = Earnings.earningAgeAreaFixeddateProduct(select,date,date2,age);
			}else if(sex != "" && age == ""){
				EarningList = Earnings.earningSexAreaFixeddateProduct(select,date,date2,sex);
			}else{
				EarningList = Earnings.earningSexAgeAreaFixeddateProduct(select,date,date2,sex,age);
			}
		}



		System.out.println(Message);
		System.out.println(jsp);




		}else{

			jsp = "Chart.jsp";

			EarningList = new ArrayList<ArrayList<String>>();
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


		}
		Earnings E = new Earnings();

		E.setMes(Message);



		request.setAttribute("PieChart",EarningList);
		request.setAttribute("Result",EarningList);
		request.setAttribute("Error",E);
		request.setAttribute("select",select);



		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		doGet(request,response);

	}

}
