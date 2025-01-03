package PhimModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import KetNoi.KetNoi;

public class PhimDao {
	ArrayList<Phim> ds = new ArrayList<Phim>();
	public ArrayList<Phim> getPhim(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from Phim";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				ds.add(new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lấy ra danh sách tất cả các phim" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Phim> getPhimDangChieu(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from Phim\r\n"
					+ "where NgayPhatHanh <= GETDATE()";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				ds.add(new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lấy ra danh sách các phim đang chiếu" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Phim> getPhimChuanBiChieu(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from Phim\r\n"
					+ "where NgayPhatHanh > GETDATE()";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				ds.add(new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lấy ra danh sách các phim chuẩn bị chiếu" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Phim> getPhimDangChieuPagination(int pageCount,String search){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from  phim\r\n"
					+ "where NgayPhatHanh <= GETDATE() and\r\n"
					+ "	  (TenPhim like ? or DaoDien like ?)\r\n"
					+ "order by MaPhim offset (6*? -6) rows fetch next 6 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search +"%");
			cmd.setString(2, "%"+search +"%");
			cmd.setInt(3, pageCount);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				ds.add(new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lấy ra danh sách các phim dang chieu" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int getPageCountPhimDangChieu( String search) {
		try {
			int pagecount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select count(MaPhim) as pagecount\r\n"
					+ "from Phim\r\n"
					+ "where NgayPhatHanh <= GETDATE() and (TenPhim like ? or DaoDien like ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search +"%");
			cmd.setString(2, "%"+search +"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pagecount = rs.getInt("pagecount");
			}
			return pagecount;
		} catch (Exception e) {
			System.out.println("get số dòng theo searchValue" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	public ArrayList<Phim> getPhimSapChieuPagination(int pageCount,String search){
		try {
			ArrayList<Phim> dsPhimSapChieu = new ArrayList<Phim>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from  phim\r\n"
					+ "where NgayPhatHanh > GETDATE() and\r\n"
					+ "	  (TenPhim like ? or DaoDien like ?)\r\n"
					+ "order by MaPhim offset (6*? -6) rows fetch next 6 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search +"%");
			cmd.setString(2, "%"+search +"%");
			cmd.setInt(3, pageCount);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				dsPhimSapChieu.add(new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu));
			}
			rs.close();kn.cn.close();
			return dsPhimSapChieu;
		} catch (Exception e) {
			System.out.println("Lấy ra danh sách các phim sap chieu" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int getPageCountPhimSapChieu( String search) {
		try {
			int pagecount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select count(MaPhim) as pagecount\r\n"
					+ "from Phim\r\n"
					+ "where NgayPhatHanh > GETDATE() and (TenPhim like ? or DaoDien like ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search +"%");
			cmd.setString(2, "%"+search +"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pagecount = rs.getInt("pagecount");
			}
			return pagecount;
		} catch (Exception e) {
			System.out.println("get số dòng theo searchValue phim sap chieu" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public Phim get1Phim(int maPhim){
		try {
			Phim phim = null;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from Phim\r\n"
					+ "where NgayPhatHanh <= GETDATE() and MaPhim = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maPhim);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				phim = new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu);
			}
			rs.close();kn.cn.close();
			return phim;
		} catch (Exception e) {
			System.out.println("Lấy ra 1 bộ phim" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Phim> getPhim20Row(int page){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from Phim order by MaPhim offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				ds.add(new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get Phim với 20 Row theo Page" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Phim> getPhim20RowSearch(String SearchValue , int page){
		try {
			ArrayList<Phim> dsphim = new ArrayList<Phim>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * \r\n"
					+ "from Phim \r\n"
					+ "where Tenphim like ? or DaoDien like ? or DienVien like ?\r\n"
					+ "order by MaPhim offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+SearchValue+"%");
			cmd.setString(2,"%"+SearchValue+"%");
			cmd.setString(3,"%"+SearchValue+"%");
			cmd.setInt(4,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				dsphim.add(new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu));
			}
			rs.close();
			return dsphim;
		} catch (Exception e) {
			System.out.println("get Phim với 20 Row theo Search" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		}
	public int getPageCount() {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from Phim";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo Phim" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int getPageCountSearch(String SearchValue) {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from Phim where Tenphim like ? or DaoDien like ? or DienVien like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+SearchValue+"%");
			cmd.setString(2,"%"+SearchValue+"%");
			cmd.setString(3,"%"+SearchValue+"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo Search Phim" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int ThemPhim(Phim phim) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into Phim(TenPhim,MaTheLoai,DaoDien,DienVien,NgayPhatHanh,ThoiLuong,MoTa,Poster,LinkTrailer,NgonNgu)\r\n"
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, phim.getTenPhim());
			cmd.setInt(2, phim.getMaTheLoai());
			cmd.setString(3, phim.getDaoDien());
			cmd.setString(4, phim.getDienVien());
			java.sql.Date date = new java.sql.Date(phim.getNgayPhatHanh().getTime());
			cmd.setDate(5,date);
			cmd.setString(6, phim.getThoiLuong());
			cmd.setString(7, phim.getMoTa());
			cmd.setString(8, phim.getPoster());
			cmd.setString(9, phim.getLinkTrailer());
			cmd.setString(10, phim.getNgonNgu());
			
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			System.out.println("Them Phim" +e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public Phim Get1Phim(int maphim) {
		try {
			Phim phim = new Phim();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from Phim where MaPhim = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maphim);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				phim = new Phim(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, thoiluong, poster, LinkTrailer, Ngonngu);
			}
			rs.close();kn.cn.close();
			return phim;
		} catch (Exception e) {
			System.out.println("Lấy ra phim theo mã" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int UpdatePhim(Phim phim) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update Phim \r\n"
					+ "set TenPhim = ? , \r\n"
					+ "	MaTheLoai=?,\r\n"
					+ "	DaoDien=?,\r\n"
					+ "	DienVien=?,\r\n"
					+ "	NgayPhatHanh = ?,\r\n"
					+ "	ThoiLuong=?,\r\n"
					+ "	MoTa=?,\r\n"
					+ "	Poster=?,\r\n"
					+ "	LinkTrailer = ? ,\r\n"
					+ "	NgonNgu = ?\r\n"
					+ "where MaPhim = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, phim.getTenPhim());
			cmd.setInt(2, phim.getMaTheLoai());
			cmd.setString(3, phim.getDaoDien());
			cmd.setString(4, phim.getDienVien());
			java.sql.Date date = new java.sql.Date(phim.getNgayPhatHanh().getTime());
			cmd.setDate(5,date);
			cmd.setString(6, phim.getThoiLuong());
			cmd.setString(7, phim.getMoTa());
			cmd.setString(8, phim.getPoster());
			cmd.setString(9, phim.getLinkTrailer());
			cmd.setString(10, phim.getNgonNgu());
			cmd.setInt(11, phim.getMaPhim());
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			System.out.println("Update Phim" +e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int DeletePhim(int maPhim) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete Phim where MaPhim = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maPhim);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;		
		} catch (Exception e) {
			System.out.println("lỗi xoá phim "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
