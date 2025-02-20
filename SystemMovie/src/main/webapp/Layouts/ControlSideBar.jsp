<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="sidebar">
        <!-- Sidebar Header -->
        <div class="sidebar-header">
            <span>Moon Cinema</span>
            <button class="btn btn-link text-white p-0 d-md-none" id="sidebarToggle">
                <i class="bi bi-list"></i>
            </button>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li>
                <a href="AdminTrangChuController"><i class="bi bi-house"></i> Trang chủ</a>
            </li>
            <li>
                <a href="#dataSubmenu" data-bs-toggle="collapse" class="dropdown-toggle">
                    <i class="bi bi-database"></i> Quản Lý Rạp Phim
                </a>
                <ul class="collapse submenu" id="dataSubmenu">
                    <li><a href="PhimController"><i class="bi bi-building"></i>Quản Lý Phim</a></li>
                    <li><a href="KhachHangController"><i class="bi bi-people"></i>Quản Lý Khách hàng</a></li>
                    <li><a href="LoaiController"><i class="bi bi-truck"></i>Quản Lý Loại</a></li>
                    <li><a href="LichChieuController"><i class="bi bi-person-badge"></i>Quản Lý Lịch</a></li>
                </ul>
            </li>
            <li>
                <a href="#orderSubmenu" data-bs-toggle="collapse" class="dropdown-toggle">
                    <i class="bi bi-bag"></i> Quản lý bán hàng
                </a>
                <ul class="collapse submenu" id="orderSubmenu">
                    <li><a href="XacThucVeController"><i class="bi bi-list-check"></i>Xác thực vé xem phim</a></li>
                    <li><a href="ThongKeController"><i class="bi bi-list-check"></i>Thống kê số lượng vé</a></li>
                </ul>
            </li>
        </ul>
    </div>