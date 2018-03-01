<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

ArrayList<ArrayList<String>> aryTable = (ArrayList<ArrayList<String>>) request.getAttribute("PieChart");


%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);


      function drawChart() {

 		var $data1;
 		var $data2;
        var data = google.visualization.arrayToDataTable([
          ['商品', 'Hours per Day'],

  		<% for(ArrayList<String> rec: aryTable){ %>
  		<% int cnt = 0;%>
  			<% for(String data : rec){ %>
  			<%if(cnt == 0){%>
  				data1 = '<%=data %>';
  				<% cnt ++;%>
  				<% }else{ %>
  				data2 = <%=data%>;
  				<% } %>
  			<% } %>
			[%data1.repalace(%data1,$data1),%data2],

  	<% } %>

  		var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">

  var chart = null;

  // ライブラリのロード
  // name:visualization(可視化),version:バージョン(1),packages:パッケージ(corechart)
  google.load('visualization', '1', {'packages':['corechart']});

  // グラフを描画する為のコールバック関数を指定
  google.setOnLoadCallback(drawChart);

  // グラフの描画
  function drawChart() {

    // 配列からデータの生成
    var data = google.visualization.arrayToDataTable([
      ['月', '本数'],
      ['1月',  ],
      ['2月',   ],
      ['3月',   ],
      ['4月',   ],
      ['5月',   ],
      ['6月',   ],
      ['7月',   ],
      ['8月',   ],
      ['9月',   ],
      ['10月',  ],
      ['11月',66000  ],
      ['12月',65000],

    ]);

    // オプションの設定
    var options = {
      title: 'エリアでの売り上げ (単位:本)',
     };

    // 指定されたIDの要素に折れ線グラフを作成
    if (!chart)
     chart = new google.visualization.LineChart(document.getElementById('chart_div'));

    // グラフの描画
    chart.draw(data, options);
  }


</script>

  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>

  </body>
</html>
