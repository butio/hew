<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

	<form action="./RegionalStock" method="get">

		<select name="area">
			<option value="1">大阪市北区</option>
			<option value="2">大阪市都島区</option>
			<option value="3">サンプル</option>
			<option value="4">サンプル</option>
			<option value="5">サンプル</option>
			<option value="6">サンプル</option>
			<option value="7">サンプル</option>
			<option value="8">サンプル</option>
			<option value="9">サンプル</option>
			<option value="10">サンプル</option>
		</select>

		<input type="submit" value="送信"  />
	</form>

	<input type="button" onclick="location.href='StockMap.jsp'"value="自動販売機の在庫を見に行く">
	<input type="button" onclick="location.href='./StockCall'" value="戻る">
</body>
</html>