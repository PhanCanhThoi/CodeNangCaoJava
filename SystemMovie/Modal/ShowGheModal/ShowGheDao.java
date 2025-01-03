package ShowGheModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoi.KetNoi;

public class ShowGheDao {
	ArrayList<ShowGhe> ds = new ArrayList<ShowGhe>();
	public ArrayList<ShowGhe> getGhe(int maLichChieu,int maPhongChieu){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "SELECT g.MaGhe, g.TenGhe, ISNULL(v.TrangThai, 0) as TinhTrang\r\n"
					+ "FROM Ghe g\r\n"
					+ "LEFT JOIN VeXemPhim v ON g.MaGhe = v.MaGhe AND v.MaLichChieu = ?\r\n"
					+ "WHERE g.MaPhongChieu = ? order by TenGhe asc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maLichChieu);
			cmd.setInt(2, maPhongChieu);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maghe = rs.getInt("MaGhe");
				String tenghe = rs.getString("TenGhe");
				boolean trangthai = rs.getBoolean("TinhTrang");
				ds.add(new ShowGhe(maghe, tenghe, trangthai));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Ghet ghe" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
