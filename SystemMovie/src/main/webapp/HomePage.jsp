<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<%@page import="TheLoaiModal.TheLoai"%>
<%@page import="PhimModal.Phim"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moon Cinema</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="themify-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
    body {
            background-color: #0a1929;
            color: white;
        }
   .card-title{
   height: 60px;
   }    
  .image {
  opacity: 1;
  display: block;
  width: 100%;
  height: 300px;
  transition: .5s ease;
  backface-visibility: hidden;
}
    </style>
</head>
<body>
		<!--  HEADER -->
	<%@ include file="Layouts/navbar.jsp" %>
     
      <!--BODY -->
      <%ArrayList<Phim> dsPhimDangPhat = (ArrayList<Phim>)session.getAttribute("dsPhimDangChieu");
      ArrayList<TheLoai> dsTheLoai = (ArrayList<TheLoai>)session.getAttribute("dsTheLoai");
      %>
    <div class="container mb-4">      
        <div class="text-center pt-4">
            <h1>PHIM ĐANG CHIẾU</h1>
        </div>
        <!--Card-->
        <%int n = dsPhimDangPhat.size();%>
       <%if(n==0){ %>
       <h3 class="text-center mt-4 mb-4 text-danger">Không có phim đang chiếu</h3>
       <%}else{ %>
       <%for(int i = 0 ; i < n ; i++ ){%>
        <div class="row mt-4">
            <div class="col-4">
                <div class="row">
                    <div class="col-2"></div>
                    	<div class="card col-8 p-0">
                        	<div class="container p-0">
	                            <img class="card-img-top image" src="<%=dsPhimDangPhat.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                    <form action="ShowPhimController">
	                    <input type="hidden" name="maPhim" value="<%=dsPhimDangPhat.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhimDangPhat.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhimDangPhat.get(i).getNgayPhatHanh()%></p>
	                        <button class="btn btn-primary px-4" name="btnXemChiTiet">Xem chi tiết</button>     
                    	</form>
                    	</div>

                  	</div>  
                <div class="col-2"></div>
                </div>
            </div>
            <%i++;
            if(i<n){%>
            <div class="col-4">
                <div class="row">
                    <div class="col-2"></div>
                    	<div class="card col-8 p-0">
                        	<div class="container p-0">
	                            <img class="card-img-top image" src="<%=dsPhimDangPhat.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                           <form action="ShowPhimController">
	                    <input type="hidden" name="maPhim" value="<%=dsPhimDangPhat.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhimDangPhat.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhimDangPhat.get(i).getNgayPhatHanh()%></p>
	                        <button class="btn btn-primary px-4" name="btnXemChiTiet">Xem chi tiết</button>     
                    </form>
                    	</div>
                  	</div>  
                <div class="col-2"></div>
                </div>
            </div>
            <%} %>
            <%i++;
            if(i<n){%>
            <div class="col-4">
                <div class="row">
                    <div class="col-2"></div>
                    	<div class="card col-8 p-0">
                        	<div class="container p-0">
	                            <img class="card-img-top image" src="<%=dsPhimDangPhat.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                 <form action="ShowPhimController">
	                    <input type="hidden" name="maPhim" value="<%=dsPhimDangPhat.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhimDangPhat.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhimDangPhat.get(i).getNgayPhatHanh()%></p>
	                        <button class="btn btn-primary px-4" name="btnXemChiTiet">Xem chi tiết</button>     
                    </form>     
                    	</div>
                  	</div>  
                <div class="col-2"></div>
                </div>
            </div>
            <%} %>
      </div>
<%} %>
</div>
       <%} %>
      <!-- phân trang -->
      <%
      int CountPhimDangChieu = (int)session.getAttribute("pageCountPhimDangChieu"); 
      int pageCountPhimDangChieu = 0;
      int pagePhimDangChieu = (int)session.getAttribute("pagePhimDangChieu");
      	if(CountPhimDangChieu % 6 ==0){
      		pageCountPhimDangChieu = CountPhimDangChieu/6;    		
      	}else{
      		pageCountPhimDangChieu = CountPhimDangChieu/6 + 1;
      	}
      %>
      <form action="PaginationController" method="get">
      <ul class="pagination pagination-sm justify-content-center">
      <%for(int i = 1 ; i <= pageCountPhimDangChieu ; i ++){
					if(pagePhimDangChieu==i){%>
						<li class="page-item"><button class="page-link active" name="btnPage" value="<%=i%>"><%=i %></button></li>
					<%}else{%>
						<li class="page-item"><button class="page-link" name="btnPage" value="<%=i%>"><%=i %></button></li>
				<%	}
				%>
				<%}%>
		</ul>
		</form>
      <form action="ShowAllPhimController">
      <div class="text-center mb-4"><button class="btn btn-warning" name="btnShowPhimDangChieu">Xem tất cả</button>
        </div>
        </form>
    <!-- PHIM SẮP CHIẾU -->
    <div class="container mb-4">      
        <div class="text-center mt-4">
            <h1>PHIM SẮP CHIẾU</h1>
        </div>
        <!--Card-->
        <%ArrayList<Phim> dsPhimSapPhat = (ArrayList<Phim>)session.getAttribute("dsPhimSapChieu");
        int x=0;
        if(dsPhimSapPhat!=null){
        	x = dsPhimSapPhat.size();
        }
        if(x==0){%>
        	<h3 class="text-center mt-4 mb-4 text-danger">Không có phim sắp chiếu</h3>
        <%}else{%>
        <%for(int i = 0 ; i < x ; i++ ){%>
        <div class="row mt-4">
            <div class="col-4">
                <div class="row">
                    <div class="col-2"></div>
                    	<div class="card col-8 p-0">
                        	<div class="container p-0">
	                            <img class="card-img-top image" src="<%=dsPhimSapPhat.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                      <form action="ShowPhimController">
	                      <input type="hidden" name="maPhim" value="<%=dsPhimSapPhat.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhimSapPhat.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhimSapPhat.get(i).getNgayPhatHanh()%></p>
	                      <button class="btn btn-primary px-4" name="btnXemChiTiet">Xem chi tiết</button>
	                      </form>      
                    	</div>
                  	</div>  
                <div class="col-2"></div>
                </div>
            </div>
            <%i++;
            if(i<x){%>
            <div class="col-4">
                <div class="row">
                    <div class="col-2"></div>
                    	<div class="card col-8 p-0">
                        	<div class="container p-0">
	                            <img class="card-img-top image" src="<%=dsPhimSapPhat.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                      <form action="ShowPhimController">
	                      <input type="hidden" name="maPhim" value="<%=dsPhimSapPhat.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhimSapPhat.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhimSapPhat.get(i).getNgayPhatHanh()%></p>
	                      <button class="btn btn-primary px-4" name="btnXemChiTiet">Xem chi tiết</button>
	                      </form>       
                    	</div>
                  	</div>  
                <div class="col-2"></div>
                </div>
            </div>
            <%} %>
            <%i++;
            if(i<x){%>
            <div class="col-4">
                <div class="row">
                    <div class="col-2"></div>
                    	<div class="card col-8 p-0">
                        	<div class="container p-0">
	                            <img class="card-img-top image" src="<%=dsPhimSapPhat.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                      <form action="ShowPhimController">
	                      <input type="hidden" name="maPhim" value="<%=dsPhimSapPhat.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhimSapPhat.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhimSapPhat.get(i).getNgayPhatHanh()%></p>
	                      <button class="btn btn-primary px-4" name="btnXemChiTiet">Xem chi tiết</button>
	                      </form>         
                    	</div>
                  	</div>  
                <div class="col-2"></div>
                </div>
            </div>
            <%} %>
      </div>

<%}} %>
	</div>
      <!-- phân trang -->  
      <%
      int CountPhimSapChieu = (int)session.getAttribute("pageCountPhimSapChieu"); 
      int pageCountPhimSapChieu = 0;
      int pagePhimSapChieu = (int)session.getAttribute("pagePhimSapChieu");
      	if(CountPhimSapChieu % 6 ==0){
      		pageCountPhimSapChieu = CountPhimSapChieu/6;    		
      	}else{
      		pageCountPhimSapChieu = CountPhimSapChieu/6 + 1;
      	}
      %>
      <form action="PaginationController" method="get">
      <ul class="pagination pagination-sm justify-content-center">
      <%for(int i = 1 ; i <= pageCountPhimSapChieu ; i ++){
					if(pagePhimSapChieu==i){%>
						<li class="page-item"><button class="page-link active" name="btnPagePhimSapChieu" value="<%=i%>"><%=i %></button></li>
					<%}else{%>
						<li class="page-item"><button class="page-link" name="btnPagePhimSapChieu" value="<%=i%>"><%=i %></button></li>
				<%	}
				%>
				<%}%>
		</ul>
		</form>
      <form action="ShowAllPhimController">
      <div class="text-center mb-4"><button class="btn btn-warning" name="btnShowPhimSapChieu">Xem tất cả</button>
        </div>
      </form>

</body>
</html>