package Chart;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Dao.Dao;

public class ChartMake {

	public static ArrayList<ArrayList<String>> BarChartProduct(String product_ID){
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		cl.add(Calendar.MONTH, -3);
		String strdate = (nowdate.format(cl.getTime()));
        strdate = (nowdate.format(cl.getTime()));
		String sql = "select product.id,product.name,year(earnings.date),month(earnings.date),count(earnings.product_id) from earnings" +
				" inner join stock on earnings.vending_id = stock.vending_id and earnings.stock_count = stock.count" +
				" inner join product on earnings.product_id = product.id" +
				" inner join vending on stock.vending_id = vending.id" +
				" inner join category on product.category_id = category.id" +
				" inner join area on vending.area_id = area.id" +
				" Where product.id = '"+ product_ID + "'" +
				" AND date >= '"+ strdate + "'" +
				" group by year(earnings.date),month(earnings.date),product.id;" ;


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


	public static ArrayList<ArrayList<String>> BarChartProductVending(String product_ID,String vending_ID){
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		cl.add(Calendar.MONTH, -3);
		String strdate = (nowdate.format(cl.getTime()));
        strdate = (nowdate.format(cl.getTime()));
		String sql = "select product.id,product.name,year(earnings.date),month(earnings.date),count(earnings.product_id) from earnings" +
				" inner join stock on earnings.vending_id = stock.vending_id and earnings.stock_count = stock.count" +
				" inner join product on earnings.product_id = product.id" +
				" inner join vending on stock.vending_id = vending.id" +
				" inner join category on product.category_id = category.id" +
				" inner join area on vending.area_id = area.id" +
				" Where vending.id = '" + vending_ID + "'" +
				" AND product.id = '"+ product_ID + "'" +
				" AND date >= '"+ strdate + "'" +
				" group by year(earnings.date),month(earnings.date),product.id;" ;


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



	public static ArrayList<ArrayList<String>> BarChartProductArea(String product_ID,String area_ID){
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd");
		cl.add(Calendar.MONTH, -3);
		String strdate = (nowdate.format(cl.getTime()));
        strdate = (nowdate.format(cl.getTime()));
		String sql = "select product.id,product.name,year(earnings.date),month(earnings.date),count(earnings.product_id) from earnings" +
				" inner join stock on earnings.vending_id = stock.vending_id and earnings.stock_count = stock.count" +
				" inner join product on earnings.product_id = product.id" +
				" inner join vending on stock.vending_id = vending.id" +
				" inner join category on product.category_id = category.id" +
				" inner join area on vending.area_id = area.id" +
				" Where area.id = '" + area_ID + "'" +
				" AND product.id = '"+ product_ID + "'" +
				" AND date >= '"+ strdate + "'" +
				" group by year(earnings.date),month(earnings.date),product.id;" ;


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
