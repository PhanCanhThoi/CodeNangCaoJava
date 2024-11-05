package ChiTietHoaDonModal;

import java.sql.PreparedStatement;

import KetNoiModal.KetNoi;

public class ChiTietHoaDonDao {
	public int addChiTietHoaDon(String masach , long slmua , int maHoaDon) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon) values(?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setLong(2, slmua);
			cmd.setInt(3, maHoaDon);
			int rs= cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			System.out.println("them chi tiết hoa don"+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
