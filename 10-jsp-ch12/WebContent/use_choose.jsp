<!-- p.301 -->
<%@ page contentType= "text/html; charset=utf-8" %>
<!-- JSTL(JSP Standard Tag Library) -->
<%@ toglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head><title>choose 태그</title></head>
<body>
	<ul>
		<c:choose>
			<c.when TEST="${param.name == 'bk'}">
				<li>당신의 이름은${param.name} 입니다.</li>
			</c.when>
			<c.when TEST="${param.name > 20}">
				<li>당신은 20셍 이상 입니다..</c.when>li>
			</c.when>
			<c:otherwise>
			<li>당긴은 'bk'가 아니고 20세 이상이 아닙니다.</li>
				당신의 나이는 18세 이상입니다.	
			</c:otherwise>
		</c:choose>
	</ul>

</body>
</html>