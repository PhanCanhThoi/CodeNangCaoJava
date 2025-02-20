<%@page import="PhimModal.Phim"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
	<%ArrayList<Phim> dsPhim = (ArrayList<Phim>)session.getAttribute("dsPhim"); %>
	<%@ include file="Layouts/navbar.jsp" %>
	    <div class="container">      
        <div class="text-center pt-4">
            <h1><%=session.getAttribute("kieuPhim") %></h1>
        </div>
        <!--Card-->
        <%if(dsPhim==null){ %>
        <h1>Không có phim nào</h1>
        <%}else{ %>
        <%int n = dsPhim.size();
        for(int i = 0 ; i < n ; i++ ){%>
        <div class="row mt-4">
            <div class="col-4">
                <div class="row">
                    <div class="col-2"></div>
                    	<div class="card col-8 p-0">
                        	<div class="container p-0">
	                            <img class="card-img-top image" src="<%=dsPhim.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->

	                    <div class="card-body text-center">
	                    <form action="ShowPhimController">
	                    <input type="hidden" name="maPhim" value="<%=dsPhim.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhim.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhim.get(i).getNgayPhatHanh()%></p>
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
	                            <img class="card-img-top image" src="<%=dsPhim.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                           <form action="ShowPhimController">
	                    <input type="hidden" name="maPhim" value="<%=dsPhim.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhim.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhim.get(i).getNgayPhatHanh()%></p>
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
	                            <img class="card-img-top image" src="<%=dsPhim.get(i).getPoster() %>" alt="Card image">
	                        </div>
	                        <!-- CÁC THUỘC TÍNH CỦA PHIM -->
	                    <div class="card-body text-center">
	                 <form action="ShowPhimController">
	                    <input type="hidden" name="maPhim" value="<%=dsPhim.get(i).getMaPhim()%>">
	                      <h4 class="card-title"><%=dsPhim.get(i).getTenPhim() %></h4>
	                      <p class="card-text">Khởi chiếu: <%=dsPhim.get(i).getNgayPhatHanh()%></p>
	                        <button class="btn btn-primary px-4" name="btnXemChiTiet">Xem chi tiết</button>     
                    </form>     
                    	</div>
                  	</div>  
                <div class="col-2"></div>
                </div>
            </div>
            <%} %>

<%} %>
      </div>
<%} %>
</div>
</body>
</html>