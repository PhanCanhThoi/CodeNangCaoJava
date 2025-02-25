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
    <title>Delete phim</title>
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
	<div class="container mt-5" style="margin-left: 250px;">
	<div class="container mt-4" style="margin-left: 150px">
    <div class="mt-4 mb-4 text-center"><h3>Delete phim</h3></div>
    <% 
     Phim phim = (Phim)request.getAttribute("Phim");
    %>
    <form action="XoaSuaPhimController" method="post">
      	<input type="hidden" name="maPhim" value="<%=phim.getMaPhim()%>">
		  <div class="mb-3 mt-3">
		    <label for="" class="form-label">Tên Phim</label>
		    <p class="form-control"><%=phim.getTenPhim() %></p>
		  </div>
		  <div class="mb-3 mt-3">
                <label class="form-label">Mã Thể Loại</label>
                <p class="form-control"><%=phim.getMaTheLoai() %></p>
           </div>
			<div class="mb-3 mt-3">
                <label class="form-label">Đạo diễn</label>
                <p class="form-control"><%=phim.getDaoDien()%></p>
            </div>
                        <div class="mb-3 mt-3">
                <label class="form-label">Diễn viên</label>
                <p class="form-control"><%=phim.getDienVien()%></p>
            </div>
                <div class="mt-3 mb-3">
                <label for="datepicker" class="form-label">Ngày Phát hành</label>
                <p class="form-control"><%=phim.getNgayPhatHanh()%></p>
            </div>
            <div class="mt-3 mb-3">
                <label class="form-label">Thời lượng</label>
                <p class="form-control"><%=phim.getThoiLuong()%></p>
            </div>
             <div class="mt-3 mb-3">
                <label class="form-label">Poster</label>
                <img src="<%=phim.getPoster()%>" id="preview" alt="Preview ảnh">
            </div>
 			<div class="mt-3 mb-3">
                <label class="form-label">Mô tả</label>
                <p class="form-control"><%=phim.getMoTa()%></p>
            </div>
            <div class="mt-3 mb-3">
                <label class="form-label">Trailer</label>
                <p class="form-control"><%=phim.getLinkTrailer()%></p>
            </div>
            <div class="mt-3 mb-3">
                <label class="form-label">Ngôn ngữ</label>
                <p class="form-control"><%=phim.getNgonNgu()%></p>
            </div>
            <!-- bổ sung -->
            <div class="form-group text-right">
                <button  type="submit" name="xoaPhim" value="12" class="btn btn-danger">
                    <i class="fa fa-floppy-o"></i>
                    Xoá Phim
                </button>
                <a href="PhimController" class="btn btn-default">
                    Quay lại
                </a>
            </div>
	</form>
    </div>
	</div>
	<!-- Bootstrap 5 JavaScript and Popper.js -->
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
        // upload file
        const fileInput = document.getElementById('file');
        const preview = document.getElementById('preview');

        fileInput.addEventListener('change', function () {
            const file = fileInput.files[0]; // Lấy tệp được chọn
            if (file) {
                const reader = new FileReader();

                // Khi đọc tệp xong, hiển thị ảnh
                reader.onload = function (e) {
                    preview.src = e.target.result; // Đường dẫn ảnh
                    preview.style.display = 'block'; // Hiển thị ảnh
                };

                reader.readAsDataURL(file); // Đọc tệp dưới dạng URL
            } else {
                preview.style.display = 'none'; // Ẩn nếu không chọn tệp
            }
        });
    </script>

</body>
</html>