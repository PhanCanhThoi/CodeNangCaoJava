<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="sidebar">
        <!-- Sidebar Header -->
        <div class="sidebar-header">
            <span>Bui Le Shop</span>
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
                    <li><a href="PhongChieuController"><i class="bi bi-box"></i>Quản Lý Phòng Chiếu</a></li>
                    <li><a href="QuanLyGheController"><i class="bi bi-cart"></i>Quản Lý Ghế</a></li>
                </ul>
            </li>
            <li>
                <a href="#orderSubmenu" data-bs-toggle="collapse" class="dropdown-toggle">
                    <i class="bi bi-bag"></i> Quản lý bán hàng
                </a>
                <ul class="collapse submenu" id="orderSubmenu">
                    <li><a href="#"><i class="bi bi-list-check"></i> Danh mục đơn hàng</a></li>
                    <li><a href="#"><i class="bi bi-plus-circle"></i> Lập đơn hàng</a></li>
                </ul>
            </li>
        </ul>
    </div>