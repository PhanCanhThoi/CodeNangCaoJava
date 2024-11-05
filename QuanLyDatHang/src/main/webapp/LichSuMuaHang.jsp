<%@page import="HoaDonAndChiTietModal.HoaDonAndChiTiet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<%ArrayList<HoaDonAndChiTiet> ds = (ArrayList<HoaDonAndChiTiet>)session.getAttribute("dsHdAndCthd"); 
	int makh = (int)session.getAttribute("makh");%>
	<%@ include file="Layouts/navBar.jsp" %>
	<div class="container">
		<div class="row">
			<%@ include file="Layouts/SelectLoaiSach.jsp" %>
			<div class="col-sm-8 text-center">
				<h3>Lich Su Mua Hang</h3>
				<hr>
		<table class="table table-bordered">
		    <thead>
		      <tr>
		        <th>Mã sách</th>
		        <th>Số lượng</th>
		        <th>Ngày mua</th>
		        <th>Đã mua</th>
		      </tr>
		    </thead>
		    <tbody>
		     	<%for(HoaDonAndChiTiet hdAndCt : ds){
		     		if(makh==hdAndCt.getMakh()){%>
			     	<tr>
				        <td><%=hdAndCt.getMaSach() %></td>
				        <td><%=hdAndCt.getSoLuongMua() %></td>
				        <td><%=hdAndCt.getNgayMua() %></td>
				        <td>1</td>
			      </tr>
		     	<%}
		     		} %>		      
		    </tbody>
		  </table>
			</div>	
			<%@include file="Layouts/Search.jsp" %>

		</div>
	</div>
	
</body>
</html>