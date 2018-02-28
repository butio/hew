<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vendingmachine.getVendingDB"%>
<%
ArrayList<getVendingDB> arrayList= (ArrayList<getVendingDB>) request.getAttribute("RESULT");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<script type="text/javascript">
	<!--
	function checkForm($this)
	{
	    var str=$this.value;
	    while(str.match(/[^A-Z^a-z\d\-]/))
	    {
	        str=str.replace(/[^A-Z^a-z\d\-]/,"");
	    }
	    $this.value=str;
	}

	function btn(){
	//名前と感想の欄のテキストを変数に代入する
		var coin = document.getElementByClassName("price").value;
		var price = document.getElementsByClassName("button3 rad1");
		coin = Number(coin);
		price = Number(price);

		if(coin >= price){
			btn.value = '押せる';
            btn.removeAttribute('disabled');
        } else {
            btn.value = '押せない';
            btn.setAttribute('disabled', 'disabled');
        }

	}
//-->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style=Type" content="text/css;">
<link href="css/style.css" rel="stylesheet" type="text/css" >
<title>自販機</title>
</head>
<body>

<form name="machine" action="./Purchase" method="get">

		<table class="product" border=1>
			<%
				for (int max = 0; max < 12;) {
			%>
				<tr>
				<%
					for (int side = 0; side < 6; side++,max++) {
						getVendingDB v = arrayList.get(max);
						        arrayList.get(max).getImg();
						        arrayList.get(max).getStateCss();
						        arrayList.get(max).getState();
						        arrayList.get(max).getCount();
						        arrayList.get(max).getPrice();
				%>
								<td>
								<img src="image/<%=v.getImg()%>">
								<div class="<%=v.getStateCss()%>"><p><%=v.getState()%></p></div>
								<p><button type='submit' name='drink' value='<%=v.getCount()%>'class="button3 rad1" disabled="disabled"><%=v.getPrice()%></button></p>
								</td>
					<%}%>
				</tr>
			<%}%>
		</table>

		<br>
		<img class="koukoku"src="image/koukoku.png">

		<div id="price">
 	<input name="coin" value=""  type="number" class="price" min="0" max="1000" step="10" onInput="checkForm(this)" required="required" >
</div>

</form>
</body>
</html>