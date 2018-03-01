<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>


<%
String vending = request.getParameter("vending");
String action = request.getParameter("action");
ArrayList<ArrayList<String>> aryTable = (ArrayList<ArrayList<String>>) request.getAttribute("Result");


%>

<form action ="./EarningVending"  method="get">


<table>
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

  <button type="submit" name="action" value="table">売上期間のみでソート</button>
  <br>
  <button type="submit" name="action" value="table_sex">購入者の性別毎にソート</button>
  <br>
  <button type="submit" name="action" value="chart">グラフで表示</button>


</form>


</body>
</html>
