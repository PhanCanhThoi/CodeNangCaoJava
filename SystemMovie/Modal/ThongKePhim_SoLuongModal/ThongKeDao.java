package ThongKePhim_SoLuongModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoi.KetNoi;

public class ThongKeDao {
	public ArrayList<ThongKe> TkPhim_SoLuong() {
		try {
			ArrayList<ThongKe> ds = new ArrayList<ThongKe>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select TenPhim,COUNT(TenPhim) as SoLuong from VeXemPhim inner join Phim on VeXemPhim.MaPhim = phim.MaPhim\r\n"
					+ "group by TenPhim ";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String tenphim = rs.getString("TenPhim");
				int soluong = rs.getInt("SoLuong");
				ds.add(new ThongKe(tenphim, soluong));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Thong kê theo số luong "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
