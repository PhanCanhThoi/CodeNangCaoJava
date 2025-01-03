<%@page import="DangNhapModal.DangNhap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <button class="navbar-toggler" id="navbarToggle" type="button">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">Phan Cảnh Thôi</a>
            <ul class="navbar-nav ms-auto">
            <%DangNhap AdminAccount = (DangNhap)session.getAttribute("AdminAccount"); 
            if(AdminAccount.getTenDangNhap()==null){%>
            	<li class="nav-item">
                    <a class="nav-link" href=""><i class="bi bi-person"></i> Tài khoản    
                </li>
                <li class="nav-item">
                    <a class="nav-link" href=""><i class="bi bi-box-arrow-right"></i> Đăng xuất</a>
                </li>
            <%}else{ %>
               <li class="nav-item">
                    <a class="nav-link"><%=AdminAccount.getTenDangNhap() %></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutController"><i class="bi bi-box-arrow-right"></i> Đăng xuất</a>
                </li>
                <%} %>
            </ul>
        </div>
    </nav>