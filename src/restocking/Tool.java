package restocking;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {
	private String date;

	public Tool(){

	}

	//現在の日付の取得
	public String getDate(){
	    Date d = new Date();
	    SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMdd");
	    String c1 = d1.format(d);
	    this.date = c1;
	    return this.date;
	}

}
