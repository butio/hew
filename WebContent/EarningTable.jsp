<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<link rel="stylesheet" type="text/css" href="./css/reset.css">
<title>AdminTop</title>
</head>
<body>
<form name="Vending" method="get" action="./SelectVendingServlet">
</form>
<form name="Area" method="get" action="./SelectArea"">
</form>
<form name="All" method="get" action="./EarningVending"">
</form>
<form name="Stock" method="get" action=""">
</form>
<div id="wrapper">
<div id="header">
<ul>
<li class="machine"><a href="#" onClick="document.Vending.submit();">自販機</a></li>
<li class="area"><a href="#" onClick="document.Area.submit();">エリア</a></li>
<li class="all"><a href="#" onClick="document.All.submit();">全体</a>
<li class="stock"><a href="#" onClick="document.Stock.submit();">在庫</a>
</li>
</ul>
</div>
    <%@ page import="java.util.ArrayList" %>
<%
String vending = request.getParameter("vending");
String action = request.getParameter("action");
ArrayList<ArrayList<String>> aryTable = (ArrayList<ArrayList<String>>) request.getAttribute("Result");
%>
<form action ="./EarningVending"  method="get">
<div id="earning">
<table border=1>
	<tr>
		<td>商品名</td>
		<td>売上本数</td>
	</tr>
		<!-- データベースの中身を表示する -->
		<% for(ArrayList<String> rec: aryTable){ %>
	<tr>
		<% for(String data : rec){ %>
		<td><%=data %></td>
		<% } %>
	</tr>
<% } %>
</table>
  <p>購入者の性別を選択</p>
  <select name="sex">
  <option value="" selected>--</option>
  <option value="1">男性</option>
  <option value="2">女性</option>
  </select>
  <p>購入者の年代を選択</p>
  <select name="Age">
  <option value="" selected>--</option>
  <option value="1">10代以下</option>
  <option value="2">10代</option>
  <option value="3">20代</option>
  <option value="4">30代</option>
  <option value="5">40代</option>
  <option value="6">50代</option>
  <option value="7">60代以上</option>
  </select>
  <p>売上期間の選択</p>
  <select name="year">
  <option value="" selected>--</option>
  <% for(int cnt = 2018; cnt >= 1900 ; cnt --) {%>
  <option value="<%=cnt %>"><%=cnt %></option>
  <%} %>
  </select>
    <select name="month">
      <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 12 ; cnt ++) {%>
  <option value="<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>
  </select>
      <select name="day">
        <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 31 ; cnt ++) {%>
  <option value="<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>
  </select>
  ～
    <select name="year2">
      <option value="" selected>--</option>
  <% for(int cnt = 2018; cnt >= 1900 ; cnt --) {%>
  <option value="<%=cnt %>"><%=cnt %></option>
  <%} %>
  </select>
    <select name="month2">
      <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 12 ; cnt ++) {%>
  <option value="-<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>
  </select>
      <select name="day2">
        <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 31 ; cnt ++) {%>
  <option value="-<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>

  </select>
<br>
  <button type="submit" name="action" value="table">選択項目を反映して再表示</button>
  <br>
  <button type="submit" name="action" value="chart">グラフで表示</button>
  <input type="hidden" name="select"value="vending">
</form>
<div id="footer">
<p class="copy">copyright(C) 2018</p>
</div>
</div>
</body>
</html>
