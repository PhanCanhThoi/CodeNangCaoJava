package AdminController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ThongKePhim_SoLuongModal.ThongKe;
import ThongKePhim_SoLuongModal.ThongKeBo;

/**
 * Servlet implementation class ThongKeController
 */
@WebServlet("/ThongKeController")
public class ThongKeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThongKeBo tkBo = new ThongKeBo();
		ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
		ds = tkBo.TkPhim_SoLuong();
		request.setAttribute("ThongKeVe_SoLuong", ds);
		RequestDispatcher rd = request.getRequestDispatcher("AdminThongKeVe.jsp");
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
