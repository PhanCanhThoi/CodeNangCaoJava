<%@page import="temp.CgioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	CgioHang g = (CgioHang) session.getAttribute("gh");
	g.sua((String)session.getAttribute("th"),Integer.parseInt((String)session.getAttribute("sl")),Integer.parseInt((String) session.getAttribute("gia")));
	session.setAttribute("gh", g);
	response.sendRedirect("DatHang.jsp");
		%>
</body>
</html>