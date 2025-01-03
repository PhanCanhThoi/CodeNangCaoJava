package AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TheLoaiModal.TheLoai;
import TheLoaiModal.TheLoaiBo;

/**
 * Servlet implementation class XoaSuaLoaiController
 */
@WebServlet("/XoaSuaLoaiController")
public class XoaSuaLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		TheLoaiBo tlBo = new TheLoaiBo();
		if(request.getParameter("BoSung")!=null) {
			String tenLoai = request.getParameter("TenLoai");
			tlBo.ThemLoai(tenLoai);
		}
		if(request.getParameter("Update")!=null) {
			int maLoai = Integer.parseInt(request.getParameter("MaLoai"));
			String tenLoai = request.getParameter("TenLoai");
			TheLoai theloai = new TheLoai(maLoai, tenLoai);
			tlBo.UpdateLoai(theloai);
		}
		if(request.getParameter("Delete")!=null) {
			int maLoai = Integer.parseInt(request.getParameter("MaLoai"));
			tlBo.XoaLoai(maLoai);
		}
		if(request.getParameter("btnEdit")!=null) {
			int maTheLoai = Integer.parseInt(request.getParameter("maLoai"));
			TheLoai theloai = tlBo.getTheLoai_ID(maTheLoai);
			request.setAttribute("TheLoai", theloai);
			RequestDispatcher rd = request.getRequestDispatcher("AdminEditLoai.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnDelete")!=null) {
			int maTheLoai = Integer.parseInt(request.getParameter("maLoai"));
			TheLoai theloai = tlBo.getTheLoai_ID(maTheLoai);
			request.setAttribute("TheLoai", theloai);
			RequestDispatcher rd = request.getRequestDispatcher("AdminDeleteLoai.jsp");
			rd.forward(request, response);
		}
		response.sendRedirect("LoaiController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
