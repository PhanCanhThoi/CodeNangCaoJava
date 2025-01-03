package LichChieuModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoi.KetNoi;
import PhimModal.Phim;

public class LichChieuDao {
	ArrayList<LichChieu> ds = new ArrayList<LichChieu>();
	public ArrayList<LichChieu> getLichChieuTheoPhim_Ngay(int maPhim,Date ngay){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from LichChieu where MaPhim=? and NgayChieu = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,maPhim);
			cmd.setDate(2, ngay);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int malichchieu = rs.getInt("MaLichChieu");
				int maphim = rs.getInt("MaPhim");
				int maphong = rs.getInt("MaPhongChieu");
				Date ngaychieu = rs.getDate("NgayChieu");
				String gioichiu = rs.getString("GioChieu");
				ds.add(new LichChieu(malichchieu, maphim, maphong, ngaychieu, gioichiu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lấy ra danh sách lịch chiếu theo mã phim + ngày " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	public int ThemLichChieu(LichChieu lichChieu) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into LichChieu(MaPhim,MaPhongChieu,NgayChieu,GioChieu)\r\n"
					+ "values(?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, lichChieu.getMaPhim());
			cmd.setInt(2, lichChieu.getMaPhongChieu());
			Date ngaychieu = new Date(lichChieu.getNgayChieu().getTime());
			cmd.setDate(3, ngaychieu);
			cmd.setString(4, lichChieu.getGioChieu());
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			System.out.println("Them Lịch Chiếu" +e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public LichChieu getLichChieu_ID(int maLichChieu) {
		try {
			LichChieu lichChieu = new LichChieu();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from LichChieu where MaLichChieu = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maLichChieu);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				maLichChieu = rs.getInt("MaLichChieu");
				int MaPhim = rs.getInt("MaPhim");
				int MaPhongChieu = rs.getInt("MaPhongChieu");
				java.util.Date ngaychieu = rs.getDate("NgayChieu");
				String giochieu = rs.getString("GioChieu");
				lichChieu = new LichChieu(maLichChieu, MaPhim, MaPhongChieu, ngaychieu, giochieu);
			}
			rs.close();kn.cn.close();
			return lichChieu;
		} catch (Exception e) {
			System.out.println("Lấy ra lịch chiếu theo mã" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int UpdateLichChieu(LichChieu lichChieu) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update LichChieu \r\n"
					+ "set MaPhim=?,\r\n"
					+ "MaPhongChieu=?,\r\n"
					+ "NgayChieu=?,\r\n"
					+ "GioChieu=?\r\n"
					+ "where MaLichChieu =?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, lichChieu.getMaPhim());
			cmd.setInt(2, lichChieu.getMaPhongChieu());
			Date ngaychieu = new Date(lichChieu.getNgayChieu().getTime());
			cmd.setDate(3, ngaychieu);
			cmd.setString(4, lichChieu.getGioChieu());
			cmd.setInt(5, lichChieu.getMaLichChieu());
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			System.out.println("Update Lich Chiếu" +e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int DeleteLichChieu(int maLichChieu) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete LichChieu where MaLichChieu = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maLichChieu);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;		
		} catch (Exception e) {
			System.out.println("lỗi xoá lịch chiếu "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
