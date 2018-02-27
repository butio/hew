<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<script type="text/javascript">
	<!--
	function checkForm($this)
	{
	    var str=$this.value;
	    while(str.match(/[^A-Z^a-z\d\-]/))
	    {
	        str=str.replace(/[^A-Z^a-z\d\-]/,"");
	    }
	    $this.value=str;
	}
	//-->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style=Type" content="text/css;">
<link href="css/style.css" rel="stylesheet" type="text/css" >
<title>自販機</title>
</head>
<body>

<form action="./Purchase" method="get">

<table class="product" border="1">
<tr><td><img src="image/cola.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='1' class="button3 rad1">160</button></p></td>

<td><img src="image/colazero.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='2' class="button3 rad1">160</button></p></td>

<td><img src="image/akueri.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='3' class="button3 rad1">160</button></p></td>

<td><img src="image/otya.jpg">
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='4' class="button3 rad1">160</button></p></td>

<td><img src="image/ayataka.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='5' class="button3 rad1">160</button></p></td>

<td><img src="image/irohasu.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='6' class="button3 rad1">110</button></p></td></tr>

<tr><td><img src="image/gold.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='7' class="button3 rad1">120</button></td>

<td><img src="image/sirobudo.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='8' class="button3 rad1">120</button></p></td>

<td><img src="image/kotya.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='9' class="button3 rad1">120</button></p></td>

<td><img src="image/latte.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='10' class="button3 rad1">120</button></p></td>

<td><img src="image/black.jpg">
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='11' class="button3 rad1">120</button></p></td>

<td><img src="image/mountain.jpg" >
<div class="box"><p>つめた～い</p></div>
<p><button type='submit' name='drink' value='12' class="button3 rad1">120</button></p></td></tr>
</table>

<br>
<img class="koukoku"src="image/koukoku.png">

<div id="price">
  <input name="coin" value=""  type="number" class="price" min="0" max="1000" step="10" onInput="checkForm(this)" required="required" >
</div>

</form>
</body>
</html>
