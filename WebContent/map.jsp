<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
#map {
 width: 100%;
 height: 800px;
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
			data.push({//阪神電鉄
				lat : '34.699875', //緯度
				lng : '135.493932', //経度
				url : './Connect?vendingMachineID=1', //リンク先
			});
			data.push({//梅田ランプ西交差点
				lat : '34.699875',
				lng : '135.489932',
				url : './Connect?vendingMachineID=2'
			});
			data.push({//阪急うめだ本店前
				lat : '34.702300',
				lng : '135.497932',
				url : './Connect?vendingMachineID=3'
			});
			data.push({//京橋駅
				lat : '34.695973',
				lng : '135.534298',
				url : './Connect?vendingMachineID=4'
			});
			data.push({//桜之宮東公園
				lat : '34.700506',
				lng : '135.535233',
				url : './Connect?vendingMachineID=5'
			});
			data.push({//大阪市立東高等学校
				lat : '34.699874',
				lng : '135.528476',
				url : './Connect?vendingMachineID=6'
			});
			data.push({//大阪ビューホテル 本町
				lat : '34.684302',
				lng : '135.498983',
				url : './Connect?vendingMachineID=7'
			});
			data.push({//阿波座南公園
				lat : '34.679779',
				lng : '135.491644',
				url : './Connect?vendingMachineID=8'
			});
			data.push({//久宝公園
				lat : '34.680204',
				lng : '135.502822',
				url : './Connect?vendingMachineID=9'
			});
			data.push({//野田阪神駅
				lat : '34.694288',
				lng : '135.474824',
				url : './Connect?vendingMachineID=10'
			});
			data.push({//JR野田駅
				lat : '34.689052',
				lng : '135.47491',
				url : './Connect?vendingMachineID=11'
			});
			data.push({//大阪福島税務署
				lat : '34.692304',
				lng : '135.480059',
				url : './Connect?vendingMachineID=12'
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