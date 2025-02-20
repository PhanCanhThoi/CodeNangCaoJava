package UserController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DangNhapModal.DangNhap;
import DangNhapModal.DangNhapBo;
import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    KhachHangBo khBo = new KhachHangBo();
	    DangNhapBo dn = new DangNhapBo();
		if(request.getParameter("DangKy")!=null) {
			String TenKhachHang = request.getParameter("TenKhachHang");
			String Email = request.getParameter("Email");
			String SoDienThoai = request.getParameter("SoDienThoai");
			String date = request.getParameter("selectedDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date NgaySinh = null;
			try {
				NgaySinh = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(request.getAttribute("GioiTinh"));
			int gt = Integer.parseInt(request.getParameter("GioiTinh"));
			boolean GioTinh;
			if(gt==1) {
				GioTinh=true;
			}else{
				GioTinh=false;
			}
			String DiaChi = request.getParameter("DiaChi");
			String TenDangNhap = request.getParameter("TenDangNhap");
			String mk = request.getParameter("MatKhau");
			String MatKhau = dn.HashMatKhau(mk);
			khBo.AddKhachHang(TenKhachHang, Email, SoDienThoai, NgaySinh, GioTinh, DiaChi, TenDangNhap, MatKhau);
			response.sendRedirect("DangNhapController");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
