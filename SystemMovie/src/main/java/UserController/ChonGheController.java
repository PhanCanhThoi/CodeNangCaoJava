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

import LichChieuModal.LichChieu;
import ShowGheModal.ShowGhe;
import ShowGheModal.ShowGheBo;

/**
 * Servlet implementation class ChonGheController
 */
@WebServlet("/ChonGheController")
public class ChonGheController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChonGheController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<ShowGhe> dsGhe;
		ShowGheBo gheBo = new ShowGheBo();
		if(request.getParameter("btnGioChieu")!=null) {
			String gioChieu = request.getParameter("btnGioChieu");
			int maLichChieu = 0;
			int maPhong=0;
			ArrayList<LichChieu> dsLichChieu =(ArrayList<LichChieu>)session.getAttribute("dsLichChieu");
			for(LichChieu lc:dsLichChieu) {
				if(gioChieu.equals(lc.getGioChieu())) {
					session.setAttribute("LichChieu",lc);
					maLichChieu = lc.getMaLichChieu();
					maPhong = lc.getMaPhongChieu();
					break;
				}		
			}
			dsGhe = gheBo.getGhe(maLichChieu, maPhong);
			session.setAttribute("dsShowGhe", dsGhe);
		}
		LichChieu lc = (LichChieu)session.getAttribute("LichChieu");
		dsGhe = gheBo.getGhe(lc.getMaLichChieu(), lc.getMaPhongChieu());
		session.setAttribute("dsShowGhe", dsGhe);
		RequestDispatcher rd = request.getRequestDispatcher("Seat.jsp");
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
