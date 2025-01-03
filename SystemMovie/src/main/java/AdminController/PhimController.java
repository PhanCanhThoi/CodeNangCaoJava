package AdminController;

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
 * Servlet implementation class PhimController
 */
@WebServlet("/PhimController")
public class PhimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhimController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Phim> dsPhim = new ArrayList<Phim>();
		PhimBo phimBo = new PhimBo();
		
		int pageCount = phimBo.getPageCount();
		int page = 1;
		dsPhim = phimBo.getPhim20Row(page);
		request.setAttribute("dsPhim", dsPhim);
		request.setAttribute("page", page);
		request.setAttribute("pageCount", pageCount);
		
		if(request.getParameter("btnSearchValue")!=null) {
			ArrayList<Phim> dsPhim1 = new ArrayList<Phim>();
			String searchValue = request.getParameter("SearchValue");
			session.setAttribute("searchValuePhim", searchValue);
			dsPhim1 = phimBo.getPhim20RowSearch(searchValue,page);
			pageCount = phimBo.getPageCountSearch(searchValue);
			request.setAttribute("dsPhim", dsPhim1);
			request.setAttribute("page", page);
			request.setAttribute("pageCount", pageCount);
		}
		if(request.getParameter("btnPage")!=null) {
			ArrayList<Phim> dsPhim2 = new ArrayList<Phim>();
			String searchValue = (String)session.getAttribute("searchValuePhim");
			if(searchValue == null)
				searchValue="";
			page = Integer.parseInt(request.getParameter("btnPage"));
			dsPhim2 = phimBo.getPhim20RowSearch(searchValue,page);
			pageCount = phimBo.getPageCountSearch(searchValue);
			request.setAttribute("dsPhim", dsPhim2);
			request.setAttribute("page", page);
			request.setAttribute("pageCount", pageCount);
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminPhim.jsp");
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
