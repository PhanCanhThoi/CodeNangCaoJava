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
import javax.websocket.Session;

import PhimModal.Phim;
import PhimModal.PhimBo;
import PhimModal.PhimDao;
import TheLoaiModal.TheLoai;
import TheLoaiModal.TheLoaiBo;

/**
 * Servlet implementation class TrangChuController
 */
@WebServlet("/TrangChuController")
public class TrangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**	
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Phim> dsPhimDangPhat = new ArrayList<Phim>();
		ArrayList<Phim> dsPhimSapPhat = new ArrayList<Phim>();
		PhimBo phimBo = new PhimBo();
		TheLoaiBo theloaiBo = new TheLoaiBo();	
		session.setAttribute("ngaychieu", null);	
		dsPhimDangPhat = phimBo.getPhimDangChieuPagination(1,"");
		session.setAttribute("dsPhimDangChieu", dsPhimDangPhat);
		int pageCountPhimDangChieu = phimBo.getPageCountPhimDangChieu("");	
		session.setAttribute("pageCountPhimDangChieu", pageCountPhimDangChieu);
		session.setAttribute("pagePhimDangChieu",1);
		//Lấy về các thuộc tính phim sắp chiếu
		dsPhimSapPhat = phimBo.getPhimSapChieuPagination(1, "");
		session.setAttribute("dsPhimSapChieu", dsPhimSapPhat);
		int pageCountPhimSapChieu = phimBo.getPageCountPhimSapChieu("");
		session.setAttribute("pageCountPhimSapChieu", pageCountPhimSapChieu);
		session.setAttribute("pagePhimSapChieu",1);	
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
