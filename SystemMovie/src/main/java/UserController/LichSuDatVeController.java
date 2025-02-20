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

import LichSuDatVeModal.LichSuDatVe;
import LichSuDatVeModal.LichSuDatVeBo;
import LichSuDatVeModal.LichSuDatVeDao;

/**
 * Servlet implementation class LichSuDatVeController
 */
@WebServlet("/LichSuDatVeController")
public class LichSuDatVeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuDatVeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LichSuDatVeBo lsBo = new LichSuDatVeBo();
		ArrayList<LichSuDatVe> ds = new ArrayList<LichSuDatVe>();
		int active = 0;
		int makh = (int)session.getAttribute("makh");
		ds=lsBo.getLichSu_TrangThai(makh, false,active);
		session.setAttribute("dsLichSu", ds);
		if(request.getParameter("btnVeChoXacNhan")!=null) {
			active = Integer.parseInt(request.getParameter("btnVeChoXacNhan"));
			ds=lsBo.getLichSu_TrangThai(makh, false,active);
			session.setAttribute("dsLichSu", ds);
		}
		if(request.getParameter("btnVeDaDat")!=null) {
			active = Integer.parseInt(request.getParameter("btnVeDaDat"));
			ds=lsBo.getLichSu_TrangThai(makh, true,active);
			session.setAttribute("dsLichSu", ds);
		}
		if(request.getParameter("btnVeDaXem")!=null) {
			active = Integer.parseInt(request.getParameter("btnVeDaXem"));
			ds=lsBo.getLichSu_TrangThai(makh, true,active);
			session.setAttribute("dsLichSu", ds);
		}
		request.setAttribute("active", active);
		RequestDispatcher rd = request.getRequestDispatcher("LichSuDatVe.jsp");
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
