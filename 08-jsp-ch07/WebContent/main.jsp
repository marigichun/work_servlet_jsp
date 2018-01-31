<%@ page contentType= "text/html; charset=utf-8" %>
<!DOCTYPE html">
<html>
<head><title></title></head>
<body>
main.jsp에서 생성한 내용이다 멍

<%
 	String text ="hello";
%>
<jsp:include page= "sub.jsp" flush="false" />

include 이후의 내용이다 멍

</body>
</html>