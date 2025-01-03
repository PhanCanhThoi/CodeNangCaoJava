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
 * Servlet implementation class PaginationController
 */
@WebServlet("/PaginationController")
public class PaginationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Phim> dsPhimDangChieu = new ArrayList<Phim>();
		PhimBo phimBo = new PhimBo();
		if(request.getParameter("btnSearchValue")!=null) {
			String searchValue = request.getParameter("searchValue");
			dsPhimDangChieu = phimBo.getPhimDangChieuPagination(1, searchValue);
			int pagecount = phimBo.getPageCountPhimDangChieu(searchValue);
			session.setAttribute("dsPhimDangChieu", dsPhimDangChieu);
			session.setAttribute("pageCountPhimDangChieu", pagecount);
		}
		if(request.getParameter("btnPage")!=null) {
			int page = Integer.parseInt(request.getParameter("btnPage"));
			session.setAttribute("pagePhimDangChieu", page);
			dsPhimDangChieu = phimBo.getPhimDangChieuPagination(page,"");
			int pagecount = phimBo.getPageCountPhimDangChieu("");
			session.setAttribute("dsPhimDangChieu", dsPhimDangChieu);
			session.setAttribute("pageCountPhimDangChieu", pagecount);
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
