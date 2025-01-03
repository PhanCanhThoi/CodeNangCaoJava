package AdminController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LichChieuModal.LichChieu;
import LichChieuModal.LichChieuBo;
import PhimModal.Phim;
import PhimModal.PhimBo;
import PhongChieuModal.PhongChieu;
import PhongChieuModal.PhongChieuBo;

/**
 * Servlet implementation class XoaSuaLichChieuController
 */
@WebServlet("/XoaSuaLichChieuController")
public class XoaSuaLichChieuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaLichChieuController() {
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
	    PhimBo phimBo = new PhimBo();
	    PhongChieuBo pcBo = new PhongChieuBo();
	    LichChieuBo lcBo = new LichChieuBo();
	    ArrayList<Phim> dsPhim = phimBo.getPhim();
	    ArrayList<PhongChieu> dsPhongChieu = pcBo.getPhongChieu();
	    request.setAttribute("dsPhongChieu", dsPhongChieu);
	    request.setAttribute("dsPhim", dsPhim);	    
	    if(request.getParameter("ThemLichChieu")!=null) {
	    	int maPhim = Integer.parseInt(request.getParameter("MaPhim"));
	    	int maPhongChieu = Integer.parseInt(request.getParameter("MaPhongChieu"));
	    	String dateString = request.getParameter("selectedDate");
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	Date ngayChieu = null;	
			try {
				ngayChieu = sdf.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	String gioChieu = request.getParameter("GioChieu");
	    	LichChieu lichchieu = new LichChieu(maPhongChieu, maPhim, maPhongChieu, ngayChieu, gioChieu);
	    	lcBo.ThemLichChieu(lichchieu);
	    	response.sendRedirect("LichChieuController");
	    	return;
	    }
		if(request.getParameter("UpdateLichChieu")!=null) {
			int maLichChieu = Integer.parseInt(request.getParameter("MaLichChieu"));
			int maPhim = Integer.parseInt(request.getParameter("MaPhim"));
	    	int maPhongChieu = Integer.parseInt(request.getParameter("MaPhongChieu"));
	    	String dateString = request.getParameter("selectedDate");
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	Date ngayChieu = null;	
			try {
				ngayChieu = sdf.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	String gioChieu = request.getParameter("GioChieu");
	    	LichChieu lichChieu = new LichChieu(maLichChieu, maPhim, maPhongChieu, ngayChieu, gioChieu);
	    	lcBo.UpdateLichChieu(lichChieu);
	    	response.sendRedirect("LichChieuController");
	    	return;
		}
		
		if(request.getParameter("DeleteLichChieu")!=null) {
			int maLichChieu = Integer.parseInt(request.getParameter("MaLichChieu"));
	    	lcBo.DeleteLichChieu(maLichChieu);
	    	response.sendRedirect("LichChieuController");
	    	return;
		}
		if(request.getParameter("btnDeleteLichChieu")!=null) {
	    	int maLichChieu = Integer.parseInt(request.getParameter("MaLichChieu"));
	    	LichChieu lichChieu = lcBo.getLichChieu_ID(maLichChieu);
	    	request.setAttribute("LichChieu", lichChieu);
	    	RequestDispatcher rd = request.getRequestDispatcher("AdminDeleteLichChieu.jsp");
	 	    rd.forward(request, response);
	 	    return;
    	}
	    if(request.getParameter("btnEditLichChieu")!=null) {
	    	int maLichChieu = Integer.parseInt(request.getParameter("MaLichChieu"));
	    	LichChieu lichChieu = lcBo.getLichChieu_ID(maLichChieu);
	    	request.setAttribute("LichChieu", lichChieu);
	    	 RequestDispatcher rd = request.getRequestDispatcher("AdminEditLichChieu.jsp");
	 	    rd.forward(request, response);
	 	    return;
    	}
	    
	    RequestDispatcher rd = request.getRequestDispatcher("AdminThemLichChieu.jsp");
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
