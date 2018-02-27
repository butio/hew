package vendingmachine;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Billing {

	private int coin;
	private int price;
	private int change;
	private String errCoin;
	private String date;
	boolean errFlg;
	boolean changeFlg;

	public Billing(){
		this.change = 0;
		this.price = 0;
		this.coin = 0;
		this.errCoin = "";
		this.date = "";
	}

	//setter
	public void setDBPrice(int _price){
		this.price = _price;
	}

	public void setChange(int _coin ,int _price){
		if(_coin >= _price){
			this.change = _coin - _price;
			if(change == 0){
				this.changeFlg = true;
			}
			this.errFlg = true;
		}else{
			this.coin = _coin;
			this.errCoin = "金額が足りません";
			this.errFlg = false;
		}
	}

	//ドリンクの料金
	public int getDBPrice(){
    	return this.price;
    }

	//現在の日付の取得
	public String getDate(){
	    Date d = new Date();
	    SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    String c1 = d1.format(d);
	    this.date = c1;
	    return this.date;
	}

	//エラーの場合値を保持させるためのgetter
    public int getCoin(){
    	return this.coin;
    }

    //エラーメッセージ
    public String getErrorCoin(){
    	return this.errCoin;
    }

    //エラーがあった場合遷移先を変更させるgetter
	public boolean getJsp(){
		return this.errFlg;
	}

	//エラーがあった場合遷移先を変更させるgetter
	public boolean getChangeFlg(){
		return this.changeFlg;
	}

    //おつり
    public int getChange(){
    	return this.change;
    }

}

