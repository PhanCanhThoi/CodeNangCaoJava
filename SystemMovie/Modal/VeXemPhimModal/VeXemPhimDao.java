package VeXemPhimModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import KetNoi.KetNoi;

public class VeXemPhimDao {
	public int AddVeXemPhim(int maGhe,int maLichChieu,int MaPhim, int maHoaDon) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into VeXemPhim(MaGhe,MaLichChieu,TrangThai,MaPhim,MaHoaDon)\r\n"
					+ "values(?,?,0,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maGhe);
			cmd.setInt(2, maLichChieu);
			cmd.setInt(3,MaPhim);
			cmd.setInt(4, maHoaDon);
			int x = cmd.executeUpdate();
			return x;
		} catch (Exception e) {
			System.out.println("Lỗi thêm vé xem phim "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int CountVe_Thang() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			int count = 0;
			String sql = "select COUNT(MaVe) from vexemphim inner join lichchieu on vexemphim.MaLichChieu = LichChieu.MaLichChieu\r\n"
					+ "where YEAR(NgayChieu) = YEAR(GETDATE()) and MONTH(NgayChieu) = MONTH(GETDATE())";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			kn.cn.close();
			return count;
		} catch (Exception e) {
			System.out.println("Lỗi count vé xem phim "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int Update(int mave) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update VeXemPhim set TrangThai = 1 where MaVe = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, mave);
			int x = cmd.executeUpdate();
			kn.cn.close();
			return x;
		} catch (Exception e) {
			System.out.println("Lỗi update vé "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}	
