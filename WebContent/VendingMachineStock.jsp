<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="stock.StockDB"%>
<%
ArrayList<StockDB> arrayList= (ArrayList<StockDB>) request.getAttribute("RESULT");
String place = (String)request.getAttribute("PLACE");
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

	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript">
    google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(
        function() {
            var data = google.visualization.arrayToDataTable([
                [       '', '在庫数', '最大在庫数'],
                <%for (StockDB s : arrayList) {%>
                ['<%=s.getProductName()%>',     <%=s.getStock()%>,        <%=s.getMaxStock()%>],
                <%}%>
            ]);

            var options = {
                title: '<%=place%>　自動販売機在庫数',
			};

			var chart = new google.visualization.BarChart(document
					.getElementById('gct_sample_bar'));
			chart.draw(data, options);
		});
	</script>

	<div id="gct_sample_bar" style="width: 100%; height: 600px;"></div>

	<div class="accbox">
		<!--ラベル1-->
		<label for="label1">クリックで　<%=place%>　自動販売機の詳細を表示</label> <input type="checkbox"
			id="label1" class="cssacc" />
		<div class="accshow">
			<!--ここに隠す中身-->
			<div id="stock">
				<table border=1>
					<tr>
						<th>地域</th>
						<th>詳細場所</th>
						<th>商品名</th>
						<th>単価</th>
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
						<td><%=s.getPrice()%></td>
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

	<center class="item">
	<button class="button"  onclick="location.href='StockMap.jsp'">他の自動販売機の在庫を見に行く</button>
	<button class="button"  onclick="location.href='./StockCall'">戻る</button>
	</center>

	<div id="footer">
		<p class="copy">copyright(C) 2018</p>
	</div>
</body>
</html>
