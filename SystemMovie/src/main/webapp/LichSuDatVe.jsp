<%@page import="LichSuDatVeModal.LichSuDatVe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử đặt vé</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="themify-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style>
	nav{
            background-color: #0a1929;
            color: white;
        </style>
</head>
<body>
	<%@ include file="Layouts/navbar.jsp" %>
	
	<%ArrayList<LichSuDatVe> ds = (ArrayList<LichSuDatVe>)session.getAttribute("dsLichSu"); 
	int active = (int)request.getAttribute("active");
	%>
<div class="container">
    <div class="text-center mb-5 mt-5">
        <h2>Lịch sử đặt vé</h2>
    </div>
    <div class="text-center mb-5">
       <form action="LichSuDatVeController" method="post">
        <ul class="nav nav-tabs justify-content-center">
	            <li class="nav-item">
	                <button type="submit" class="nav-link <%=(active==0) ? "active":"" %>" name="btnVeChoXacNhan" value="0">Vé chờ xác nhận</button>
	            </li>
	            <li class="nav-item">
	                <button type="submit" class="nav-link <%=(active==1) ? "active":"" %>" name="btnVeDaDat" value="1">Vé chờ xem</button>
	            </li>
	            <li class="nav-item">
	                <button type="submit" class="nav-link <%=(active==-1) ? "active":"" %>" name="btnVeDaXem" value="-1">Vé đã xem</button>
	            </li>
        </ul>
       </form>
    </div>
	<%if(ds.size()==0){ %>
		<div class="text-center">
			<h3 class="text-danger">Không có vé nào!</h3>
		</div>
	<%}else{%>
	<table class="table table-bordered">
        <thead class="table-light">
            <tr>
                <th>Tên phim</th>
                <th>Ngày đặt</th>
                <th>Ngày chiếu</th>
                <th>Giờ chiếu</th>
                <th>Tên phòng</th>
                <th>Tên ghế</th>
            </tr>
        </thead>
        <tbody>
            <%for(int i = 0 ; i < ds.size() ; i++){ %>
            <tr>
                <td><%=ds.get(i).getTenPhim() %></td>
                <td><%=ds.get(i).getNgayDatVe() %></td>
                <td><%=ds.get(i).getNgayChieu() %></td>
                <td><%=ds.get(i).getGioChieu() %></td>
                <td><%=ds.get(i).getTenPhongChieu() %></td>
                <td><%=ds.get(i).getTenGhe() %></td>
            </tr>
            <%} %>
        </tbody>
    </table>
	<%} %>
</div>
</body>
</html>