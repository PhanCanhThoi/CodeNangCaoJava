package AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KhachHangModal.KhachHangBo;
import PhimModal.PhimBo;
import VeXemPhimModal.VeXemPhimBo;

/**
 * Servlet implementation class AdminTrangChuController
 */
@WebServlet("/AdminTrangChuController")
public class AdminTrangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTrangChuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhimBo phimBo = new PhimBo();
		VeXemPhimBo veBo = new VeXemPhimBo();
		KhachHangBo khBo = new KhachHangBo();
		int tongphim = phimBo.getPageCount();
		request.setAttribute("tongPhim",tongphim);
		int tongKh = khBo.getPageCount();
		request.setAttribute("tongKhachHang",tongKh);
		long tongDoanhThu_Thang = veBo.CountVe_Thang()*45000;
		request.setAttribute("ThongKeThang", tongDoanhThu_Thang);
		RequestDispatcher rd = request.getRequestDispatcher("AdminTrangChu.jsp");
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
