package vendingmachine;

public class ErrorCheck {

	//入力欄の空白チェック
	public static boolean isCheck(String input){
	if(input.equals("")){
	return false;
	}
	return true;
	}

	//入力された値が数値かどうか
	public static boolean isNameric(String number) {
	    try {
	        Integer.parseInt(number);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	//桁数が4～8以外はエラー
	public static boolean isLength(String str){
		if(2 <= str.length() && 4 >= str.length()){
			int len = str.length();
			int digit = Integer.parseInt(str.substring(len - 1, len));
			if(0 == digit){
				return true;
			}
			return false;
		}
		return false;
	}
}
