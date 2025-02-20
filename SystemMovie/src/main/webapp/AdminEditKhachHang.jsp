<%@page import="LichChieuModal.LichChieu"%>
<%@page import="PhongChieuModal.PhongChieu"%>
<%@page import="TheLoaiModal.TheLoai"%>
<%@page import="KhachHangModal.KhachHang"%>
<%@page import="PhimModal.Phim"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bổ sung phim</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <style>
    	/*Css cho navBar*/
    	body {
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #1a2634;
            color: white;
        }

        .navbar-brand, .navbar-nav .nav-link {
            color: white !important;
        }

        .navbar-toggler {
            border: none;
            color: white;
        }
        /*Đóng css cho thanh navbar*/
		/*css cho thanh sidebar*/
        .sidebar {
            width: 250px;
            background-color: #1a2634;
            min-height: 100vh;
            position: fixed;
            left: 0;
            top: 0;
            z-index: 100;
            transition: all 0.3s;
        }

        .sidebar-header {
            background-color: #2196F3;
            padding: 15px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .sidebar-menu {
            padding: 0;
            list-style: none;
            margin: 0;
        }

        .sidebar-menu li {
            margin: 0;
            padding: 0;
        }

        .sidebar-menu a {
            padding: 12px 15px;
            color: #a8b6c3;
            text-decoration: none;
            display: flex;
            align-items: center;
            transition: all 0.3s;
        }

        .sidebar-menu a:hover {
            background-color: rgba(255, 255, 255, 0.05);
            color: white;
        }

        .sidebar-menu i {
            margin-right: 10px;
            font-size: 1.1em;
        }

        .submenu {
            list-style: none;
            padding-left: 0;
            background-color: rgba(0, 0, 0, 0.1);
        }

        .submenu a {
            padding-left: 45px;
        }

        .sidebar-menu .dropdown-toggle::after {
            margin-left: auto;
        }

        .search-box {
            padding: 15px;
            position: fixed;
            bottom: 0;
            width: 250px;
            background-color: #1a2634;
            border-top: 1px solid rgba(255, 255, 255, 0.1);
        }

        .search-box input {
            background-color: rgba(255, 255, 255, 0.1);
            border: none;
            color: white;
        }

        .search-box input::placeholder {
            color: rgba(255, 255, 255, 0.5);
        }

        .search-box input:focus {
            background-color: rgba(255, 255, 255, 0.15);
            color: white;
            box-shadow: none;
        }

        @media (max-width: 768px) {
            .sidebar {
                margin-left: -250px;
            }
            
            .sidebar.active {
                margin-left: 0;
            }
        }
        /*Đóng css thanh sidebar*/
        
    .container {
	    margin-left: 260px; /* hoặc phù hợp với sidebar */
	    max-width: calc(100% - 260px);
	}
	#preview {
            margin-top: 10px;
            max-width: 200px; /* Kích thước tối đa của ảnh */
            height: auto;
            border: 1px solid #ccc;
            display: none; /* Ẩn trước khi chọn tệp */
        }
    </style>
</head>
<body>
	<%@ include file="Layouts/AdminNavBar.jsp" %>
	<%@ include file="Layouts/ControlSideBar.jsp" %>	
	<%KhachHang kh = (KhachHang)session.getAttribute("KhachHang"); %>
	<div class="container mt-5">
    <div class="text-center mb-4">
        <h2>Thay đổi thông tin khách hàng</h2>
    </div>
    <div class="card shadow">
        <div class="card-body">
            <form action="XoaSuaKhachHangController" method="post">
                <!-- Hidden Input -->
                <input type="hidden" name="MaKhachHang" value="<%=kh.getMaKhachHang()%>">
                <!-- Customer Name -->
                <div class="mb-3">
                    <label class="form-label">Tên khách hàng:</label>
                    <input type="text" class="form-control" name="TenKhachHang" value="<%=kh.getTenKhachHang() %>" autofocus>
                </div>

                <!-- Contact Name -->
                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <input type="text" class="form-control" name="Email" value="<%=kh.getEmail() %>">
                </div>

                <!-- Phone -->
                <div class="mb-3">
                    <label for="Phone" class="form-label">Điện thoại:</label>
                    <input type="text" class="form-control"  name="SoDienThoai" value="<%=kh.getSoDienThoai() %>">
                </div>

                <!-- Email -->
                <div class="mt-3 mb-3">
	                <label for="datepicker" class="form-label">Ngày sinh:</label>
	                <input type="text" id="datepicker" name="selectedDate" value="<%=kh.getNgaySinh() %>" class="form-control" required>
            	</div>

                <!-- Address -->
                <div class="mb-3">
                    <label class="form-label">Giới tính:</label>
	                <select name="GioiTinh" class="form-control">
		                <option <%=kh.isGioiTinh()? "selected":"" %> value="1">Nam</option>
		                <option <%=kh.isGioiTinh()? "":"selected" %> value="0">Nữ</option>
	                </select>
                </div>
				<div class="mb-3">
                    <label for="Phone" class="form-label">Địa chỉ:</label>
                    <input type="text" class="form-control"  name="DiaChi" value="<%=kh.getDiaChi()%>">
                </div>
                <div class="mb-3">
                    <label for="Phone" class="form-label">Tên đăng nhập:</label>
                    <input type="text" class="form-control"  name="TenDangNhap" value="<%=kh.getTenDangNhap()%>">
                </div>
                <!-- Buttons -->
                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary me-2" name="XacNhan">
                        <i class="fa fa-floppy-o"></i> Lưu dữ liệu
                    </button>
                    <a href="KhachHangController" class="btn btn-secondary">
                        Quay lại
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script>
    $(document).ready(function () {
        $('#datepicker').datepicker({
            format: 'yyyy-mm-dd', // Định dạng ngày
            autoclose: true,
            todayHighlight: true
        });
    });
        document.getElementById('navbarToggle').addEventListener('click', function() {
            document.querySelector('.sidebar').classList.toggle('active');
        });

        document.getElementById('sidebarToggle').addEventListener('click', function() {
            document.querySelector('.sidebar').classList.toggle('active');
        });
    </script>
</body>
</html>