package HoaDonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import KetNoi.KetNoi;

public class HoaDonDao {
	public int AddHoaDon(int MaHoaDon) {
		try {
			int mahd=0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into HoaDon(MaKhachHang,NgayDatVe)\r\n"
					+ "values(?,GETDATE())";
			PreparedStatement cmd = kn.cn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			cmd.setInt(1, MaHoaDon);
			int rs = cmd.executeUpdate();
			if(rs>0) {
				ResultSet result= cmd.getGeneratedKeys();
				while(result.next()) {
					mahd = result.getInt(1);
				}
			}
			return mahd;
		} catch (Exception e) {
			System.out.println("Lỗi add hoá đơn "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
		

	}
}
