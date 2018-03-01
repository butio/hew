package earnings;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Dao.Dao;

public class Earnings {






	/**
	 * 商品毎の売り上げを二次元配列にして返す。
	 * @return tbl
	 */
	public static ArrayList<ArrayList<String>> earningProduct(){
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		cl.add(Calendar.MONTH, -3);
		String strdate = (nowdate.format(cl.getTime()));
        strdate = (nowdate.format(cl.getTime()));
		String sql = "SELECT p.name, COUNT(*)" +
				" FROM earnings e" +
				" INNER JOIN product p ON p.id = e.product_id" +
				" INNER JOIN member m ON m.id = e.member_id" +
				" WHERE date >= '"+ strdate + "'" +
				" GROUP BY p.name" +
				" ORDER BY COUNT(*) DESC;";


		ArrayList<ArrayList<String>> tbl = new ArrayList<ArrayList<String>>();


		Dao Dao = null;
		ResultSet rs =null;
		try{
			System.out.println("Dao参照");
			Dao = new Dao();
			System.out.println("DB接続");

			rs = Dao.execute(sql);

			while(rs.next()){
				ArrayList<String>rec = new ArrayList<String>();

				rec.add(rs.getString("p.name"));
				rec.add(rs.getString("COUNT(*)"));
				tbl.add(rec);


			}

		}catch(Exception e){
			System.out.println("Exception");
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				Dao.close();
			}
			catch(Exception e){

			}

		}
		System.out.println(sql);
		return tbl;

	}



	public static ArrayList<ArrayList<String>> earningFixeddateProduct(String date,String date2){

		String sql = "";


		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = (nowdate.format(cl.getTime()));
		if(!date.equals("") && !date2.equals("")){
			sql = "SELECT p.name, COUNT(*)" +
			" FROM earnings e" +
			" INNER JOIN product p ON p.id = e.product_id" +
			" INNER JOIN member m ON m.id = e.member_id" +
			" WHERE date >= '"+ date + "' AND date < '" + date2 +"'" +
			" GROUP BY p.name" +
			" ORDER BY COUNT(*) DESC;";
		}else if(!date.equals("") && date2.equals("")){

			sql = "SELECT p.name, COUNT(*)" +
			" FROM earnings e" +
			" INNER JOIN product p ON p.id = e.product_id" +
			" INNER JOIN member m ON m.id = e.member_id" +
			" WHERE date >= '"+ date + "' AND <='"+ strdate +"'" +
			" GROUP BY p.name" +
			" ORDER BY COUNT(*) DESC;";

		}else if(date.equals("") && !date2.equals("")){
			sql = "SELECT p.name, COUNT(*)" +
			" FROM earnings e" +
			" INNER JOIN product p ON p.id = e.product_id" +
			" INNER JOIN member m ON m.id = e.member_id" +
			" WHERE date <= '" + date2 +"'" +
			" GROUP BY p.name" +
			" ORDER BY COUNT(*) DESC;";

		}


		ArrayList<ArrayList<String>> tbl = new ArrayList<ArrayList<String>>();


		Dao Dao = null;
		ResultSet rs =null;
		try{
			System.out.println("Dao参照");
			Dao = new Dao();
			System.out.println("DB接続");

			rs = Dao.execute(sql);

			while(rs.next()){
				ArrayList<String>rec = new ArrayList<String>();

				rec.add(rs.getString("p.name"));
				rec.add(rs.getString("COUNT(*)"));
				tbl.add(rec);


			}

		}catch(Exception e){
			System.out.println("Exception");
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				Dao.close();
			}
			catch(Exception e){

			}

		}
		System.out.println(sql);
		return tbl;

	}




	/**
	 * 商品毎の売り上げを二次元配列にして返す。
	 * @param 日付指定
	 * @return tbl
	 */

	public static ArrayList<ArrayList<String>> earningVendingProduct(String vending_ID){
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		cl.add(Calendar.MONTH, -3);
		String strdate = (nowdate.format(cl.getTime()));
        strdate = (nowdate.format(cl.getTime()));
		String sql = "SELECT p.name, COUNT(*)" +
				" FROM earnings e" +
				" INNER JOIN vending v ON v.id = e.vending_id" +
				" INNER JOIN product p ON p.id = e.product_id" +
				" INNER JOIN member m ON m.id = e.member_id" +
				" WHERE v.id = '"+ vending_ID +"'" +
				" AND date >= '"+ strdate + "'" +
				" GROUP BY p.name" +
				" ORDER BY COUNT(*) DESC;";



		ArrayList<ArrayList<String>> tbl = new ArrayList<ArrayList<String>>();



		Dao Dao = null;
		ResultSet rs =null;
		try{
			System.out.println("Dao参照");
			Dao = new Dao();
			System.out.println("DB接続");

			rs = Dao.execute(sql);

			while(rs.next()){
				ArrayList<String>rec = new ArrayList<String>();

				rec.add(rs.getString("p.name"));
				rec.add(rs.getString("COUNT(*)"));
				tbl.add(rec);

			}

		}catch(Exception e){
			System.out.println("Exception");
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				Dao.close();
			}
			catch(Exception e){

			}

		}
		System.out.println(sql);
		return tbl;

	}
	public static ArrayList<ArrayList<String>> earningVendingFixeddateProduct(String vending_ID,String date,String date2){
		String sql ="";
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = (nowdate.format(cl.getTime()));
			if(!date.equals("") && !date2.equals("")){
				sql = "SELECT p.name, COUNT(*)" +
					" FROM earnings e" +
					" INNER JOIN vending v ON v.id = e.vending_id" +
					" INNER JOIN product p ON p.id = e.product_id" +
					" INNER JOIN member m ON m.id = e.member_id" +
					" WHERE v.id = '"+ vending_ID +"'" +
					" AND date >= '"+ date + "' AND date < '" + date2 +"'" +
					" GROUP BY p.name" +
					" ORDER BY COUNT(*) DESC;";
			}else if(!date.equals("") && date2.equals("")){
				sql = "SELECT p.name, COUNT(*)" +
						" FROM earnings e" +
						" INNER JOIN product p ON p.id = e.product_id" +
						" INNER JOIN member m ON m.id = e.member_id" +
						" WHERE v.id = '"+ vending_ID +"'" +
						" AND date <= '"+ date + "' AND date <='"+ strdate +"'" +
						" GROUP BY p.name" +
						" ORDER BY COUNT(*) DESC;";

			}else if(date.equals("") && !date2.equals("")){
				sql = "SELECT p.name, COUNT(*)" +
						" FROM earnings e" +
						" INNER JOIN product p ON p.id = e.product_id" +
						" INNER JOIN member m ON m.id = e.member_id" +
						" WHERE v.id = '"+ vending_ID +"'" +
						" AND date <= '" + date2 +"'" +
						" GROUP BY p.name" +
						" ORDER BY COUNT(*) DESC;";

	}





		ArrayList<ArrayList<String>> tbl = new ArrayList<ArrayList<String>>();



		Dao Dao = null;
		ResultSet rs =null;
		try{
			System.out.println("Dao参照");
			Dao = new Dao();
			System.out.println("DB接続");

			rs = Dao.execute(sql);

			while(rs.next()){
				ArrayList<String>rec = new ArrayList<String>();

				rec.add(rs.getString("p.name"));
				rec.add(rs.getString("COUNT(*)"));
				tbl.add(rec);

			}

		}catch(Exception e){
			System.out.println("Exception");
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				Dao.close();
			}
			catch(Exception e){

			}

		}
		System.out.println(sql);
		return tbl;

	}

	public static ArrayList<ArrayList<String>> earningAreaProduct(String area){
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		cl.add(Calendar.MONTH, -3);
		String strdate = (nowdate.format(cl.getTime()));
        strdate = (nowdate.format(cl.getTime()));
		String sql = "SELECT p.name, COUNT(*)" +
				" FROM earnings e" +
				" INNER JOIN vending v ON v.id = e.vending_id" +
				" INNER JOIN product p ON p.id = e.product_id" +
				" INNER JOIN member m ON m.id = e.member_id" +
				" WHERE area_id = "+ area +"" +
				" AND date >= '"+ strdate + "'" +
				" GROUP BY p.name" +
				" ORDER BY COUNT(*) DESC;";



		ArrayList<ArrayList<String>> tbl = new ArrayList<ArrayList<String>>();



		Dao Dao = null;
		ResultSet rs =null;
		try{
			System.out.println("Dao参照");
			Dao = new Dao();
			System.out.println("DB接続");

			rs = Dao.execute(sql);

			while(rs.next()){
				ArrayList<String>rec = new ArrayList<String>();

				rec.add(rs.getString("p.name"));
				rec.add(rs.getString("COUNT(*)"));
				tbl.add(rec);

			}

		}catch(Exception e){
			System.out.println("Exception");
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				Dao.close();
			}
			catch(Exception e){

			}

		}
		System.out.println(sql);
		return tbl;

	}


	public static ArrayList<ArrayList<String>> earningAreaFixeddateProduct(String area,String date,String date2){

		String sql = "";
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = (nowdate.format(cl.getTime()));


		if(!date.equals("") && !date2.equals("")){
			sql = "SELECT p.name, COUNT(*)" +
				" FROM earnings e" +
				" INNER JOIN vending v ON v.id = e.vending_id" +
				" INNER JOIN product p ON p.id = e.product_id" +
				" INNER JOIN member m ON m.id = e.member_id" +
				" WHERE area_id = '"+ area +"'" +
				" AND date >= '"+ date + "' AND date < '" + date2 +"'" +
				" GROUP BY p.name" +
				" ORDER BY COUNT(*) DESC;";
		}else if(!date.equals("") && date2.equals("")){
			sql = "SELECT p.name, COUNT(*)" +
					" FROM earnings e" +
					" INNER JOIN product p ON p.id = e.product_id" +
					" INNER JOIN member m ON m.id = e.member_id" +
					" WHERE v.id = '"+ area +"'" +
					" AND date <= '"+ date + "' AND date <='"+ strdate +"'" +
					" GROUP BY p.name" +
					" ORDER BY COUNT(*) DESC;";

		}else if(date.equals("") && !date2.equals("")){
			sql = "SELECT p.name, COUNT(*)" +
					" FROM earnings e" +
					" INNER JOIN product p ON p.id = e.product_id" +
					" INNER JOIN member m ON m.id = e.member_id" +
					" WHERE v.id = '"+ area +"'" +
					" AND date <= '" + date2 +"'" +
					" GROUP BY p.name" +
					" ORDER BY COUNT(*) DESC;";

}


		ArrayList<ArrayList<String>> tbl = new ArrayList<ArrayList<String>>();



		Dao Dao = null;
		ResultSet rs =null;
		try{
			System.out.println("Dao参照");
			Dao = new Dao();
			System.out.println("DB接続");

			rs = Dao.execute(sql);

			while(rs.next()){
				ArrayList<String>rec = new ArrayList<String>();

				rec.add(rs.getString("p.name"));
				rec.add(rs.getString("COUNT(*)"));
				tbl.add(rec);

			}

		}catch(Exception e){
			System.out.println("Exception");
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				Dao.close();
			}
			catch(Exception e){

			}

		}
		System.out.println(sql);
		return tbl;

	}




}
