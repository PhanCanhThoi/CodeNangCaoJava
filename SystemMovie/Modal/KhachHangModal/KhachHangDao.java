package KhachHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoi.KetNoi;
import PhimModal.Phim;

public class KhachHangDao {
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
	public long getmakh(String tendn, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			long makh = 0;
			if (rs.next()) {
                makh = rs.getLong("MaKhachHang");
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
}
