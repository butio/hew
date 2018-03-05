package restocking;

public class RestockingDB {
	private String areaPlace;
	private String place;
	private String productName;
	private int price;
	private	int stock;
	private int stock_Cnt;
	private	int maxStock;
	private int vendingId;
	private int count;
	private String receiptdate;
	boolean nullFlg;

	public RestockingDB(){
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

	public void setVendingId(int _vendingId){
		this.vendingId = _vendingId;
	}

	public void setCount(int _count){
		this.count = _count;
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

	public int getStockCnt(){
		this.stock_Cnt = maxStock - stock;
		return this.stock_Cnt;
	}

	public int getMaxStock(){
		return this.maxStock;
	}

	public int getVendingId(){
		return this.vendingId;
	}

	public int getCount(){
		return this.count;
	}

	public String getReceiptdate(){
		return this.receiptdate;
	}
}
