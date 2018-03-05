<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="earnings.Earnings" %>
    <%@ page import="java.util.ArrayList" %>
<%

Earnings Error = (Earnings)request.getAttribute("Error");


String select = request.getParameter("select");

System.out.println(request.getParameter("error"));
System.out.println((Error.getMes()));
System.out.println(request.getParameter("error"));
ArrayList<ArrayList<String>> aryTable = (ArrayList<ArrayList<String>>) request.getAttribute("Result");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<link rel="stylesheet" type="text/css" href="./css/reset.css">
<title>売上</title>
</head>
<body>
<form name="Vending" method="post" action="./SelectVendingServlet">
</form>
<form name="Area" method="post" action="./SelectArea"">
</form>
<form name="All" method="post" action="./EarningVending"">
<input type="hidden"name="action"value="table">
</form>
<form name="Stock" method="post" action=""">
</form>
<div id="wrapper">
<div id="header">
<ul>
<li class="title"><a href="AdminTop.jsp" >自動販売機管理システム</a></li>
<li class="machine"><a href="#" onClick="document.Vending.submit();">自販機</a></li>
<li class="area"><a href="#" onClick="document.Area.submit();">エリア</a></li>
<li class="all"><a href="#" onClick="document.All.submit();">全体</a>
<li class="stock"><a href="#" onClick="document.Stock.submit();">在庫</a>
</li>
</ul>
</div>
    <%@ page import="java.util.ArrayList" %>

<%--
String select = request.getParameter("select");
String Error = request.getParameter("Error");
System.out.println(request.getParameter("message"));
ArrayList<ArrayList<String>> aryTable = (ArrayList<ArrayList<String>>) request.getAttribute("Result");
--%>
<form action ="./EarningVending"  method="get">

<form action ="./EarningVending"  method="post">
<div id="earning">
<table class="type">
	<thead>
	<tr>
		<th>商品名</th>
		<th>売上本数</th>
	</tr>
	</thead>
		<!-- データベースの中身を表示する -->
	<tbody>
		<% for(ArrayList<String> rec: aryTable){ %>

	<tr>
		<%int cnt = 0; %>
		<% for(String data : rec){ %>
		<% if(cnt == 0){%>
		<!-- 商品名 -->
		<td><%=data %></td>
		<%}else{ %>
		<!-- 売上数 -->
		<td><%=data %>></td>
		<%} %>

		<% } %>
	</tr>
<% } %>
	</tbody>
</table>
</div>
<center>
  <p class="buyer">購入者の性別を選択</p>
  <select name="sex" class="design2">
  <option value="" selected>--</option>
  <option value="1">男性</option>
  <option value="2">女性</option>
  </select>
  <p class="buyer">購入者の年代を選択</p>
  <select name="Age" class="design2">
  <option value="" selected>--</option>
  <option value="9">10代以下</option>
  <option value="19">10代</option>
  <option value="29">20代</option>
  <option value="39">30代</option>
  <option value="49">40代</option>
  <option value="59">50代</option>
  <option value="60">60代以上</option>
  </select>
  <p class="buyer">売上期間の選択</p>
  <%if(Error.getMes() != ""){ %>
  	<%=Error.getMes() %>
  	 <br>

  <%} %>
  <select name="year" class="design2">
  <option value="" selected>--</option>
  <% for(int cnt = 2018; cnt >= 1900 ; cnt --) {%>
  <option value="<%=cnt %>"><%=cnt %></option>
  <%} %>
  </select>

    <select name="month" class="design3">
      <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 12 ; cnt ++) {%>
  <option value="<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>
  </select>
      <select name="day" class="design3">
        <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 31 ; cnt ++) {%>
  <option value="<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>
  </select>
  ～
    <select name="year2" class="design2">
      <option value="" selected>--</option>
  <% for(int cnt = 2018; cnt >= 1900 ; cnt --) {%>
  <option value="<%=cnt %>"><%=cnt %></option>
  <%} %>
  </select>
    <select name="month2" class="design3">
      <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 12 ; cnt ++) {%>
  <option value="-<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>
  </select>
      <select name="day2" class="design3">
        <option value="" selected>--</option>
  <% for(int cnt = 1; cnt <= 31 ; cnt ++) {%>
  <option value="-<%=String.format("%02d",cnt) %>"><%=cnt %></option>
  <%} %>
  </select>
</center>

<center class="item">
<button class="button" type="submit" name="action" value="table">選択項目を反映して再表示</button>
<input type="hidden" name="select"value="<%=select%>">
<button class="button" type="submit" name="action" value="chart">グラフで表示</button>
<input type="hidden" name="select"value="<%=select%>">


</center>
</form>
<div id="footer">
<p class="copy">copyright(C) 2018</p>
</div>
</div>
</body>
</html>
