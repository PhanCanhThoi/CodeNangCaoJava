<%@page import="LichChieuModal.LichChieu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.LocalDate"%>
<%@page import= "java.time.format.TextStyle" %>
<%@page import="Phim_TheLoai_Modal.Phim_TheLoai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="PhimModal.Phim"%>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%Phim_TheLoai phim_theLoai = (Phim_TheLoai)session.getAttribute("phim_theLoai");  %>
    <title><%=phim_theLoai.getTenPhim() %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            background-color: #0a1929;
            color: white;
        }
        .theater-section {
            position: relative;
            padding: 2rem;
        }
        .showtimes {
            display: flex;
            flex-wrap: wrap;
            gap: 1rem;
        }
		.seat-row {
            display: flex;
            justify-content: center;
            margin-bottom: 10px;
            align-items: center;
        }
        .time-slot {
            border: 1px solid #ffd700;
            border-radius: 8px;
            padding: 0.5rem 1rem;
            color: #ffd700;
            background: transparent;
            min-width: 90px;
            text-align: center;
            transition: all 0.3s ease;
        }

        .time-slot:hover {
            background-color: rgba(255, 215, 0, 0.1);
            cursor: pointer;
        }

        .expand-button {
            position: absolute;
            top: 1rem;
            right: 1rem;
            color: white;
            background: transparent;
            border: none;
            font-size: 1.5rem;
            cursor: pointer;
        }
        .movie-poster {
            max-width: 100%;
            height: 100%;
            border-radius: 8px;
        }
        .movie-info {
            background-color: rgba(13, 25, 45, 0.95);
            border-radius: 8px;
            padding: 2rem;
        }
        .tag {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 0.5rem 1rem;
            border-radius: 20px;
            margin-right: 0.5rem;
            margin-bottom: 0.5rem;
            display: inline-block;
        }
        .age-rating {
            background-color: #ffd700;
            color: black;
            padding: 0.25rem 0.75rem;
            border-radius: 4px;
            font-weight: bold;
        }
        .section-title {
            font-size: 1.5rem;
            margin-top: 2rem;
            margin-bottom: 1rem;
            text-transform: uppercase;
        }
        .navbar {
            background: transparent !important;
            padding: 1rem 2rem;
        }
        
        .showtimes-title {
            font-size: 3rem;
            font-weight: bold;
            text-align: center;
            margin: 3rem 0;
        }
        .date-button.active {
            background: #ffd700;
            border-color: #ffd700;
            color: #4527a0;
        }
        .date-button {
            background: transparent;
            border: 2px solid rgba(255, 255, 255, 0.3);
            border-radius: 8px;
            color: #fff;
            padding: 1rem 2rem;
            text-align: center;
            transition: all 0.3s ease;
            width: 200px;
        }
        
        
        
        .date-number {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 0.5rem;
        }
        
        .date-day {
            font-size: 1rem;
        }
        
        .date-button:hover:not(.active) {
            border-color: rgba(255, 255, 255, 0.8);
            background: rgba(255, 255, 255, 0.1);
        }
    </style>
</head>
<body>
	<%phim_theLoai = (Phim_TheLoai)session.getAttribute("phim_theLoai"); %>
	<%@ include file="Layouts/navbar.jsp" %>
    <div class="container my-4">
        <div class="row g-4">
            <!-- Movie Poster -->
            <div class="col-12 col-md-5 col-lg-4">
                <img src="<%=phim_theLoai.getPoster() %>" alt="" class="movie-poster">
            </div>
            <!-- Movie Information -->
            <div class="col-12 col-md-7 col-lg-8">
                <div class="movie-info">
                    <h1 class="display-6 mb-4"><%=phim_theLoai.getTenPhim() %></h1>
                    
                    <div class="mb-4">
                        <span class="tag"><%=phim_theLoai.getTenTheLoai() %></span>
                        <span class="tag"><%=phim_theLoai.getNgonNgu() %></span>
                    </div>

                    <div class="row g-3 mb-4">
                        <div class="col-6 col-md-4">
                            <div class="d-flex align-items-center">
                                <i class="bi bi-clock me-2"></i>
                                <span><%=phim_theLoai.getThoiLuong() %></span>
                            </div>
                        </div>
                        <div class="col-6 col-md-4">
                            <div class="d-flex align-items-center">
                                <i class="bi bi-globe me-2"></i>
                                <span><%=phim_theLoai.getNgonNgu() %></span>
                            </div>
                        </div>
                    </div>

                    <h2 class="section-title">MÔ TẢ</h2>
                    <div class="mb-4">
                        <p><strong>Đạo diễn:</strong><%=phim_theLoai.getDaoDien() %></p>
                        <p><strong>Diễn viên:</strong> <%=phim_theLoai.getDienVien() %></p>
                        <p><strong>Khởi chiếu:</strong> <%=session.getAttribute("dayOfWeek")%> <%=phim_theLoai.getNgayPhatHanh() %></p>
                    </div>

                    <h2 class="section-title">NỘI DUNG PHIM</h2>
                    <p><%=phim_theLoai.getMoTa() %></p>
                </div>
            </div>
            </div>
            </div>
            <div class="text-center">
