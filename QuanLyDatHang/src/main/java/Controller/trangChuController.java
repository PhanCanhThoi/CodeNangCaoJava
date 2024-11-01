package Controller;

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

import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import SachModal.Sach;
import SachModal.SachBo;

/**
 * Servlet implementation class trangChuController
 */
@WebServlet("/trangChuController")
public class trangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trangChuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tra ve cac tat ca loai
		HttpSession session = request.getSession();
		ArrayList<Loai> dsl = new ArrayList<Loai>();
		LoaiBo lbo = new LoaiBo();
		dsl=lbo.getLoai();
		session.setAttribute("dsl", dsl);		

		
		// TRA VE DANH SACH HIEN THI
		String ml = (String)request.getParameter("ml");
		String searchsach = request.getParameter("search-sach");
		SachBo sach =new SachBo();
		ArrayList<Sach> listSearch = new ArrayList<Sach>();
		if(searchsach!=null){
			listSearch = sach.Tim(searchsach);
		}
		if(ml!=null){
			listSearch = sach.timMa(ml);
		}
		if(ml==null && searchsach == null ){
			listSearch = sach.getSach();
		}
		request.setAttribute("listSearch", listSearch);		
		
		//dang nhap
		String tendn = request.getParameter("txtTenDn");
		String mk = request.getParameter("txtMk");
		session.setAttribute("tendn", tendn);
		session.setAttribute("mk", mk);
		RequestDispatcher rd = request.getRequestDispatcher("tc.jsp");
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
