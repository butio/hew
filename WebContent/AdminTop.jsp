<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css">

<link rel="stylesheet" type="text/css" href="./css/reset.css">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<ul>
<li class="machine"><a href="./SelectVendingServlet" >自販機</a></li>
<li class="area"><a href="./SelectAreaServlet" >エリア</a></li>
<li class="all"><a href="./Servlet" >全体</a></li>
</ul>
</div>
<div id="navi">
<h2>売上情報の参照</h2>
<ul>
<li class="navigation"><a href="./SelectVendingServlet" >自販機</a></li>
<li class="navigation"><a href="./SelectAreaServlet" >エリア</a></li>
<li class="navigation"><a href="./Servlet" >全体</a></li>
</ul>
</div>
<div id="footer">
copyright
</div>
</div>
</body>
</html>