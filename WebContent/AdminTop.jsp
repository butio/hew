<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href=" ${pageContext.request.contextPath}/css/design.css">
<title>Insert title here</title>
</head>
<body>

<h1>自動販売機管理画面</h1>

<h2>売上情報の参照</h2>
<form name="Vending" method="get" action="./SelectVendingServlet">
<a href="#" onClick="document.Vending.submit();">自販機</a>
</form>
<form name="Area" method="get" action="./SelectArea">
<a href="#" onClick="document.Area.submit();">エリア</a>
</form>
<form name="All" method="get" action="./EarningAll">
<a href="#" onClick="document.All.submit();">全体</a>
</form>

</body>
</html>
