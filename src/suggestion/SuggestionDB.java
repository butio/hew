package suggestion;

public class SuggestionDB {
	private String	imgFile;
	private String	state;
	private String  stateCss;
	private int price;
	private int count;

	public SuggestionDB(){
	}

	public void setCount(int _count){
		this.count = _count;
	}

	public void setImg(String _imgFile){
		this.imgFile = _imgFile;
	}

	public void setState(int _state){
		if(_state == 1){
			this.state = "つめた～い";
			this.stateCss = "cold";
		}else if(_state == 2){
			this.state = "あたたか～い";
			this.stateCss = "hot";
		}
	}

	public void setPrice(int _price){
		this.price = _price;
	}

	public int getCount(){
	    return this.count;
	}

	public String getImg(){
	    return this.imgFile;
	}

	public String getState(){
	    return this.state;
	}

	public String getStateCss(){
		return this.stateCss;
	}

	public int getPrice(){
	    return this.price;
	}

}
