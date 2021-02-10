<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돌봄 신청 시스템 | 관리자</title>
<link rel="stylesheet" href="../../css/admin/statistics.css">
<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script>
google.charts.load('current', {packages: ['corechart']});
google.charts.setOnLoadCallback(drawVisualization);

	function drawVisualization() {
		var data = google.visualization.arrayToDataTable(${result});
		
		var options = {
			title: '시도별 시설 수',
			width: 900,
	        height: 400,
			vAxis: {textStyle : {
						bold:'true'
					}
			},
			hAxis: {textStyle : {
						bold:'true'
					}
			},
					titleTextStyle: {
						fontSize: 18,
						bold:'true'
					}
		};
		
		var chart = new google.visualization.ColumnChart(document.getElementById('chart'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<jsp:include page="../a_header.jsp" />
	
	<div id="s_container">
		<jsp:include page="../a_aside.jsp" />
		
		<div class="main">
			<div class="contents">
				<div class="subHeader">
					<h3 id="srcTopTitle">시설통계</h3>
				</div>
				<div id="chart"></div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../a_footer.jsp" />
</body>
</html>