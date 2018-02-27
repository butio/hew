package manageStock;

import java.sql.ResultSet;
import java.util.ArrayList;

import Dao.Dao;

public class LowerStockVending {

	public ArrayList<String> LowerStockVend;

	public LowerStockVending(String LowerLimitStock,String LowerLimitProduct){

//		在庫数が引数として取得した下限値を下回る商品が存在する
		String sql = "SELECT DISTINCT v.id" +
				"FROM stock s" +
				"INNER JOIN vending v ON s.vending_id = v.id " +
				"AND s.stock <= "+ LowerLimitStock +"" +
				"HAVING COUNT(*) >= "+ LowerLimitProduct +";";

		Dao Dao = null;
		ResultSet rs =null;
		try{
			System.out.println("Dao参照");
			Dao = new Dao();
			System.out.println("DB接続");

			rs = Dao.execute(sql);

			while(rs.next()){

				this.LowerStockVend.add(rs.getString("id"));

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
	}




}
