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
<title>Insert title here</title>
</head>
<body>
<h3>情報を参照する<%=Choise %>を選択してください。</h3>
<form action ="./EarningVending"  method="get">
<select name="select">
<% for(ArrayList<String> rec: aryTable){ %>
	<% int cnt = 0; %>
	<% for(String data : rec){ %>
		<% if(cnt == 0){ %>
		<option value="<%=data %>">
		<% cnt = 1; %>
		<% }else{ %>
		<%=data %></option>
		<% } %>
	<% } %>
<%} %>
</select>
<br>


  <input type="hidden" name="choise"value="<%=ChoisePrice %>"></input>
  <button type="submit" name="action" value="table">票で表示</button>
  <button type="submit" name="action" value="chart">グラフで表示</button>
</form>
</body>
</html>
