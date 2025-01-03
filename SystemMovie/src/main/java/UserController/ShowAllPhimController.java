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

import PhimModal.Phim;
import PhimModal.PhimBo;

/**
 * Servlet implementation class ShowAllPhimController
 */
@WebServlet("/ShowAllPhimController")
public class ShowAllPhimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllPhimController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Phim> ds = new ArrayList<Phim>();
		PhimBo phimBo = new PhimBo();
		if(request.getParameter("btnDatVeNgay")!=null) {
			System.out.println("Hello");
			ds = phimBo.getPhimDangChieu();
			session.setAttribute("dsPhim",ds);
			session.setAttribute("kieuPhim", "PHIM ĐANG CHIẾU");
		}
		if(request.getParameter("btnShowPhimDangChieu")!=null) {
			ds = phimBo.getPhimDangChieu();
			session.setAttribute("dsPhim",ds);
			session.setAttribute("kieuPhim", "PHIM ĐANG CHIẾU");
		}
		if(request.getParameter("btnShowPhimSapChieu")!=null) {
			ds = phimBo.getPhimChuanBiChieu();
			session.setAttribute("dsPhim",ds);
			session.setAttribute("kieuPhim", "PHIM SẮP CHIẾU");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ShowAllPhim.jsp");
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
