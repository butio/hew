package earnings;

import java.sql.ResultSet;
import java.util.ArrayList;

import Dao.Dao;

public class Earnings {


	/**
	 * 商品毎の売り上げを二次元配列にして返す。
	 * @return tbl
	 */
	public static ArrayList<ArrayList<String>> earningProduct(){
		String sql = "SELECT p.name, COUNT(*)" +
				" FROM earnings e" +
				" INNER JOIN product p ON p.id = e.product_id" +
				" INNER JOIN member m ON m.id = e.member_id" +
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

	/**
	 * 商品毎の売り上げを二次元配列にして返す。
	 * @param 日付指定
	 * @return tbl
	 */

	public static ArrayList<ArrayList<String>> earningVendingProduct(String vending_ID){
		String sql = "SELECT p.name, COUNT(*)" +
				" FROM earnings e" +
				" INNER JOIN vending v ON v.id = e.vending_id" +
				" INNER JOIN product p ON p.id = e.product_id" +
				" INNER JOIN member m ON m.id = e.member_id" +
				" WHERE v.id = '"+ vending_ID +"'" +
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
	public static ArrayList<ArrayList<String>> earningAreaProduct(String area){
		String sql = "SELECT p.name, COUNT(*)" +
				" FROM earnings e" +
				" INNER JOIN vending v ON v.id = e.vending_id" +
				" INNER JOIN product p ON p.id = e.product_id" +
				" INNER JOIN member m ON m.id = e.member_id" +
				" WHERE area_id = "+ area +"" +
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




}
