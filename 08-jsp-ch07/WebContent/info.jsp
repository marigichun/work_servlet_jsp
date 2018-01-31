<!-- p.164 -->
<%@ page contentType= "text/html; charset=utf-8" %>
<!DOCTYPE html">
<html>
<head><title>INFO</title></head>
<body>
	<!--  -->
	<table width= "100%" border="1" cellpadding="0" cellspacing="0"></table>
		<tr><!-- 행 -->
			<td>제품번호</td>
			<td>XXXX</td>
		</tr>
			<tr><!-- 행 -->
			<td>가격</td>
			<td>10000</td>
		</tr>
	</table>
	
	<!-- /infoSub.jsp?type=A -->
	<jsp:include page="infoSub.jsp" flush="false">
		<jsp:param name="type" value="A"/>
	</jsp:include>	
</body>
</html>