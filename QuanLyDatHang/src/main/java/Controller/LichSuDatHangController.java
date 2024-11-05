package Controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ChiTietHoaDonModal.ChiTietHoaDonBo;
import HoaDonAndChiTietModal.HoaDonAndChiTiet;
import HoaDonAndChiTietModal.HoaDonAndChiTietBo;
import HoaDonModal.HoaDon;
import HoaDonModal.HoaDonBo;
import temp.CgioHang;

/**
 * Servlet implementation class LichSu
 */
@WebServlet("/LichSu")
public class LichSuDatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuDatHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HoaDonAndChiTietBo HdAndCthdBo = new HoaDonAndChiTietBo();
		ArrayList<HoaDonAndChiTiet> dsHdAndCthd = new ArrayList<HoaDonAndChiTiet>();
		dsHdAndCthd = HdAndCthdBo.getHoaDonAndChiTiet();
		session.setAttribute("dsHdAndCthd", dsHdAndCthd);
		RequestDispatcher rd = request.getRequestDispatcher("LichSuMuaHang.jsp");
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
