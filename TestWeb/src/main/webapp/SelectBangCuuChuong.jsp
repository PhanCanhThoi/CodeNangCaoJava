<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

 
	<form action="SelectBangCuuChuong.jsp" class="pt-4" method="get">
		<div class="input-group" >
			<span class="text-center d-flex justify-content-center align-items-center">Bạn muốn chọn bảng cửu chương số :</span> 
			<input class="input-group-append border" type="text" name="bcc" style="width:300px; margin-left: 40px" autofocus>
			<button type="submit" name="hienthi" class="btn btn-secondary text-center">Hiển thị</button>
		</div>
	</form>
	
	<p class="pt-4 text-center"><h3 class="text-center">Bảng cửu chương <%=request.getParameter("bcc") %></h3></p>
	<div class="table-reponsive pt-4">
		<table class="table table-bordered">
			<tr>
			<%
				int bcc=0;
				if(request.getParameter("bcc")!=null){
					bcc = Integer.parseInt(request.getParameter("bcc"));
				}
				else{
					
				}
				String hienthi = request.getParameter("hienthi");
					if(hienthi!=null){
					for(int i = 1 ; i <=10 ; i++){%>
						<td><%=bcc %> * <%=i %> = <%=bcc*i %>	</td>	
				<%		}
				}
					%>
			</tr>
		</table>
	</div>

</body>
</html>