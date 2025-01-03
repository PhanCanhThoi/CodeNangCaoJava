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
import TheLoaiModal.TheLoai;
import TheLoaiModal.TheLoaiBo;

/**
 * Servlet implementation class LoaiController
 */
@WebServlet("/LoaiController")
public class LoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<TheLoai> dsLoai = new ArrayList<TheLoai>();
		TheLoaiBo loaiBo = new TheLoaiBo();
		
		int pageCount = loaiBo.getPageCount();
		int page = 1;
		dsLoai = loaiBo.getLoai20Row(page);
		request.setAttribute("dsLoai", dsLoai);
		request.setAttribute("pageLoai", page);
		request.setAttribute("pageCountLoai", pageCount);
		
		if(request.getParameter("btnSearchValue")!=null) {
			ArrayList<TheLoai> dsTheLoai2 = new ArrayList<TheLoai>();
			String searchValue = request.getParameter("SearchValue");
			session.setAttribute("searchValueLoai", searchValue);
			dsTheLoai2 = loaiBo.getLoai20RowSearch(searchValue,page);
			pageCount = loaiBo.getPageCountSearch(searchValue);
			request.setAttribute("dsLoai", dsTheLoai2);
			request.setAttribute("pageLoai", page);
			request.setAttribute("pageCountLoai", pageCount);
		}
		if(request.getParameter("btnPage")!=null) {
			ArrayList<TheLoai> dsTheLoai3 = new ArrayList<TheLoai>();
			String searchValue = (String)session.getAttribute("searchValueLoai");
			if(searchValue==null)
				searchValue="";
			page = Integer.parseInt(request.getParameter("btnPage"));
			dsTheLoai3 = loaiBo.getLoai20RowSearch(searchValue,page);
			pageCount = loaiBo.getPageCountSearch(searchValue);
			request.setAttribute("dsLoai", dsTheLoai3);
			request.setAttribute("pageLoai", page);
			request.setAttribute("pageCountLoai", pageCount);
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminTheLoai.jsp");
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