<button type="button" class="btn btn-outline-secondary text-warning" data-bs-toggle="modal" data-bs-target="#trailerModal">
  <i class="fa fa-play-circle"></i>  Xem Trailer
</button>
            </div>
            <!-- Lịch chiếu -->
            <%String day1 = (String)session.getAttribute("day1");
            String day2 = (String)session.getAttribute("day2"); 
            String day3 = (String)session.getAttribute("day3"); 
            String day4 = (String)session.getAttribute("day4");
            String dayToDayOfWeek = (String)session.getAttribute("dayOfWeek0");
            String dayToDayOfWeek1 = (String)session.getAttribute("dayToDayOfWeek1");
            String dayToDayOfWeek2 = (String)session.getAttribute("dayToDayOfWeek2");
            String dayToDayOfWeek3 = (String)session.getAttribute("dayToDayOfWeek3");%>
	<div class="container">
        <h1 class="showtimes-title">LỊCH CHIẾU</h1>     
        <!-- Date Selection -->
        <div class="d-flex justify-content-center gap-4 flex-wrap">
        <%String checkNgayChieu = (String)session.getAttribute("ngaychieu");
        if(checkNgayChieu==null){
        	checkNgayChieu = "";
        }
        	%>
            <form action="ShowPhimController">
            <button class="date-button <%= checkNgayChieu.equals(day1) ? "active" : "" %>" type="submit" name="btnNgayChieu" value="<%=day1%>">
                <div class="date-number"><%=day1 %></div>
                <div class="date-day"><%=dayToDayOfWeek %></div>
            </button>
            </form>    
            <form action="ShowPhimController">
            <button class="date-button <%= checkNgayChieu.equals(day2) ? "active" : "" %>" type="submit" name="btnNgayChieu" value="<%=day2%>">
                <div class="date-number"><%=day2 %></div>
                <div class="date-day"><%=dayToDayOfWeek1 %></div>
            </button>
            </form>
            
            <form action="ShowPhimController">
            <button class="date-button <%= checkNgayChieu.equals(day3) ? "active" : "" %>" type="submit" name="btnNgayChieu" value="<%=day3%>">
                <div class="date-number"><%=day3 %></div>
                <div class="date-day"><%=dayToDayOfWeek2 %></div>
            </button>
            </form>
            
            <form action="ShowPhimController">
            <button class="date-button <%= checkNgayChieu.equals(day4) ? "active" : "" %>" type="submit" name="btnNgayChieu" value="<%=day4%>">
                <div class="date-number"><%=day4 %></div>
                <div class="date-day"><%=dayToDayOfWeek3 %></div>
            </button>
            </form>
        </div>
        </div>
	   <%ArrayList<LichChieu> dsLichChieu = (ArrayList<LichChieu>)session.getAttribute("dsLichChieu"); 
       int n=0; 
	   if(dsLichChieu!=null){
        	n = dsLichChieu.size();
        }
        %>
    <div class="container">
     <h1 class="showtimes-title">GIỜ CHIẾU</h1> 
       <%if(n==0){ %>
       <div class="text-center">
    		<span class="text-danger">Không có giờ chiếu cho phim này</span>
		</div>
       <%}else{ %>
       <div class="theater-section">
        <div class="showtimes d-flex justify-content-center flex-wrap gap-2">
            <form action="ChonGheController">
            <%for(int i = 0 ; i < n ; i++){ %>
            <button type="submit" name="btnGioChieu" class="time-slot" value="<%=dsLichChieu.get(i).getGioChieu()%>"><%=dsLichChieu.get(i).getGioChieu() %></button>
            <%} %>
            </form>
        </div>
    </div>
       <%} %>
    </div>
    
<div class="modal fade" id="trailerModal" tabindex="-1" role="dialog" aria-labelledby="trailerModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="trailerModalLabel">Trailer Phim</h5>
                <!-- Sử dụng data-bs-dismiss thay vì data-dismiss -->
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <iframe id="trailerVideo" width="100%" height="315" src="" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script> <!-- Đảm bảo đã tải đủ Bootstrap JS -->

<script>
$('#trailerModal').on('show.bs.modal', function (event) {
    var trailerUrl = "<%= phim_theLoai.getLinkTrailer() %>";
    var iframe = $(this).find('#trailerVideo');
    iframe.attr('src', trailerUrl);
});

$('#trailerModal').on('hidden.bs.modal', function (event) {
    var iframe = $(this).find('#trailerVideo');
    iframe.attr('src', ''); // Dừng video khi đóng modal
});
</script>
</body>