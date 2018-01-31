
<%@page import="java.util.Enumeration"%>
<%@ page contentType= "text/html: charset=utf-8" %>

<!DOCTYPE html">
<html>
<head><title>Insert title here</title></head>
<body>
<%
	Enumeration<String> attrEnum = application.getAttributeNames();
	while(attrEnum.hasMoreElements()) {
		String name = attrEnum.nextElement();
		Object value = application.getAttribute(name);
%>
	application 속성 : <b><%= name %></b> = <%= value %> <br>
<% 
	}
%>
</body>
</html>