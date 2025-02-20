<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moon Cinema</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.css" rel="stylesheet">
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
    </style>
</head>
<body>
	<%@ include file="Layouts/AdminNavBar.jsp" %>
	<%@ include file="Layouts/ControlSideBar.jsp" %>	
	<div class="container mt-5" style="margin-left: 250px;">
        <h2 class="mb-4">Dashboard - Tổng Quan</h2>

    <!-- Row 1: Thống kê tổng quan -->
    <div class="row">
        <div class="col-md-3 mb-4">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">Tổng số phim</h5>
                    <p class="display-6 text-primary"><%=request.getAttribute("tongPhim") %></p>
                    <i class="bi bi-film text-muted" style="font-size: 2rem;"></i>
                </div>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">Rạp đang hoạt động</h5>
                    <p class="display-6 text-success">1</p>
                    <i class="bi bi-building text-muted" style="font-size: 2rem;"></i>
                </div>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">Doanh thu tháng</h5>
                    <p class="display-6 text-warning"><%=request.getAttribute("ThongKeThang") %></p>
                    <i class="bi bi-cash-stack text-muted" style="font-size: 2rem;"></i>
                </div>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">Khách hàng</h5>
                    <p class="display-6 text-danger"><%=request.getAttribute("tongKhachHang") %></p>
                    <i class="bi bi-people text-muted" style="font-size: 2rem;"></i>
                </div>
            </div>
        </div>
    </div>

    <!-- Row 2: Biểu đồ -->
    <div class="row">
        <div class="col-md-8 mb-4">
            <div class="card shadow-sm">
		        <div class="card-header bg-primary text-white">
        			<h5 class="mb-0">Biểu đồ doanh thu</h5>
    			</div>
    			<div class="card-body">
        			<canvas id="revenueChart"></canvas>
    			</div>
            </div>
        </div>

        <!-- Thông báo -->
        <div class="col-md-4 mb-4">
            <div class="card shadow-sm">
                <div class="card-header bg-danger text-white">
                    <h5 class="mb-0">Thông báo quan trọng</h5>
                </div>
                <div class="card-body">
                    <p>- Moon chỉ có 1 rạp chiếu duy nhất ở Huế. Tất cả đều giả mạo</p>
                    <p>- Khuyến mãi 20% vé tháng 1.</p>
                    <p>- Hệ thống cập nhật ngày 25/12.</p>
                </div>
            </div>
        </div>
    </div>
    </div>
	<!-- Bootstrap 5 JavaScript and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        document.getElementById('navbarToggle').addEventListener('click', function() {
            document.querySelector('.sidebar').classList.toggle('active');
        });

        document.getElementById('sidebarToggle').addEventListener('click', function() {
            document.querySelector('.sidebar').classList.toggle('active');
        });
        
        const ctx = document.getElementById('revenueChart').getContext('2d');

        // Dữ liệu mẫu
        const data = {
            labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6'],
            datasets: [{
                label: 'Doanh thu (Triệu đồng)',
                data: [300, 400, 350, 500, 450, 600], // Số liệu doanh thu tượng trưng
                backgroundColor: [
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)',
                    'rgba(255, 159, 64, 0.6)'
                ],
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        };

        // Cấu hình biểu đồ
        const config = {
            type: 'bar', // Biểu đồ dạng cột
            data: data,
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        display: true, // Hiển thị chú thích
                        labels: {
                            color: '#333'
                        }
                    },
                    tooltip: {
                        enabled: true // Hiển thị thông tin khi hover
                    }
                },
                scales: {
                    x: {
                        ticks: { color: '#333' },
                        grid: { display: false }
                    },
                    y: {
                        ticks: { color: '#333' },
                        beginAtZero: true // Bắt đầu từ 0
                    }
                }
            }
        };

        // Khởi tạo biểu đồ
        const revenueChart = new Chart(ctx, config);
    </script>

</body>
</html>