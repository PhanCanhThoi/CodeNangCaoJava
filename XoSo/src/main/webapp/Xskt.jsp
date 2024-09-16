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
	<link rel="stylesheet" href="StyleXoso.css">

</head>
<body>

	<% LocalDate today= LocalDate.now();
	Random random=new Random();
	%>
	<div class="bg-danger header">
          <span>Chào mừng quý vị và các bạn đã đến với chương trình xổ số của chúng tôi</span>
     </div>
	<table class="table table-bordered select" style="margin-bottom: 0px">
		<tr style="text-align: center;">
			<td>Chọn Ngày</td>
			<td>Chọn Tháng</td>
			<td>Chọn Năm</td>
		</tr>
		<tr>
  		<td > 
	 			<form action="Xskt.jsp" method="get"> 
				<select id="selectNgay" style="width: 100px;position: relative; left: 200px" name="x">
					<option value="<%=today.getDayOfMonth()%>"><%=today.getDayOfMonth()%>	
					</option>
					<%for(int i = 1 ; i <= 31 ; i ++){ %>
					<option value="<%=i%>"><%=i %></option>
					<%} %>
				</select>

			</td> 
			<td>
				<select id="selectThang" style="width: 100px ;position: relative; left: 200px" name="thang">
					<option value="<%=today.getMonthValue()%>"><%=today.getMonthValue()%>	
					</option>
					<%for(int i = 1 ; i <= 12 ; i ++){ %>
					<option value="<%=i%>"><%=i %></option>
					<%}
					%>
				</select> 
			</td>
			<td style="">
				<select  id="selectNam" style="width: 100px ; position: relative; left: 200px" name="nam">
					<option value= "<%=today.getYear()%>"><%=today.getYear()%>	
					</option>
					<%for(int i = 2023 ; i >= 2014 ; i--){ %>
					<option value="<%=i%>"><%=i %></option>
					<%} %>
				</select>
			</td>
			<td style="width: 150px ; text-align: center;"><button type="submit" class="btn btn-danger button">Xem Kết Quả</button></td>
			
		</tr>
							
				</form>
			<table class="table table-bordered" style="margin-bottom: 0px">
			  <tr>
			    <th style="text-align: center;font-size: 25px ; color: white; background-color: red;">Xổ số kiến thiết ngày:<%=request.getParameter("x")%>/<%=request.getParameter("thang")%>/<%=request.getParameter("nam")%></th>
			  </tr>
			</table>
			<table class="table table-bordered" style="margin-bottom: 0px">
				<tr>
					<td style="width: 150px ; text-align: center;">Đặc biệt</td>
					<td style="text-align: center;"><%=random.nextInt(1000000) %></td>
				</tr>
				<tr>
					<td style="width: 150px ; text-align: center;">Giải Nhất</td>
					<td style="text-align: center;"><%=random.nextInt(100000)%></td>
				</tr>
			</table> 

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
</body>
</html>