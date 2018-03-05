<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String change = (String)request.getAttribute("CHANGE"); %>
<%String imgFile = (String)request.getAttribute("CATEGORYIMG"); %>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="refresh" content="10;URL=userapp.jsp">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Luckiest+Guy'>
  <link rel="stylesheet" href="css/common.css">
  <style>
    /* CSSアニメーションの設定 */
    .poyon {
      -webkit-animation: poyon 1.1s linear 0s 1;
      animation: poyon 1.1s linear 0s 1;
    }
    @-webkit-keyframes poyon {
      0%   { -webkit-transform: scale(0.8, 1.4) translate(0%, -100%); }
      10%  { -webkit-transform: scale(0.8, 1.4) translate(0%, -15%); }
      20%  { -webkit-transform: scale(1.4, 0.6) translate(0%, 30%); }
      30%  { -webkit-transform: scale(0.9, 1.1) translate(0%, -10%); }
      40%  { -webkit-transform: scale(0.95, 1.2) translate(0%, -30%); }
      50%  { -webkit-transform: scale(0.95, 1.2) translate(0%, -10%); }
      60%  { -webkit-transform: scale(1.1, 0.9) translate(0%, 5%); }
      70%  { -webkit-transform: scale(1.0, 1.0) translate(0%, 0%); }
      100% { -webkit-transform: scale(1.0, 1.0) translate(0%, 0%); }
    }
    @keyframes poyon {
      0%   { transform: scale(0.8, 1.4) translate(0%, -100%); }
      10%  { transform: scale(0.8, 1.4) translate(0%, -15%); }
      20%  { transform: scale(1.4, 0.6) translate(0%, 30%); }
      30%  { transform: scale(0.9, 1.1) translate(0%, -10%); }
      40%  { transform: scale(0.95, 1.2) translate(0%, -30%); }
      50%  { transform: scale(0.95, 1.2) translate(0%, -10%); }
      60%  { transform: scale(1.1, 0.9) translate(0%, 5%); }
      70%  { transform: scale(1.0, 1.0) translate(0%, 0%); }
      100% { transform: scale(1.0, 1.0) translate(0%, 0%); }
    }
  </style>
  <script src="js/common.js"></script>
</head>
<body>

	<div class="shadow"></div>
	<img id="drink" class="poyon" src="image/<%=imgFile %>" width="200" height="200">
	<script>
    // ID値「drink」に対してCSSアニメ―ション「poyon」を300ミリ秒の間隔を空けてループ再生
    looopAnimation("drink", "poyon", 2000);
  </script>
	<div class="bubbles">
		<h1>ご購入ありがとうございました。</h1>
		<h2><%=change %></h2>
	</div>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js'></script>
    <script  src="js/common.js"></script>

</body>
</html>