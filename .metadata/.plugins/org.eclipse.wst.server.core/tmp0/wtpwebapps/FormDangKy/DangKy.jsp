<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
    <link rel="stylesheet" href="Style.css">
</head>
<body >

    <div class="main">

        <div class="container">
            <!-- phần header-->
            <div class="bg-primary header">
                <span>ĐĂNG KÝ</span>
            </div>
            <!--phần contener-->
            <div class="container contain">

                <div class="row ">  
                    <div class="col-md-4">
                        <li class="text">Đăng kí nhanh qua Facebook</li>
                        <img class="lbclose" src="https://tailieu.vn/static/b2013az/templates/version1/default/images/btnfb277x45.jpg">
                    </div>   

                    <div class="col-md-4 read-more">
                        <ul class="tipmark">
                            <li>Thưởng ngay <span style="color: red;">50</span> ePoints khi đăng ký mới &amp; <span style="color: red;">5</span> ePoints cho mỗi lượt chia sẻ Facebook</li>
                            <li>Tích lũy nhiều ePoints khi Upload tài liệu <a rel="nofollow" href="https://tailieu.vn/gioi-thieu-diem-epoints.html">&gt;&gt;</a></li>
                        </ul>
                    </div>

                </div>
   
            </div>  
            <!--text--> 
            <div class="content">
                <a href="https://tailieu.vn/">Đăng kí mới bằng tài khoản TaiLieu.VN</a>
            </div>

            <!--Nhập tài khoản-->
            <div class="container ctn-nhapmk">
                <p class="title" >Bạn cần kích hoạt tài khoản qua Email sau khi đăng ký để nhận ngay 50 ePoints thưởng từ TaiLieu.VN</p>
                <!--ho ten-->
                <div class="row p-1">
                    <div class="col-md-3">
                        <input placeholder="Nhập Username" type="text" name="txt.Username" size="35" >
                    </div>
    
                    <div class="col-md-3">
                        <input placeholder="Nhập họ và tên" type="text" name="txt.HoTen" size="35" style="margin-left: 10px;">
                    </div>
                </div>
                <!--Mật khẩu-->
                <div class="row" style="margin-top: 10px;">
                    <div class="col-md-3">
                        <input placeholder="Nhập mật khẩu" type="text" size="35" name="txt.pasword">
                    </div>
                    <div class="col-md-3">
                        <select name="txt-gioitinh" id="txt-gioitinh" style="height: 25.2px; margin-left: 10px;">
                            <option value="">Giới Tính</option>
                            <option value="Nam">Nam</option>
                            <option value="Nữ">Nữ</option>
                        </select>
                    </div>
                </div>
            </div>
            <!--Nhâp lai mập khẩu-->
            <div class="row" style="position: relative; right: 5px; padding-top: 10px;">
                <div class="col-md-3" style="width: 35;">
                    <input placeholder="Nhập lại mật khẩu" type="text" size="35" name="txt.paswordAgain">
                </div>
                <div class="col-md-6" style="position: relative; right: 5px;">
                    <div class="col-md-2">
                        <select name="txt-Ngaysinh" id="txt-Ngaysinh"  style="height: 25.2px;">
                            <option value="ngaysinh">Ngày Sinh</option>   
                            <%for(int i = 1 ; i <=31 ; i++){ %>
                            	<option value="ngay<%=i%>"><%=i%></option>
                            	<%} %>
                        </select>
                    </div>

                    <div class="col-md-2" >
                        <select name="txt-Thang" id="txt-Thang" style="height: 25.2px; width: 88px; text-align: center;">
                            <option value="Thang">Tháng</option>
                            <%for(int i = 1 ; i <=12 ; i++){ %>
                            	<option value="thang<%=i%>"><%=i%></option>
                            	<%} %>
                        </select>
                    </div>

                    <div class="col-md-2" >
                        <select name="txt-Nam" id="txt-Nam" style="height: 25.2px; width: 88px; text-align: center;">
                            <option value="Nam">Năm</option>
                            <%for(int i = 2024 ; i >=1 ; i--){ %>
                            	<option value="nam<%=i%>"><%=i%></option>
                            	<%} %>
                        </select>
                    </div>
                </div>
            </div>

            <!--Địa chỉ email-->
            <div class="row" style="position: relative; right: 5px; padding-top: 10px;">
                <div class="col-md-3">
                    <input placeholder="Nhập địa chỉ email" type="text" size="35" name="txt.email">
                </div>
                <div class="col-md-3">
                    <select name="txt-tinhthanh" id="txt-tinhthanh" style="height: 25.2px; width: 88px; text-align: center; margin-left: 10px;">
                        <option value="Tinh/thanh">Tỉnh/Thành</option>
                        <option value="Hà Nội">Hà Nội</option>
                        <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                        <option value="Hải Phòng">Hải Phòng</option>
                        <option value="Đà Nẵng">Đà Nẵng</option>
                        <option value="Cần Thơ">Cần Thơ</option>
                        <option value="An Giang">An Giang</option>
                        <option value="Bà Rịa - Vũng Tàu">Bà Rịa - Vũng Tàu</option>
                        <option value="Bắc Giang">Bắc Giang</option>
                        <option value="Bắc Kạn">Bắc Kạn</option>
                        <option value="Bạc Liêu">Bạc Liêu</option>
                        <option value="Bắc Ninh">Bắc Ninh</option>
                        <option value="Bến Tre">Bến Tre</option>
                        <option value="Bình Định">Bình Định</option>
                        <option value="Bình Dương">Bình Dương</option>
                        <option value="Bình Phước">Bình Phước</option>
                        <option value="Bình Thuận">Bình Thuận</option>
                        <option value="Cao Bằng">Cao Bằng</option>
                        <option value="Cà Mau">Cà Mau</option>
                        <option value="Gia Lai">Gia Lai</option>
                        <option value="Hà Giang">Hà Giang</option>
                        <option value="Hà Nam">Hà Nam</option>
                        <option value="Hà Tĩnh">Hà Tĩnh</option>
                        <option value="Hòa Bình">Hòa Bình</option>
                        <option value="Hưng Yên">Hưng Yên</option>
                        <option value="Khánh Hòa">Khánh Hòa</option>
                        <option value="Kiên Giang">Kiên Giang</option>
                        <option value="Kon Tum">Kon Tum</option>
                        <option value="Lai Châu">Lai Châu</option>
                        <option value="Lâm Đồng">Lâm Đồng</option>
                        <option value="Lạng Sơn">Lạng Sơn</option>
                        <option value="Lào Cai">Lào Cai</option>
                        <option value="Long An">Long An</option>
                        <option value="Nam Định">Nam Định</option>
                        <option value="Ninh Bình">Ninh Bình</option>
                        <option value="Ninh Thuận">Ninh Thuận</option>
                        <option value="Phú Thọ">Phú Thọ</option>
                        <option value="Phú Yên">Phú Yên</option>
                        <option value="Quảng Bình">Quảng Bình</option>
                        <option value="Quảng Nam">Quảng Nam</option>
                        <option value="Quảng Ngãi">Quảng Ngãi</option>
                        <option value="Quảng Ninh">Quảng Ninh</option>
                        <option value="Quảng Trị">Quảng Trị</option>
                        <option value="Sóc Trăng">Sóc Trăng</option>
                        <option value="Sơn La">Sơn La</option>
                        <option value="Tây Ninh">Tây Ninh</option>
                        <option value="Thái Bình">Thái Bình</option>
                        <option value="Thái Nguyên">Thái Nguyên</option>
                        <option value="Thanh Hóa">Thanh Hóa</option>
                        <option value="Thừa Thiên - Huế">Thừa Thiên - Huế</option>
                        <option value="Tiền Giang">Tiền Giang</option>
                        <option value="Trà Vinh">Trà Vinh</option>
                        <option value="Tuyên Quang">Tuyên Quang</option>
                        <option value="Vĩnh Long">Vĩnh Long</option>
                        <option value="Vĩnh Phúc">Vĩnh Phúc</option>
                        <option value="Yên Bái">Yên Bái</option>
                    </select>
                </div>
            </div>
             <!--Nhập lại địa chỉ email-->   
            <div class="row" style="position: relative; right: 5px; padding-top: 10px;">
                <div class="col-md-3">
                    <input placeholder="Nhập lại địa chỉ email" type="text" size="35" name="txt.emailAgain">
                </div>
                <div class="col-md-3" style="margin-left: 10px;">
                    <input placeholder="Nhập mã xác nhận" type="text" size="15" name="txt.maxacnhan">
                </div>
            </div>
            <!--button đăng kí-->
            <div class="row" style="padding-top: 30px;">
                <div class="col-md-1">
                    <button style="background:url(https://tailieu.vn/static/b2013az/templates/version1/default/images/icons/btncenter1x33.gif); height: 33px; width: 90px;    text-align: center; font-weight: bold;color: #FFF; border-radius: 5px;    cursor: pointer; border-color: #FFF;">Đăng ký</button>
                </div>
                <div class="col-md-6" style="padding-top: 5px; font-size: 12px;">
                    <input type="checkbox" checked="checked">&nbsp;Tôi đồng ý với các Chính Sách và Thỏa Thuận Sử Dụng của TaiLieu.VN
                </div>
            </div>
            <hr style="border-top: 0.5px dashed #000;margin-top: 1px;margin-bottom: 1px; margin-right: 400px;">
            <div style="padding-top:5px;">
                <p style="font-size: 12px; color: #0080AF;font-weight: 700; padding-top: 5;" >
                Bạn đã có tài khoản TaiLieu.VN? Đăng nhập
                </p>
            </div>

            <!--Phần footer-->
            <div style="height: 95px; background-color: #f5f4f4;">
                <ul class=rows style="list-style-type: none; position: relative;right: 10px; font-size: 12.5px;display: inline;">
                    <li class="col-md-4" style="padding-top: 25px;">
                        <p>Thưởng <span style="color: red;">50</span> ePoints khi đăng kí mới</p>
                            <p>Tặng <span style="color: red;">5</span> ePoints cho mỗi lượt chia sẽ Facebook</p>
                    </li>
                    <li class="col-md-3" style="position: relative;right: 110px; padding-top: 25px;">
                        <div class="boder-left" style="height: 70px; padding-left: 5px; border-color: rgb(88, 168, 238);border-width: 1px;">
                            <p >Xem và tải trên <span style="color: rgb(39, 41, 152);">1 triệu</span> Tài Liệu miễn phí</p>
                            <p>Kết nối <span style="color: rgb(39, 41, 152);">5 triệu</span> thành viên <a href="https://tailieu.vn/" style="color: rgb(2, 125, 240); text-decoration: none;">TaiLieu.VN</a></p>
                        </div>
                    </li>
                    <li class="col-md-3" style="position: relative;right: 160px;padding-right: 50px; padding-top: 25px;">
                        <p style="line-height: 23px;  border-left-style: ridge; border-width: 1px; padding-left: 5px; border-color: rgb(88, 168, 238);">Kết bạn với <a href="https://tailieu.vn/" style="color: rgb(2, 125, 240); text-decoration: none;">TaiLieu.VN</a> trên <a href="https://www.facebook.com/home.php" style="color: rgb(2, 125, 240); text-decoration: none;">Facebook</a> để nhận link download miễn phí <span style="color: red;">100</span> tài liệu <span style="color: red;">HOT</span> mỗi ngày</p>
                    </li>
                </ul>
            </div>
        </div>

    </div>



</body>
</html>