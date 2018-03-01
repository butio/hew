package stock;

public class StockDB {
	private String areaPlace;
	private String place;
	private String productName;
	private int price;
	private	int stock;
	private	int maxStock;
	private String receiptdate;

	public StockDB(){
		this.areaPlace = "";
		this.place = "";
		this.productName = "";
		this.price = 0;
		this.stock = 0;
		this.maxStock = 0;
		this.receiptdate = "";
	}

	public void setArea(String _area){
		this.areaPlace = _area;
	}

	public void setPlace(String _place){
		this.place = _place;
	}

	public void setProductName(String _productName){
		this.productName = _productName;
	}

	public void setPrice(int _price){
		this.price = _price;
	}

	public void setStock(int _stock){
		this.stock = _stock;
	}

	public void setMaxStock(int _maxStock){
		this.maxStock = _maxStock;
	}

	public void setReceiptdate(String _receiptdate){
		this.receiptdate = _receiptdate;
	}


	public String getArea(){
	    return this.areaPlace;
	}

	public String getPlace(){
	    return this.place;
	}

	public String getProductName(){
	    return this.productName;
	}

	public int getPrice(){
	    return this.price;
	}

	public int getStock(){
		return this.stock;
	}

	public int getMaxStock(){
		return this.maxStock;
	}

	public String getReceiptdate(){
		return this.receiptdate;
	}




}
