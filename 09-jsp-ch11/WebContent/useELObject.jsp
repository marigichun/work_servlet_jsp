<%@ page contentType= "text/html; charset=utf-8" %>
<%
	request.setAttribute("name","최범균");
%>
<!DOCTYPE html">
<html>
<head><title>EL Object</title></head>
<body>
	<!-- 
		표현 언어 EL(Expression Language >>${ param.code })
	 -->
 	요청 URL: ${ pageContext.request.requestURL }<br>
 	request의  name 속성: ${ requestScope.name }<br>
 	code 파라미터: ${ param.code }
</body>
</html>
