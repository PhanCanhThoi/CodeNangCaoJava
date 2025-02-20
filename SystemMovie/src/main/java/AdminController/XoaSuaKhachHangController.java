package AdminController;

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
import javax.servlet.http.HttpSession;

import DangNhapModal.DangNhap;
import DangNhapModal.DangNhapBo;
import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;

/**
 * Servlet implementation class XoaSuaKhachHangController
 */
@WebServlet("/XoaSuaKhachHangController")
public class XoaSuaKhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaKhachHangController() {
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
		HttpSession session = request.getSession();
		DangNhapBo dn = new DangNhapBo();
		KhachHangBo khBo = new KhachHangBo();
		if(request.getParameter("btnEdit")!=null) {
			int makh = Integer.parseInt(request.getParameter("btnEdit"));
			KhachHang kh = khBo.getKhachHang_Ma(makh);
			session.setAttribute("KhachHang", kh);
		}
		if(request.getParameter("XacNhan")!=null) {
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
			int gt = Integer.parseInt(request.getParameter("GioiTinh"));
			boolean GioTinh;
			if(gt==1) {
				GioTinh=true;
			}else{
				GioTinh=false;
			}
			String DiaChi = request.getParameter("DiaChi");
			String TenDangNhap = request.getParameter("TenDangNhap");
			int MaKhachHang = Integer.parseInt(request.getParameter("MaKhachHang"));
			khBo.Update(MaKhachHang, TenKhachHang, Email, SoDienThoai, NgaySinh, GioTinh, DiaChi, TenDangNhap);			
			response.sendRedirect("KhachHangController");
			return;
		}
		if(request.getParameter("XacNhanXoa")!=null) {
			int MaKhachHang = Integer.parseInt(request.getParameter("MaKhachHang"));
			khBo.Delete(MaKhachHang);
			response.sendRedirect("KhachHangController");
			return;
		}
		if(request.getParameter("btnDelete")!=null) {
			int makh = Integer.parseInt(request.getParameter("btnDelete"));
			KhachHang kh = khBo.getKhachHang_Ma(makh);
			session.setAttribute("KhachHang", kh);
			RequestDispatcher rd = request.getRequestDispatcher("AdminDeleteKhachHang.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminEditKhachHang.jsp");
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
