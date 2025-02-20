package KhachHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoi.KetNoi;
import PhimModal.Phim;

public class KhachHangDao {
	
	public int getPageCountKh() {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo khach hàng" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<KhachHang> getKhachHang20Row(int page){
		try {
			
			
			ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang order by MaKhachHang offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				 int MaKhachHang = rs.getInt("MaKhachHang");
				 String TenKhachHang = rs.getString("TenKhachHang");
				 String Email = rs.getString("Email");
				 String SoDienThoai = rs.getString("SoDienThoai");
				 Date NgaySinh = rs.getDate("NgaySinh");
				 boolean GioiTinh = rs.getBoolean("GioiTinh");
				 String DiaChi = rs.getString("DiaChi");
				 String TenDangNhap = rs.getString("TenDangNhap");
				 String MatKhau = rs.getString("MatKhau");
				 ds.add(new KhachHang(MaKhachHang, TenKhachHang, Email, SoDienThoai, NgaySinh, GioiTinh, DiaChi, TenDangNhap, MatKhau));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get Khach Hàng với 20 Row theo Page" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<KhachHang> getKhachHang(){
		try {
			
			
			ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				 int MaKhachHang = rs.getInt("MaKhachHang");
				 String TenKhachHang = rs.getString("TenKhachHang");
				 String Email = rs.getString("Email");
				 String SoDienThoai = rs.getString("SoDienThoai");
				 Date NgaySinh = rs.getDate("NgaySinh");
				 boolean GioiTinh = rs.getBoolean("GioiTinh");
				 String DiaChi = rs.getString("DiaChi");
				 String TenDangNhap = rs.getString("TenDangNhap");
				 String MatKhau = rs.getString("MatKhau");
				 ds.add(new KhachHang(MaKhachHang, TenKhachHang, Email, SoDienThoai, NgaySinh, GioiTinh, DiaChi, TenDangNhap, MatKhau));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get Khach Hàng với 20 Row theo Page" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<KhachHang> getKhachHang20RowSearch(String Search , int page){
		try {
			ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang where TenKhachHang like ? order by MaKhachHang offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+Search+"%");
			cmd.setInt(2, page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				 int MaKhachHang = rs.getInt("MaKhachHang");
				 String TenKhachHang = rs.getString("TenKhachHang");
				 String Email = rs.getString("Email");
				 String SoDienThoai = rs.getString("SoDienThoai");
				 Date NgaySinh = rs.getDate("NgaySinh");
				 boolean GioiTinh = rs.getBoolean("GioiTinh");
				 String DiaChi = rs.getString("DiaChi");
				 String TenDangNhap = rs.getString("TenDangNhap");
				 String MatKhau = rs.getString("MatKhau");
				 ds.add(new KhachHang(MaKhachHang, TenKhachHang, Email, SoDienThoai, NgaySinh, GioiTinh, DiaChi, TenDangNhap, MatKhau));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get Khach Hàng với 20 Row theo Search" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int getPageCount() {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo Khach Hàng" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int getPageCountSearch(String searchValue) {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from KhachHang where TenKhachHang like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+searchValue+"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();kn.cn.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo Phim" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public KhachHang getKhachHang_Ma(int makh) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			KhachHang kh = new KhachHang();
			String sql = "select * from KhachHang where MaKhachHang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, makh);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				int MaKhachHang = rs.getInt("MaKhachHang");
				 String TenKhachHang = rs.getString("TenKhachHang");
				 String Email = rs.getString("Email");
				 String SoDienThoai = rs.getString("SoDienThoai");
				 Date NgaySinh = rs.getDate("NgaySinh");
				 boolean GioiTinh = rs.getBoolean("GioiTinh");
				 String DiaChi = rs.getString("DiaChi");
				 String TenDangNhap = rs.getString("TenDangNhap");
				 String MatKhau = rs.getString("MatKhau");
				 kh = new KhachHang(MaKhachHang, TenKhachHang, Email, SoDienThoai, NgaySinh, GioiTinh, DiaChi, TenDangNhap, MatKhau);
			}
			rs.close();kn.cn.close();
			return kh;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra khách hàng theo mã" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public KhachHang getKhachHang_Account(String tendn, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			KhachHang kh = new KhachHang();
			String sql = "select * from KhachHang where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				int MaKhachHang = rs.getInt("MaKhachHang");
				 String TenKhachHang = rs.getString("TenKhachHang");
				 String Email = rs.getString("Email");
				 String SoDienThoai = rs.getString("SoDienThoai");
				 Date NgaySinh = rs.getDate("NgaySinh");
				 boolean GioiTinh = rs.getBoolean("GioiTinh");
				 String DiaChi = rs.getString("DiaChi");
				 String TenDangNhap = rs.getString("TenDangNhap");
				 String MatKhau = rs.getString("MatKhau");
				 kh = new KhachHang(MaKhachHang, TenKhachHang, Email, SoDienThoai, NgaySinh, GioiTinh, DiaChi, TenDangNhap, MatKhau);
			}
			rs.close();kn.cn.close();
			return kh;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int getmakh(String tendn, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			int makh = 0;
			if (rs.next()) {
                makh = rs.getInt("MaKhachHang");
            }
			rs.close();kn.cn.close();
			return makh;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("get ma khach hàng" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int AddKhachHang(String tenKhachHang, String email, String soDienThoai, Date ngaySinh,
			boolean gioiTinh, String diaChi, String tenDangNhap, String matKhau) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into KhachHang(TenKhachHang,Email,SoDienThoai,NgaySinh,GioiTinh,DiaChi,TenDangNhap,MatKhau)\r\n"
					+ "values(?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenKhachHang);
			cmd.setString(2, email);
			cmd.setString(3, soDienThoai);
			java.sql.Date date = new java.sql.Date(ngaySinh.getTime());
			cmd.setDate(4, date);
			cmd.setBoolean(5, gioiTinh);
			cmd.setString(6, diaChi);
			cmd.setString(7, tenDangNhap);
			cmd.setString(8, matKhau);
			int x = cmd.executeUpdate();
			kn.cn.close();
			return x;
		} catch (Exception e) {
			System.out.println("Lỗi thêm khách hàng" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int Update(int maKhachHang,String tenKhachHang, String email, String soDienThoai, Date ngaySinh,
			boolean gioiTinh, String diaChi, String tenDangNhap) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "\r\n"
					+ "update KhachHang\r\n"
					+ "set TenKhachHang=?,\r\n"
					+ "	Email=?,\r\n"
					+ "	SoDienThoai=?,\r\n"
					+ "	NgaySinh=?,\r\n"
					+ "	GioiTinh=?,\r\n"
					+ "	DiaChi=?,\r\n"
					+ "	TenDangNhap=?\r\n"
					+ "where MaKhachHang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenKhachHang);
			cmd.setString(2, email);
			cmd.setString(3, soDienThoai);
			java.sql.Date date = new java.sql.Date(ngaySinh.getTime());
			cmd.setDate(4, date);
			cmd.setBoolean(5, gioiTinh);
			cmd.setString(6, diaChi);
			cmd.setString(7, tenDangNhap);
			cmd.setInt(9, maKhachHang);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			System.out.println("Update khach hàng "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int delete(int makh) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete KhachHang where MaKhachHang = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, makh);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			System.out.println("Update khach hàng "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
