<%@page import="Phim_TheLoai_Modal.Phim_TheLoai"%>
<%@page import="LichChieuModal.LichChieu"%>
<%@page import="ShowGheModal.ShowGhe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn Ghế</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="themify-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            background-color: #0a1929;
            color: white;
        }
        .seating-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .screen {
            background: linear-gradient(to bottom, rgba(255,255,255,0.2), rgba(255,255,255,0.1));
            height: 10px;
            border-radius: 50%;
            margin-bottom: 40px;
            position: relative;
        }

        .screen::after {
            content: 'SCREEN';
            position: absolute;
            top: -25px;
            left: 50%;
            transform: translateX(-50%);
            color: rgba(255,255,255,0.5);
            font-size: 12px;
        }
		.seated{
			background-color: #dc3545;
            border: none;
            margin: 3px;
            padding: 8px 0;
            width: 45px;
            border-radius: 5px;
            color: #6b46c1;
            font-weight: bold;
            font-size: 12px;
		}
        .seat-row {
            display: flex;
            justify-content: center;
            margin-bottom: 10px;
            align-items: center;
        }

        .row-label {
            color: #fff;
            width: 30px;
            text-align: right;
            margin-right: 15px;
            font-weight: bold;
        }

        .seat {
            background-color: #fff;
            border: none;
            margin: 3px;
            padding: 8px 0;
            width: 45px;
            border-radius: 5px;
            color: #6b46c1;
            font-weight: bold;
            font-size: 12px;
            transition: all 0.3s ease;
        }

        .seat:hover {
            background-color: #e9ecef;
            transform: scale(1.05);
        }

        .seat.selected {
            background-color: #6b46c1;
            color: white;
        }

        .seat:disabled {
            background-color: #dee2e6;
            color: #adb5bd;
            cursor: not-allowed;
        }

        @media (max-width: 768px) {
            .seat {
                width: 35px;
                font-size: 10px;
                padding: 6px 0;
            }
            
            .row-label {
                width: 20px;
                font-size: 12px;
            }
        }
    </style>
