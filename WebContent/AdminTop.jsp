<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<link rel="stylesheet" type="text/css" href="./css/reset.css">
<title>Insert title here</title>
</head>
<body>
<form name="Vending" method="get" action="./SelectVendingServlet">
</form>
<form name="Area" method="get" action="./SelectArea"">
</form>
<form name="All" method="get" action="./EarningAll"">
</form>
<div id="wrapper">
<div id="header">
<ul>

<li class="machine"><a href="#" onClick="document.Vending.submit();">自販機</a></li>
<li class="area"><a href="#" onClick="document.Area.submit();">エリア</a></li>
<li class="all"><a href="#" onClick="document.All.submit();">全体</a>
</li>
</ul>
</div>
<div id="navi">
<h2 class="size">メニュー</h2>
<ul>
<li class="navigation">
<form name="Vending" method="get" action="./SelectVendingServlet">
<a href="#" onClick="document.Vending.submit();">自販機</a>
</form>
</li>
<li class="navigation">
<form name="Area" method="get" action="./SelectArea"">
<a href="#" onClick="document.Area.submit();">エリア</a>
</form></li>
<li class="navigation"><form name="All" method="get" action="./EarningAll"">
<a href="#" onClick="document.All.submit();">全体</a>
</form></li>
</ul>
</div>
<div id="footer">
<p class="copy">copyright 2018</p>
</div>
</div>
</body>
</html>
