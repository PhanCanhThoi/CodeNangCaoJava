package UserController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LichChieuModal.LichChieu;
import LichChieuModal.LichChieuBo;
import PhimModal.Phim;
import PhimModal.PhimBo;
import Phim_TheLoai_Modal.Phim_TheLoai;
import Phim_TheLoai_Modal.Phim_TheLoaiBo;

/**
 * Servlet implementation class ShowPhimController
 */
@WebServlet("/ShowPhimController")
public class ShowPhimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPhimController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Phim_TheLoaiBo phim_theLoaiBo = new Phim_TheLoaiBo();
		if(request.getParameter("btnXemChiTiet")!=null) {
			session.setAttribute("url", "ShowPhimController");
			int maPhim = Integer.parseInt(request.getParameter("maPhim"));
			session.setAttribute("maphim", maPhim);
			Phim_TheLoai phim_TheLoai = phim_theLoaiBo.get1Phim_TheLoai(maPhim);
			Date date = phim_TheLoai.getNgayPhatHanh();
	        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", new Locale("vi", "VN"));
	        String dayOfWeek = sdf.format(date);
	        session.setAttribute("dayOfWeek", dayOfWeek);
			session.setAttribute("phim_theLoai", phim_TheLoai);
			//get 4 ngày kế tiếp
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			// Ngày hiện tại
			LocalDate today = LocalDate.now();
			String day1 = today.format(formatter);
			String dayOfWeek0 = today.getDayOfWeek().toString();

			// Ngày kế tiếp
			LocalDate newDate = today.plusDays(1);
			String day2 = newDate.format(formatter);
			String dayToDayOfWeek1 = newDate.getDayOfWeek().toString();

			LocalDate newDate2 = today.plusDays(2);
			String day3 = newDate2.format(formatter);
			String dayToDayOfWeek2 = newDate2.getDayOfWeek().toString();

			LocalDate newDate3 = today.plusDays(3);
			String day4 = newDate3.format(formatter);
			String dayToDayOfWeek3 = newDate3.getDayOfWeek().toString();

			// Đưa dữ liệu vào session
			session.setAttribute("dayOfWeek0", dayOfWeek0);
			session.setAttribute("dayToDayOfWeek1", dayToDayOfWeek1);
			session.setAttribute("dayToDayOfWeek2", dayToDayOfWeek2);
			session.setAttribute("dayToDayOfWeek3", dayToDayOfWeek3);
			session.setAttribute("day1", day1);
			session.setAttribute("day2", day2);
			session.setAttribute("day3", day3);
			session.setAttribute("day4", day4);		
		}
		if(request.getParameter("btnNgayChieu")!=null) {
			session.setAttribute("ngaychieu", request.getParameter("btnNgayChieu"));
			LichChieuBo lichChieuBo = new LichChieuBo();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date utilDate;
			try {
				utilDate = formatter.parse(request.getParameter("btnNgayChieu"));
				java.sql.Date ngayChieu = new java.sql.Date(utilDate.getTime());//ngày chiếu
				ArrayList<LichChieu> dsLichChieu;
				Phim_TheLoai phim_theLoai = (Phim_TheLoai)session.getAttribute("phim_theLoai");
				int maPhim = phim_theLoai.getMaPhim();
				dsLichChieu = lichChieuBo.getLichChieuTheoPhim_Ngay(maPhim, ngayChieu);
				session.setAttribute("dsLichChieu", dsLichChieu);
			} catch (ParseException e) {
				System.out.println("xử lý ngày " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowPhim.jsp");
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
