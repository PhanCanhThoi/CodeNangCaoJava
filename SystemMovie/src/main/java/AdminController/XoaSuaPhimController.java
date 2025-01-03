package AdminController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import PhimModal.Phim;
import PhimModal.PhimBo;
import TheLoaiModal.TheLoai;
import TheLoaiModal.TheLoaiBo;

/**
 * Servlet implementation class XoaSuaPhimController
 */
@WebServlet("/XoaSuaPhimController")
public class XoaSuaPhimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaPhimController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		TheLoaiBo tlBo = new TheLoaiBo();
		PhimBo phimBo = new PhimBo();
		ArrayList<TheLoai> dsTheLoai = tlBo.getTheLoai();
		session.setAttribute("dsTheLoai", dsTheLoai);
		// Tiến hành thêm phim
		if(request.getParameter("btnEdit")!=null) {
			int maPhim = Integer.parseInt(request.getParameter("maPhim"));
			Phim phim = phimBo.get1PhimTheoMa(maPhim);
			request.setAttribute("Phim", phim );
			RequestDispatcher rd = request.getRequestDispatcher("AdminEditPhim.jsp");
			rd.forward(request, response);
			return;
		}
		if(request.getParameter("btnDelete")!=null) {
			int maPhim = Integer.parseInt(request.getParameter("maPhim"));
			Phim phim = phimBo.get1PhimTheoMa(maPhim);
			request.setAttribute("Phim", phim );
			RequestDispatcher rd = request.getRequestDispatcher("AdminDeletePhim.jsp");
			rd.forward(request, response);
			return;
		}
		if(request.getParameter("xoaPhim")!=null) {
			System.out.println("hêlo");
			int maPhim = Integer.parseInt(request.getParameter("maPhim"));
			phimBo.DeletePhim(maPhim);
			response.sendRedirect("PhimController");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminAddPhim.jsp");
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
