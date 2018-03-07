<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="stock.StockDB"%>
<%
ArrayList<StockDB> arrayList= (ArrayList<StockDB>) request.getAttribute("RESULT");
Integer cnt = (Integer)request.getAttribute("COUNT");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th { text-align: left; }
</style>
<meta charset="utf-8">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/stock.css">
<link rel="stylesheet" type="text/css" href="./css/reset.css">
<title>管理者画面</title>
</head>
<body>
	<form name="Vending" method="get" action="./SelectVendingServlet">
	</form>
	<form name="Area" method="get" action="./SelectArea"></form>
	<form name="All" method="get" action="./EarningVending">
		<input type="hidden" name="action" value="">
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
	</div>

	<%
		if (cnt <= 0) {}else{
	%>
	<div class="accbox">
		<!--ラベル1-->
		<label for="label1">在庫数が不足し始めている商品があります。クリックで表示</label> <input
			type="checkbox" id="label1" class="cssacc" />
		<div class="accshow">
			<!--ここに隠す中身-->
			<div id="stock">
				<table border=1>
					<tr>
						<th>地域</th>
						<th>詳細場所</th>
						<th>商品名</th>
						<th>在庫数</th>
						<th>最大在庫数</th>
						<th>前回在庫補充日</th>
					</tr>
					<%
						for (StockDB s : arrayList) {
					%>
					<tr>
						<td><%=s.getArea()%></td>
						<td><%=s.getPlace()%></td>
						<td><%=s.getProductName()%></td>
						<td><%=s.getStock()%></td>
						<td><%=s.getMaxStock()%></td>
						<td><%=s.getReceiptdate()%></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<center class="item">
	<button class="button"  onclick="location.href='AdminTop.jsp'">戻る</button>
	<button class="button"  onclick="location.href='./RegionalStock'">地域で在庫量を見る</button>
	<button class="button"  onclick="location.href='StockMap.jsp'">自動販売機の在庫量を見る</button>
	</center>

	<div id="footer">
		<p class="copy">copyright(C) 2018</p>
	</div>
</body>
</html>