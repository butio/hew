package vendingmachine;

public class Turned {

	private int coin;
	private String errCoin;
	boolean errFlg;

	public Turned(){
		this.coin = 0;
		this.errCoin = "";
	}

	public void purchase(String _value,String _coin){
		if(!ErrorCheck.isCheck(_coin)){
			this.errCoin = "入力欄が空白です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isNameric(_coin)){
			this.errCoin = "数値のみ入力可能です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isLength(_coin)){
			this.errCoin = "入力した数値は正しくありません。";
			this.errFlg = true;
		}
		this.coin = Integer.parseInt(_coin);
	}

	//getter
	public int getCoin(){
		return this.coin;
	}

	 //エラーのgetter
    public String getErrName(){
    	return this.errCoin;
    }

}
