<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="stock.StockDB"%>
<%
ArrayList<StockDB> arrayList= (ArrayList<StockDB>) request.getAttribute("RESULT");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<h1>自販機TOP</h1>
<table border=1>
<tr><th>地域</th><th>詳細場所</th><th>商品名</th><th>在庫数</th><th>最大在庫数</th><th>前回在庫補充日</th></tr>
<%for (StockDB s : arrayList) {%>
<tr><td><%=s.getArea()%></td><td><%=s.getPlace() %></td><td><%=s.getProductName() %></td><td><%=s.getStock()%></td><td><%=s.getMaxStock()%></td><td><%=s.getReceiptdate() %></td>
</tr>
<%} %>
</table>
<input type="button" onclick="location.href='map.jsp'" value="地域で在庫量を見る">
<input type="button" onclick="location.href='StockMap.jsp'" value="自動販売機の在庫量を見る">
</body>
</html>