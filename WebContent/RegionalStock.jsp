<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<%
String Choise = (String)request.getAttribute("Choise");
String ChoisePrice = (String)request.getAttribute("ChoisePrice");
ArrayList<ArrayList<String>> aryTable = (ArrayList<ArrayList<String>>) request.getAttribute("Result");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<link rel="stylesheet" type="text/css" href="./css/reset.css">
<title>自販機・エリア</title>
</head>
<body>
	<form name="Vending" method="get" action="./SelectVendingServlet">
	</form>
	<form name="Area" method="get" action="./SelectArea""></form>
	<form name="All" method="get" action="./EarningVending"">
		<input type="hidden" name="action" value="table">
	</form>
	<form name="Stock" method="get" action="./StockCall"></form>
	<div id="wrapper">
		<div id="header">
			<ul>
				<li class="title"><a href="AdminTop.jsp">自動販売機管理システム</a></li>
				<li class="machine"><a href="#"
					onClick="document.Vending.submit();">自販機</a></li>
				<li class="area"><a href="#" onClick="document.Area.submit();">エリア</a></li>
				<li class="all"><a href="#" onClick="document.All.submit();">全体</a>
				<li class="stock"><a href="./StockCall"
					onClick="document.Stock.submit();">在庫</a></li>
			</ul>
		</div>
		<h3 class="infomation">
			情報を参照する<%=Choise%>を選択してください。
		</h3>
		<form action="./RegionalStockResult" method="get">
			<center class="jihanki">
				<select name="select" class="design">
					<%
						for (ArrayList<String> rec : aryTable) {
					%>
					<%
						int cnt = 0;
					%>
					<%
						for (String data : rec) {
					%>
					<%
						if (cnt == 0) {
					%>
					<option value="<%=data%>">
						<%
							cnt = 1;
						%>
						<%
							} else {
						%>
						<%=data%></option>
					<%
						}
					%>
					<%
						}
					%>
					<%
						}
					%>
				</select>
			</center>
			<center class="jihanki">
				<button class="button" type="submit" name="action" value="1">地域ボーダーを超えていて、自販機ボーダーを切っている商品</button>
				<button class="button" type="submit" name="action" value="2">自動販売機ボーダーを超えていて、地域ボーダーを切っている商品</button>
			</center>
		</form>
					<center class="jihanki">
				<button class="button"  onclick="location.href='AdminTop.jsp'">戻る</button>
				</center>

		<div id="footer">
			<p class="copy">copyright(C) 2018</p>
		</div>
	</div>
</body>
</html>
