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
    <title>Quản Lý Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
	<div class="text-center mb-4">
		<h1>Danh Sách Các Khách Hàng</h1>
	</div>
	<div class="pb-4">
   <form id="frmSearchInput" action="KhachHangController" method="get">
   	<input type="hidden" name="" value="" />
   		<div class="input-group">
        <input type="text" class="form-control" placeholder="Nhập phim tìm kiếm" name="SearchValue" value="" autofocus />
       <div class="input-group-btn" >
           <button class="btn btn-info" name="btnSearchValue" type="submit">
               <i class="fa fa-search"></i>
           </button>
       </div>
   </div>
	</form>
	</div>
	<%ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
	  ds = (ArrayList<KhachHang>)request.getAttribute("dsKH");
	  int pagePhim = (int)request.getAttribute("pageKH");
	  int rowCount = (int)request.getAttribute("pageCountKH");
	  int n=0;
	  if(ds!=null)
		   n = ds.size();
	%>
	<%if(n==0){ %>
		<div class="text-center">
			<p class="text-danger">Không có khách hàng để hiển thị</p>
		</div>
	<%}else{ %>	
    <div class="table-responsive">
        <table class="table table-bordered table-hover table-striped">
            <thead>
                <tr class="text-black">
                    <th>Tên Khách Hàng</th>
                    <th>Email</th>
                    <th>Số Điện Thoại</th>
                    <th>Địa Chỉ</th>
                    <th>Ngày Sinh</th>
                    <th style="width: 90px"></th>
                </tr>
            </thead>
            <tbody>
               <%for(int i = 0; i < n ; i++){ %>
               		<tr>               
                        <td><%=ds.get(i).getTenKhachHang()%></td>
                        <td><%=ds.get(i).getEmail()%></td>
                        <td><%=ds.get(i).getSoDienThoai()%></td>
                        <td><%=ds.get(i).getDiaChi()%></td>
                        <td><%=ds.get(i).getNgaySinh()%></td>
                        <td class="text-right">
                        <form action="XoaSuaKhachHangController" method="get">
                        <button class="btn btn-sm btn-info" name="btnEdit" value="<%=ds.get(i).getMaKhachHang()%>"><i class="fa fa-edit"></i></button>
                        <button class="btn btn-sm btn-danger" name="btnDelete" value="<%=ds.get(i).getMaKhachHang()%>"><i class="fa fa-trash"></i></i></button>  
                        </form>                            
                        </td>
                    </tr>     	
               <%} %>
            </tbody>
        </table>
    </div>
<%} %>
	<form action="KhachHangController" method="get">
			<ul class="pagination pagination-sm justify-content-center">
			<% int pageCount=0;
				if(rowCount%20==0)
					pageCount=rowCount/20;
				else
					pageCount = rowCount/20+1;
				for(int i = 1 ; i <= pageCount ; i ++){
					if(pagePhim==i){%>
						<li class="page-item"><button class="page-link active" name="btnPage" value="<%=i%>"><%=i %></button></li>
					<%}else{%>
						<li class="page-item"><button class="page-link" name="btnPage" value="<%=i%>"><%=i %></button></li>
				<%	}
				%>
				<%}
			%>
			</ul>
		</form>
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
    </script>

</body>
</html>