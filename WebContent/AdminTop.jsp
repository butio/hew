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
<input type="hidden"name="action"value="table">
<input type="hidden"name="choise"value="table">

</form>
<form name="Stock" method="get" action="">
</form>
<div id="wrapper">
<div id="header">
<ul>
<li class="title"><a href="AdminTop.jsp" >自動販売機管理システム</a></li>
<li class="machine"><a href="#" onClick="document.Vending.submit();">自販機</a></li>
<li class="area"><a href="#" onClick="document.Area.submit();">エリア</a></li>
<li class="all"><a href="#" onClick="document.All.submit();">全体</a>
<li class="stock"><a href="#" onClick="document.Stock.submit();">在庫</a></li>
</ul>
</div>
<div id="navi">
<h2 class="size">メニュー</h2>
<ul>
<li class="navigation">
<a href="#" onClick="document.Vending.submit();">自販機</a>
</li>
<li class="navigation">
<a href="#" onClick="document.Area.submit();">エリア</a>
</li>
<li class="navigation">
<a href="#" onClick="document.All.submit();">全体</a>
</li>
<li class="navigation">
<a href="#" onClick="document.All.submit();">在庫</a>
</li>
</ul>
</div>
<div id="footer">
<p class="copy">copyright(C) 2018</p>
</div>
</div>
</body>
</html>
