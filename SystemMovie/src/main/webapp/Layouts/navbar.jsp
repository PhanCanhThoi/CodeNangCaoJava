<%@page import="KhachHangModal.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--Header-->
    <nav class="navbar navbar-expand-lg navbar-dark sticky-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="TrangChuController">Moon</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <form action="ShowAllPhimController">
                <li class="nav-item my-2" style="list-style-type: none"><button type="submit" name="btnDatVeNgay" class="btn btn-warning mx-2"> <i class="fa-solid fa-clapperboard"></i> Đặt vé ngay</button></li>
                </form>
                <li class="nav-item my-2" style="list-style-type: none"> <button type="button" class="btn btn-info mx-2"> <i class="fa-solid fa-glass-water"></i> Đặt bắp nước</button></li>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item my-2 mx-4">
                <form action="PaginationController" method="get">
                        <div class="input-group me-4">
                        	<input type="text" class="form-control" placeholder="Search" name="searchValue" value="">
                        	<button class="btn btn-primary" type="submit" name="btnSearchValue">Search</button>
                    </div>
				</form>
                </li>
                <%KhachHang khDangNhap = (KhachHang)session.getAttribute("KhAccount"); 
                if(session.getAttribute("KhAccount")==null){
                %>
                    <li class="nav-item my-2 mx-2">  
                        <a href="DangKyController" class="btn btn-info"><i class="fa-regular fa-circle-user "></i> Đăng ký</a>
                    </li>
                	<li class="nav-item my-2 mx-2">  
                        <a class="btn btn-info" href="DangNhapController"><i class="fa-regular fa-circle-user "></i> Login</a>
                    </li>

                <%}else{ %>
                	<li class="nav-item my-2 mx-2">  
                        <a href="LichSuDatVeController" class="btn btn-info">Xem Lịch Sử Đặt Vé</a>
                    </li>
                	<li class="nav-item my-2 mx-2">  
                        <a class="btn btn-info" ><%=khDangNhap.getTenDangNhap() %></a>
                    </li>
                    <li class="nav-item my-2 mx-2">  
                        <a href="LogoutController" class="btn btn-info"><i class="fa-regular fa-circle-user "></i> Logout</a>
                    </li>
                <%} %>

                </ul>
            </div>
        </div>
    </nav>

    <!-- Subnav 
    <ul class="nav container-fluid border" >
        <li class="nav-item">
            <button type="button" data-bs-toggle="modal" data-bs-target="#myModal" class="nav-link" style="color: black;">Chọn rạp</button>
        </li>
      </ul>-->