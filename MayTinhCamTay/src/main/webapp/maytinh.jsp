<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Máy Tính</title>
</head>
<body>
	<% 	
		int a = 0 ;
		int b =0;
		int kq = 0;
	if(request.getParameter("txta") != null){
		 	a = Integer.parseInt( request.getParameter("txta"));
		 	}
		if(request.getParameter("txtb")!=null){
			 b = Integer.parseInt( request.getParameter("txtb"));;
			 }
		if(request.getParameter("butcong")!=null){
			kq = a+b;
		}
			else if(request.getParameter("buttru")!=null){
				kq = a-b;
					}
				else if(request.getParameter("butnhan")!=null){
					kq = a*b;
						}
					else if(request.getParameter("butchia")!=null){
					kq = a/b;
				}
		
	%>
	
	<form action="maytinh.jsp" method="get">
		<input type="number" name="txta" value="<%=a %>"> <br>
		<input type="number" name="txtb" value="<%=b %>"> <br>
		<input type="number" name="txtkq" value="<%=kq %>"> <br>
		<input type="submit" name="butcong" value="+">
		<input type="submit" name="buttru" value="-">
		<input type="submit" name="butnhan" value="*">
		<input type="submit" name="butchia" value="/">
	</form>
</body>
</html>