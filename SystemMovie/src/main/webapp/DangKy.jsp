<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Create Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="text-center mb-4">
        <h2>Đăng ký tài khoản</h2>
    </div>
    <div class="card shadow">
        <div class="card-body">
            <form action="DangKyController" method="post">
                <!-- Hidden Input -->
                <input type="hidden" name="" value="">
                <!-- Customer Name -->
                <div class="mb-3">
                    <label class="form-label">Tên khách hàng:</label>
                    <input type="text" class="form-control" name="TenKhachHang" value="" autofocus>
                </div>

                <!-- Contact Name -->
                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <input type="text" class="form-control" name="Email" value="">
                </div>

                <!-- Phone -->
                <div class="mb-3">
                    <label for="Phone" class="form-label">Điện thoại:</label>
                    <input type="text" class="form-control"  name="SoDienThoai" value="">
                </div>

                <!-- Email -->
                <div class="mt-3 mb-3">
	                <label for="datepicker" class="form-label">Ngày sinh:</label>
	                <input type="text" id="datepicker" name="selectedDate" class="form-control" required>
            	</div>

                <!-- Address -->
                <div class="mb-3">
                    <label class="form-label">Giới tính:</label>
	                <select name="GioiTinh" class="form-control">
		                <option value="1">Nam</option>
		                <option value="0">Nữ</option>
	                </select>
                </div>
				<div class="mb-3">
                    <label for="Phone" class="form-label">Địa chỉ:</label>
                    <input type="text" class="form-control"  name="DiaChi" value="">
                </div>
                <div class="mb-3">
                    <label for="Phone" class="form-label">Tên đăng nhập:</label>
                    <input type="text" class="form-control"  name="TenDangNhap" value="">
                </div>
                <!-- Password -->
                <div class="mb-3">
                    <label for="Password" class="form-label">Password:</label>
                    <input type="password" class="form-control" name="MatKhau" value="">
                </div>
                <!-- Buttons -->
                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary me-2" name="DangKy">
                        <i class="fa fa-floppy-o"></i> Lưu dữ liệu
                    </button>
                    <a href="TrangChuController" class="btn btn-secondary">
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
