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

import SachModal.Sach;
import SachModal.SachBo;
import temp.CgioHang;

/**
 * Servlet implementation class xoaSuaController
 */
@WebServlet("/xoaSuaController")
public class xoaSuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaSuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//xoa sach
		if(request.getParameter("buttonXoa")!=null){
			String masach = request.getParameter("masach");
			SachBo sach = new SachBo();
			ArrayList<Sach> ds = new ArrayList<Sach>();
			ds = sach.getSach();
			for(int i = 0 ; i < ds.size() ; i++){
				if(masach.equals(ds.get(i).getMaSach())){
					CgioHang gh = new CgioHang();
					gh = (CgioHang)session.getAttribute("gh");
					gh.xoa(masach);
					session.setAttribute("gh",gh);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
		}
		
		
			//EDIT 1 HÀNG 
				if(request.getParameter("buttonEdit")!=null){
					String msSua = request.getParameter("buttonEdit");
					long slSua =Long.parseLong(request.getParameter(msSua));
					CgioHang cgio = new CgioHang();
					cgio = (CgioHang)session.getAttribute("gh");
					cgio.sua(msSua,slSua);
					RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
				}
		
				//Xoa theo từng item
				if(request.getParameter("xoaItem")!=null){
					String[] listItem = request.getParameterValues("checkbox");
					CgioHang cgio = new CgioHang();
					cgio = (CgioHang)session.getAttribute("gh");
					for(String item : listItem){
						cgio.xoa(item);
					}
					session.setAttribute("gh",cgio);
					RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
				}
				
				//Xoá tất cả hàng trong giỏ hàng
				if(request.getParameter("deleteAll")!=null){
					session.setAttribute("gh", null);
					RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
				}
				
				
		RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
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
