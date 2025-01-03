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
import javax.websocket.Session;

import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;
import LichChieu.LichChieu;
import LichChieu.LichChieuBo;

/**
 * Servlet implementation class LichChieuController
 */
@WebServlet("/LichChieuController")
public class LichChieuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichChieuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<LichChieu> dsLichChieu = new ArrayList<LichChieu>();
		LichChieuBo lcBo = new LichChieuBo();
		
		int pageCount = lcBo.pageCount();
		int page = 1;
		dsLichChieu = lcBo.getLichChieu20Row(page);
		request.setAttribute("dsLichChieu", dsLichChieu);
		request.setAttribute("pageLichChieu", page);
		request.setAttribute("pageCountLichChieu", pageCount);
		
		if(request.getParameter("btnSearchValue")!=null){
			ArrayList<LichChieu> dsLichChieu2 = new ArrayList<LichChieu>();
			String searchValue = request.getParameter("SearchValue");
			session.setAttribute("searchValueLichChieu", searchValue);
			dsLichChieu2 = lcBo.getLichChieu20RowSearch(searchValue,page);
			pageCount = lcBo.pageCountSearch(searchValue);
			request.setAttribute("dsLichChieu", dsLichChieu2);
			request.setAttribute("pageLichChieu", page);
			request.setAttribute("pageCountLichChieu", pageCount);
		}
		if(request.getParameter("btnPage")!=null) {
			ArrayList<LichChieu> dsLichChieu3 = new ArrayList<LichChieu>();
			String searchValue = (String)session.getAttribute("searchValueLichChieu");
			if(searchValue == null)
				searchValue="";
			page = Integer.parseInt(request.getParameter("btnPage"));
			dsLichChieu3 = lcBo.getLichChieu20RowSearch(searchValue,page);
			pageCount = lcBo.pageCountSearch(searchValue);
			request.setAttribute("dsLichChieu", dsLichChieu3);
			request.setAttribute("pageLichChieu", page);
			request.setAttribute("pageCountLichChieu", pageCount);
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminLichChieu.jsp");
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
