<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" >

<head>
	<script type="text/javascript">
	    //今日の日時を表示
	        window.onload = function () {
	            //今日の日時を表示
	            var date = new Date()
	            var year = date.getFullYear()
	            var month = date.getMonth() + 1
	            var day = date.getDate()


	            var toTwoDigits = function (num, digit) {
	              num += ''
	              if (num.length < digit) {
	                num = '0' + num
	              }
	              return num
	            }

	            var yyyy = toTwoDigits(year, 4)
	            var mm = toTwoDigits(month, 2)
	            var dd = toTwoDigits(day, 2)
	            var ymd = yyyy + "-" + mm + "-" + dd;

	            document.getElementById("today").value = ymd;
	        }

	</script>
  <meta charset="UTF-8">
  <title>アプリ</title>
  <link rel="stylesheet" href="css/app.css">
</head>

<body>
  <div id="form-main">
  <div id="form-div">

    <form action="./UserRegistration" method="get" class="form" id="form1">

		<h3>生年月日</h3>

    	<div class="age">
      	<p class="name">
      	<label>
	    <input type="date" name="age" min="1900-01-01" id="today">
	    </label>
	    </p>
	    </div>

		<h3>性別</h3>
		<div class="sample">
		    <input type="radio" name="sex" id="on" value="1" checked>
		    <label for="on" class="switch-on">男</label>
		    <input type="radio" name="sex" id="off" value="2">
		    <label for="off" class="switch-off">女</label>
		</div>

      <div class="submit">
        <input type="submit" value="送信" id="button-blue"/>
        <div class="ease"></div>
      </div>
    </form>
  </div>
  </div>


</body>

</html>
