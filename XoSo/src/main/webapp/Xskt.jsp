<%@page import="java.util.Random"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bootstrap</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<% LocalDate today= LocalDate.now();
	Random random=new Random();
	%>

	<table class="table table-bordered" style="margin-bottom: 0px">
		<tr style="text-align: center;">
			<td>Chọn Ngày</td>
			<td>Chọn Tháng</td>
			<td>Chọn Năm</td>
		</tr>
		<tr>
  		<td style=""> 
	 			<form action="Xskt.jsp" method="get"> 
				<select id="selectNgay" style="width: 100px;position: relative; left: 140px" name="x">
					<option value="Xskt.jsp?t=<%=today.getDayOfMonth()%>"><%=today.getDayOfMonth()%>	
					</option>
					<%for(int i = 1 ; i <= 31 ; i ++){ %>
					<option value="Xskt.jsp?t=<%=i%>"><%=i %></option>
					<%} %>
				</select>

			</td> 
			<td>
				<select id="selectThang" style="width: 100px ;position: relative; left: 140px" name="thang">
					<option value="Xskt.jsp?thang=<%=today.getMonthValue()%>"><%=today.getMonthValue()%>	
					</option>
					<%for(int i = 1 ; i <= 12 ; i ++){ %>
					<option value="Xskt.jsp?thang=<%=i%>"><%=i %></option>
					<%}
					%>
				</select> 
			</td>
			<td style="">
				<select  id="selectNam" style="width: 100px ; position: relative; left: 140px" name="nam">
					<option value= "Xskt.jsp?nam<%=today.getYear()%>"><%=today.getYear()%>	
					</option>
					<%for(int i = 2023 ; i >= 2014 ; i--){ %>
					<option value="Xskt.jsp?nam<%=i%>"><%=i %></option>
					<%} %>
				</select>
			</td>
		</tr>
							<button type="submit">Go</button>
				</form>
		<table class="table table-bordered" style="margin-bottom: 0px">
			<tr>
				<td style="width: 150px ; text-align: center;">Đặc biệt</td>
				<td style="text-align: center;"><%=random.nextInt(1000000) %></td>
			</tr>
			<tr>
				<td style="width: 150px ; text-align: center;">Giải Nhất</td>
				<td style="text-align: center;"><%=random.nextInt(100000)%></td>
			</tr>
			<table class="table table-bordered" style="margin-bottom: 0px">
				<tr>
				<td style="width: 150px ; text-align: center;">Giải Nhì</td>
				<td style="text-align: center;"><%=random.nextInt(100000) %></td>
				<td style="text-align: center;"><%=random.nextInt(100000) %></td>		
			</tr>
			</table>
			<table class="table table-bordered" style="margin-bottom: 0px">
				<tr>
					<td style="width: 150px ; text-align: center;">Giải Ba</td>
					<td style="text-align: center;"><%=random.nextInt(100000) %></td>
					<td style="text-align: center;"><%=random.nextInt(100000) %></td>
					<td style="text-align: center;"><%=random.nextInt(100000) %></td>				
				</tr>
			</table>
			<table class="table table-bordered" style="margin-bottom: 0px">
				<tr>
					<td style="width: 150px ; text-align: center;">Giải Tư</td>
					<td style="text-align: center;"><%=random.nextInt(100000) %></td>
					<td style="text-align: center;"><%=random.nextInt(100000) %></td>
					<td style="text-align: center;"><%=random.nextInt(100000) %></td>		
					<td style="text-align: center;"><%=random.nextInt(100000) %></td>		
				</tr>
			</table>
			<table class="table table-bordered" style="margin-bottom: 0px">
				<tr>
					<td style="width: 150px ; text-align: center;">Giải Năm</td>
					<td style="text-align: center;"><%=random.nextInt(10000) %></td>
					<td style="text-align: center;"><%=random.nextInt(10000) %></td>
					<td style="text-align: center;"><%=random.nextInt(10000) %></td>			
				</tr>
				<tr>
					<td style="width: 150px ; text-align: center;">Giải Sáu</td>
					<td style="text-align: center;"><%=random.nextInt(1000) %></td>
					<td style="text-align: center;"><%=random.nextInt(1000) %></td>
					<td style="text-align: center;"><%=random.nextInt(1000) %></td>			
				</tr>
			</table>
			<table class="table table-bordered" style="margin-bottom: 0px">
				<tr>
					<td style="width: 150px ; text-align: center;">Giải Bảy</td>
					<td style="text-align: center;"><%=random.nextInt(100) %></td>
					<td style="text-align: center;"><%=random.nextInt(100) %></td>
					<td style="text-align: center;"><%=random.nextInt(100) %></td>		
					<td style="text-align: center;"><%=random.nextInt(100) %></td>		
				</tr>
			</table>
		</table> 
	</table>
	<p>ban vua chon phan trang: <%=request.getParameter("x")%></p>
	<p>ban vua chon phan thang: <%=request.getParameter("thang")%></p>
		<p>ban vua chon phan thang: <%=request.getParameter("nam")%></p>
</body>
</html>