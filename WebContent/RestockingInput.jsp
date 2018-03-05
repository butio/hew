<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="restocking.RestockingDB"%>
<%
ArrayList<RestockingDB> arrayList= (ArrayList<RestockingDB>) request.getAttribute("RESULT");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th { text-align: left; }
</style>
<meta charset="utf-8">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<link rel="stylesheet" type="text/css" href="./css/reset.css">
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
				<li class="stock"><a href="#"
					onClick="document.Stock.submit();">在庫</a></li>
			</ul>
		</div>
	</div>
	<form action="./RestockingRegistration" method="get">
	<div id="earning">
		<table border=1>
			<tr>
				<th>地域</th>
				<th>地域</th>
				<th>商品名</th>
				<th>在庫数</th>
				<th>最大在庫数</th>
				<th>前回在庫補充日</th>
				<th>在庫補充数</th>
			</tr>
			<%
				for (RestockingDB r : arrayList) {
			%>
			<tr>
				<td><%=r.getArea()%></td>
				<td><%=r.getPlace()%></td>
				<td><%=r.getProductName()%></td>
				<td><%=r.getStock()%></td>
				<td><%=r.getMaxStock()%></td>
				<td><%=r.getReceiptdate()%></td>
				<td><select style="width: 70px" name="<%=r.getCount()%>">
						<option>-</option>
						<%
							for (int cnt = 1; r.getStockCnt() >= cnt; cnt++) {
						%>
						<option value="<%=cnt%>"><%=cnt%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<%
				}
			%>
		</table>
		</div>
		<center class="item">
			<button class="button" onclick="location.href='./StockCall'">戻る</button>
			<button class="button" onclick="location.href='StockMap.jsp'">自動販売機の在庫を見に行く</button>
			<input class="button" type="submit" value="送信">
		</center>
	</form>

	<div id="footer">
		<p class="copy">copyright(C) 2018</p>
	</div>
</body>
</html>