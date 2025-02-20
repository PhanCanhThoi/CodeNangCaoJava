package Account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DangNhapModal.DangNhap;
import DangNhapModal.DangNhapBo;
import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("dem")==null) {
			session.setAttribute("dem", (int)0);
		}//gán đếm capcha nếu chạy lần đầu
		String tendn = request.getParameter("txtTenDn");
		String mk = request.getParameter("txtMk");
		if(tendn!=null && mk!=null) {
			DangNhapBo dnBo = new DangNhapBo();
			String pass = dnBo.HashMatKhau(mk);
			DangNhap Admin = dnBo.getAdmin_Account(tendn, pass);
			if(Admin.getTenDangNhap()!=null) {
				System.out.println("Đang nhập admin thành công");
				if((int)session.getAttribute("dem")>=3) {
					Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					request.setCharacterEncoding("UTF-8");
					String answer = request.getParameter("answer");
					if(captcha.isCorrect(answer)) {
						session.setAttribute("checkDn", (boolean)true);
						session.setAttribute("AdminAccount", Admin);
						response.sendRedirect("AdminTrangChuController");
						if((int)session.getAttribute("dem")!=0) {
							session.removeAttribute("dem");
						}
						return;
					}
				}
				else {
				session.setAttribute("checkDn", (boolean)true);
				session.setAttribute("AdminAccount", Admin);
				if((int)session.getAttribute("dem")!=0||session.getAttribute("dem")==null) {
					session.removeAttribute("dem");
				}
				response.sendRedirect("AdminTrangChuController");
				return;
				}
			}else {
				KhachHangBo khbo = new KhachHangBo();
				KhachHang kh_Account = khbo.getKhachHang_Account(tendn, pass);
				int makh = khbo.getmakh(tendn, pass);
				if(kh_Account.getTenDangNhap()!=null) {
					if((int)session.getAttribute("dem")>=3) {
						Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
						request.setCharacterEncoding("UTF-8");
						String answer = request.getParameter("answer");
						if(captcha.isCorrect(answer)) {
							session.setAttribute("makh", makh);
							session.setAttribute("checkDn", (boolean)true);
							session.setAttribute("KhAccount",kh_Account);
							response.sendRedirect("TrangChuController");
							if((int)session.getAttribute("dem")!=0) {
								session.removeAttribute("dem");
							}
							return;
						}
					}
					else {
					session.setAttribute("makh", makh);
					session.setAttribute("checkDn", (boolean)true);
					session.setAttribute("KhAccount", kh_Account);
					if((int)session.getAttribute("dem")!=0||session.getAttribute("dem")==null) {
						session.removeAttribute("dem");
					}
					if(session.getAttribute("url")!=null) {
						response.sendRedirect((String)session.getAttribute("url"));
						return;
					}
					response.sendRedirect("TrangChuController");
					return;
					}
				}else {
					int d =(int) session.getAttribute("dem");	
					d++;session.setAttribute("dem", d);
					session.setAttribute("tb", "Đăng nhập sai");
				}		
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
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
