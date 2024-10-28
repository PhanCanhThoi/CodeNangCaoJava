<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="trangChuController.jsp">Trang chủ</a>
			</div>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">	
					<li class="nav-item"><a class="nav-link" href="xacNhanController">Xác nhận đặt hàng</a></li>
					<li class="nav-item"><a class="nav-link" href="datHangController">Hàng đã mua</a></li>
				</ul>
				<ul class="navbar-nav ms-auto">
					<%
					String tendn = (String)session.getAttribute("tendn");
					if(tendn==null)
						tendn="";
					String mk = (String)session.getAttribute("mk");
					if(mk==null)
						mk="";
					if (tendn.equals("abc")&& mk.equals("123")) {
					%>
					<li class="nav-item"><a class="nav-link" href=""><span class="glyphicon glyphicon-user"></span>
							xin chao <%=tendn%></a></li>
					<%

					} else {
					%>
					<li class="nav-item" type="button" data-bs-toggle="modal" data-bs-target="#myModal"><a class="nav-link"><span
							class="glyphicon glyphicon-user"></span>Đăng nhập</a></li>
					<%
					}
					%>
					<li class="nav-item"><a class="nav-link" href="logoutController"><span
							class="glyphicon glyphicon-log-in"></span>Đăng xuất</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-style">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="text-primary">Login</h3>
				</div>
				<div class="modal-body">
					<div class="mx-auto">
						<form class="container border py-4 border-info" action="trangChuController" method="get">
							<img class="logo-img" alt=""
								src="https://student.husc.edu.vn/Themes/Login/images/logo-small.png">
							<h1 class="mb-2 pt-4" style="color: #25258e; padding-left: 20px;">SINH
								VIÊN:</h1>
							<span
								style="display: flex; margin-left: 20px; margin-bottom: 5px; font-weight: bold;">Mã
								sinh viên</span> <input
								class="tendn mb-2 border border-light-subtle border-3"
								style="border-radius: 5px; text-indent: 10px; width: 270px; display: flex; position: relative; left: 20px; height: 40px"
								type="text" name="txtTenDn" placeholder="Tên đăng nhập">
							<span
								style="display: flex; margin-left: 20px; margin-bottom: 5px; font-weight: bold;">Mật
								khẩu:</span> <input class="mk border border-light-subtle border-3"
								style="border-radius: 5px; width: 270px; position: relative; text-indent: 10px; left: 20px; height: 40px"
								type="text" name="txtMk" placeholder="Mật Khẩu">
							<button class="btn btn-primary active" type="submit"
								name="dangnhap"
								style="border-radius: 5px; margin-left: 20px; margin-top: 25px; width: 270px; height: 40px;">Đăng
								nhập</button>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>