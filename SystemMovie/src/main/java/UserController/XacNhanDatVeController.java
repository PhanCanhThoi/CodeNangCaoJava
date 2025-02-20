package UserController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConvertModal.Convert;
import HoaDonModal.HoaDonBo;
import LichChieuModal.LichChieu;
import VeXemPhimModal.VeXemPhimBo;

/**
 * Servlet implementation class XacNhanDatVeController
 */
@WebServlet("/XacNhanDatVeController")
public class XacNhanDatVeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDatVeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HoaDonBo hdBo = new HoaDonBo();
		VeXemPhimBo veBo = new VeXemPhimBo();
		Convert cv = new Convert();
		if(request.getParameter("DatVe")!=null) {
			if(session.getAttribute("checkDn")==null) {
				session.setAttribute("url","ChonGheController");
				response.sendRedirect("DangNhapController");
				return;
			}
			String x = request.getParameter("selectedSeats");
			if(x==null || x=="") {
				request.setAttribute("error","Vui lòng chọn ghế để đặt vé");
				RequestDispatcher rd = request.getRequestDispatcher("Seat.jsp");
				rd.forward(request, response);
				return;
			}
			int makh = (int)session.getAttribute("makh");
			int maphim = (int)session.getAttribute("maphim");
			int maHD = hdBo.AddHoaDon(makh);
			LichChieu Lc = (LichChieu)session.getAttribute("LichChieu");
			ArrayList<Integer> ds = cv.ConvertMaGhe(x);
			for(int i = 0 ; i < ds.size();i++) {
				veBo.AddVeXemPhim(ds.get(i), Lc.getMaLichChieu(), maphim, maHD);
			}
			response.sendRedirect("LichSuDatVeController");
			return;
		}	
		RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
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
