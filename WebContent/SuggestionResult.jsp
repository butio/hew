<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="suggestion.SuggestionDB"%>
<%
ArrayList<SuggestionDB> arrayList= (ArrayList<SuggestionDB>) request.getAttribute("RESULT");
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
	//-->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style=Type" content="text/css;">
<link href="css/style.css" rel="stylesheet" type="text/css" >
<title>自販機</title>
</head>
<body>

		<table class="product" border=1>
			<%
				for (int max = 0; max < 12;) {
			%>
				<tr>
				<%
					for (int side = 0; side < 6; side++,max++) {
						SuggestionDB v = arrayList.get(max);
						        arrayList.get(max).getImg();
						        arrayList.get(max).getStateCss();
						        arrayList.get(max).getState();
						        arrayList.get(max).getCount();
						        arrayList.get(max).getPrice();
				%>
								<td>
								<img src="image/<%=v.getImg()%>" class="img">
								<div class="<%=v.getStateCss()%>"><p id="btn_price"><%=v.getState()%></p></div>
								<p><button id="btn" type='submit' name='drink' value='<%=v.getCount()%>'class="button3 rad1"  ><%=v.getPrice()%></button></p>
					<%}%>
				</tr>
			<%}%>
		</table>

		<br>
		<img class="koukoku"src="image/koukoku.png">

		<div id="price">
 	<input id="textCoin" name="coin" value=""  type="number" class="price" min="0" max="1000" step="10" onInput="checkForm(this)"  required="required" >

</div>

</body>
</html>