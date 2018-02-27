<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
#map {
 width: 100%;
 height: 650px;
}
</style>
</head>
<body>
	<div id="map"></div>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=  AIzaSyCRjiWaAo75cpHGTq583VONQ-tG7PngvX0 &callback=initMap"></script>
	<script>
		function map_canvas() {
			//マーカーの情報
			var data = new Array();
			data.push({
				lat : '34.699875', //緯度
				lng : '135.493932', //経度
				url : './Connect?vendingMachineID=1', //リンク先
			});
			data.push({
				lat : '34.699875',
				lng : '135.489932',
				url : 'http://www.yaesu-book.co.jp/'
			});
			data.push({
				lat : '34.702300',
				lng : '135.497932',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.695973',
				lng : '135.534298',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.699972',
				lng : '135.536075',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.698549',
				lng : '135.528719',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.684383',
				lng : '135.499071',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.682266',
				lng : '135.494136',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.681031',
				lng : '135.501603',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.694288',
				lng : '135.474824',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.689052',
				lng : '135.47491',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});
			data.push({
				lat : '34.691652',
				lng : '135.47891',
				url : 'http://www.nihonbashi-tokyo.jp/'
			});

			//初期位置に、上記配列の一番初めの緯度経度を格納
			var latlng = new google.maps.LatLng(data[0].lat, data[0].lng);

			var opts = {
				zoom : 14,//地図の縮尺
				center : latlng, //初期位置の変数
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};

			//地図を表示させるエリアのidを指定
			var map = new google.maps.Map(document.getElementById("map"), opts);

			//マーカーを配置するループ
			for (i = 0; i < data.length; i++) {
				var markers = new google.maps.Marker(
						{
							position : new google.maps.LatLng(data[i].lat,
									data[i].lng),
							map : map,
							icon : "image/jihanki.png"
						});
				//クリックしたら指定したurlに遷移するイベント
				google.maps.event.addListener(markers, 'click', (function(url) {
					return function() {
						location.href = url;
					};
				})(data[i].url));
			}
		}

		//地図描画を実行
		google.maps.event.addDomListener(window, 'load', map_canvas);
	</script>
</body>
</html>