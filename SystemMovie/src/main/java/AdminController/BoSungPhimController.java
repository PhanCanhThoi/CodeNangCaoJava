package AdminController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import PhimModal.Phim;
import PhimModal.PhimBo;

/**
 * Servlet implementation class BoSungPhimController
 */
@WebServlet("/BoSungPhimController")
public class BoSungPhimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoSungPhimController() {
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
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			 String TenPhim="", DaoDien="", DienVien ="", ThoiLuong = "",MoTa="",Poster="",Trailer = "" , NgonNgu = "";
			 int MaTheLoai = 0; Date NgayPhatHanh = null;
			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					 if (!fileItem.isFormField()) {
						 String nameimg = fileItem.getName();
						 Poster = "images/"+nameimg;
						 if (!nameimg.equals("")) {
							 String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "images";
								File dir = new File(dirUrl);
								if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
									dir.mkdir();
								}
								String fileImg = dirUrl + File.separator + nameimg;
								File file = new File(fileImg);
								try {
						               fileItem.write(file);//lưu file
						              System.out.println("UPLOAD THÀNH CÔNG...!");
						              System.out.println("Đường dẫn lưu file là: "+dirUrl);
						 } catch (Exception e) {
						    e.printStackTrace();
						}
						 }
					 }else//Neu la control
					 	{
						 String tentk=fileItem.getFieldName();
							if(tentk.equals("TenPhim"))
								TenPhim = fileItem.getString();
							if(tentk.equals("DaoDien"))
								DaoDien = fileItem.getString();
							if(tentk.equals("DienVien"))
								DienVien = fileItem.getString();
							if(tentk.equals("ThoiLuong"))
								ThoiLuong = fileItem.getString();
							if(tentk.equals("MoTa"))
								MoTa = fileItem.getString();
							if(tentk.equals("Trailer"))
								Trailer = fileItem.getString();
							if(tentk.equals("NgonNgu"))
								NgonNgu  = fileItem.getString();
							if(tentk.equals("MaLoai"))
								MaTheLoai  = Integer.parseInt(fileItem.getString());
							if(tentk.equals("selectedDate")) {
								String dateString = fileItem.getString();
							    if (!dateString.isEmpty()) {
							        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							        try {
							            NgayPhatHanh = sdf.parse(dateString);
							        } catch (Exception e) {
							            e.printStackTrace();
							        }
							    } else {
							        System.out.println("Ngày phát hành không được để trống.");
							    }
							}
					} 
				}
				}catch (Exception e) {
				e.printStackTrace();
			}	
			Phim phim = new Phim(MaTheLoai, TenPhim, MaTheLoai, DaoDien, DienVien, NgayPhatHanh, ThoiLuong, MoTa, Poster, Trailer, NgonNgu);
			PhimBo phimBo = new PhimBo();
			phimBo.ThemPhim(phim);
			response.sendRedirect("PhimController");
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