</head>
<body>
	<%@ include file="Layouts/navbar.jsp" %>
	<%ArrayList<ShowGhe> dsShowGhe = (ArrayList<ShowGhe>)session.getAttribute("dsShowGhe");
		int n = dsShowGhe.size();
		LichChieu lc = (LichChieu)session.getAttribute("LichChieu");	
		Phim_TheLoai phim_TheLoai = (Phim_TheLoai)session.getAttribute("phim_theLoai");
	%>
	<div class="text-center mb-4">
		<h1><%=phim_TheLoai.getTenPhim()%></h1>
		<label>Ngày chiếu: <%=session.getAttribute("ngaychieu")%>       Giờ chiếu: <%=lc.getGioChieu()%></label>
	</div>
    <div class="container-fluid">
        <div class="seating-container">
            <div class="screen"></div>            
            <!-- Seat Rows -->
            <div class="seat-rows">
                <!-- Row A -->
                <div class="seat-row">
                    <div class="row-label">A</div>
                    <%
                    for(int i = 0 ; i < 15 ; i++){ %>
                    	<%if(dsShowGhe.get(i).isTinhtrang()){ %>
                    		<button class="seated"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%}else{ %>
                    		<button value="<%=dsShowGhe.get(i).getMaGhe() %>" class="seat" data-seat="<%=dsShowGhe.get(i).getMaGhe()%>"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%} %>
                    <%} %>
                </div>

                <!-- Row B -->
                <div class="seat-row">
                    <div class="row-label">B</div>
                    <%
                    for(int i = 15 ; i < 30 ; i++){ %>
                    	<%if(dsShowGhe.get(i).isTinhtrang()){ %>
                    		<button class="seated"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%}else{ %>
                    		<button value="<%=dsShowGhe.get(i).getMaGhe() %>" class="seat" data-seat="<%=dsShowGhe.get(i).getMaGhe()%>"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%} %>
                    <%} %>
                </div>

                <!-- Row C -->
                <div class="seat-row">
                    <div class="row-label">C</div>
                    <%
                    for(int i = 30 ; i < 45 ; i++){ %>
                    	<%if(dsShowGhe.get(i).isTinhtrang()){ %>
                    		<button class="seated"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%}else{ %>
                    		<button value="<%=dsShowGhe.get(i).getMaGhe() %>" class="seat" data-seat="<%=dsShowGhe.get(i).getMaGhe()%>"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%} %>
                    <%} %>
                </div>

                <!-- Row D -->
                <div class="seat-row">
                    <div class="row-label">D</div>
                    <%
                    for(int i = 45 ; i < 60 ; i++){ %>
                    	<%if(dsShowGhe.get(i).isTinhtrang()){ %>
                    		<button class="seated"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%}else{ %>
                    		<button value="<%=dsShowGhe.get(i).getMaGhe() %>" class="seat" data-seat="<%=dsShowGhe.get(i).getMaGhe()%>"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%} %>
                    <%} %>
                </div>

                <!-- Row E -->
                <div class="seat-row">
                    <div class="row-label">E</div>
                    <%
                    for(int i = 60 ; i < 75 ; i++){ %>
                    	<%if(dsShowGhe.get(i).isTinhtrang()){ %>
                    		<button class="seated"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%}else{ %>
                    		<button value="<%=dsShowGhe.get(i).getMaGhe() %>" class="seat" data-seat="<%=dsShowGhe.get(i).getMaGhe()%>"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%} %>
                    <%} %>
                </div>
                <!-- Row E -->
                <div class="seat-row">
                    <div class="row-label">F</div>
                    <%
                    for(int i = 75 ; i < 90 ; i++){ %>
                    	<%if(dsShowGhe.get(i).isTinhtrang()){ %>
                    		<button class="seated"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%}else{ %>
                    		<button value="<%=dsShowGhe.get(i).getMaGhe() %>" class="seat" data-seat="<%=dsShowGhe.get(i).getMaGhe()%>"><%=dsShowGhe.get(i).getTenGhe() %></button>
                    	<%} %>
                    <%} %>
                </div>
            </div>
        </div>
        <div class="row">
            <%if(request.getAttribute("error")!=null){ %>
        		<div class="text-center"><span class="text-danger" style="font-size:18px"><%=request.getAttribute("error") %></span></div>
        	<%} %>
        	<div class="col d-flex justify-content-end">
		        <form action="XacNhanDatVeController" method="get">
		        	<input type="hidden" name="selectedSeats" id="seatInput" value="">
		        	<button class="btn btn-primary me-2" name="DatVe" type="submit" id="confirm">Xác nhận đặt vé</button>
		        </form>
		        <button class="btn btn-secondary" style="margin-right: 200px">Hủy đặt vé</button>
    		</div>
        </div>
        <div class="seat-row mt-4">
                    <p class="btn" style="margin-right: 150px;background-color: #fff;color:#6b46c1">Seat</p>
                    <p class="btn" style="background-color: #6b46c1;color:white">Seat</p>
                    <p class="btn btn-danger" style="margin-left: 150px">Seat</p>
        </div>
        <div class="seat-row">
              <p style="margin-right: 100px">Ghế chưa đặt</p>
              <p>Ghế đang chọn</p>
              <p style="margin-left: 100px">Ghế đã đặt</p>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
       // $(document).ready(function() {
        //    $('.seat').click(function() {
         //       $(this).toggleClass('selected');
          //  });
        //});
       
        $(document).ready(function () {
        const ticketPrice = 45000; // Giá vé cho mỗi ghế
        const totalDisplay = $('<p class="text-end text-white fs-5">Tổng tiền: <span id="totalPrice">0</span> VND</p>');
        
        // Thêm hiển thị tổng tiền vào giao diện
        $('.seating-container').append(totalDisplay);

        // Xử lý sự kiện khi người dùng click vào ghế
        $('.seat').click(function () {
            $(this).toggleClass('selected');

            // Lấy danh sách ghế được chọn
            const selectedSeats = document.querySelectorAll('.seat.selected');
            
            // Tính tổng tiền
            const totalPrice = selectedSeats.length * ticketPrice;

            // Cập nhật hiển thị tổng tiền
            $('#totalPrice').text(totalPrice.toLocaleString('vi-VN'));
        });
    });
        
        
        document.getElementById('confirm').addEventListener('click', function () {
            // Lấy tất cả các ghế đang chọn
            const selectedSeats = document.querySelectorAll('.seat.selected');
            const seatCodes = Array.from(selectedSeats).map(seat => seat.getAttribute('data-seat'));
            //Gán danh sách ghế vào input hidden
            const seatInput = document.getElementById('seatInput');
            seatInput.value = seatCodes.join(',');
          });
    </script>
</body>
</html>