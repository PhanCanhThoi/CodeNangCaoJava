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

import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;
import TheLoaiModal.TheLoai;
import TheLoaiModal.TheLoaiBo;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/KhachHangController")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		KhachHangBo khBo = new KhachHangBo();
		
		int pageCount = khBo.getPageCount();
		int page = 1;
		dsKH = khBo.getKhachHang20Row(page);
		request.setAttribute("dsKH", dsKH);
		request.setAttribute("pageKH", page);
		request.setAttribute("pageCountKH", pageCount);
		
		if(request.getParameter("btnSearchValue")!=null) {
			ArrayList<KhachHang> dsKH2 = new ArrayList<KhachHang>();
			String searchValue = request.getParameter("SearchValue");
			session.setAttribute("searchValueKH", searchValue);
			dsKH2 = khBo.getKhachHang20RowSearch(searchValue, page);
			pageCount = khBo.getPageCountSearch(searchValue);
			request.setAttribute("dsKH", dsKH2);
			request.setAttribute("pageKH", page);
			request.setAttribute("pageCountKH", pageCount);
		}
		if(request.getParameter("btnPage")!=null) {
			ArrayList<KhachHang> dsKH3 = new ArrayList<KhachHang>();
			String searchValue = (String)session.getAttribute("searchValueKH");
			if(searchValue == null)
				searchValue="";
			page = Integer.parseInt(request.getParameter("btnPage"));
			dsKH3 = khBo.getKhachHang20RowSearch(searchValue, page);
			pageCount = khBo.getPageCountSearch(searchValue);
			request.setAttribute("dsKH", dsKH3);
			request.setAttribute("pageKH", page);
			request.setAttribute("pageCountKH", pageCount);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("AdminKhachHang.jsp");
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
