package PhongChieuModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoi.KetNoi;

public class PhongChieuDao {
	public ArrayList<PhongChieu> getPhongChieu(){
		try {
			ArrayList<PhongChieu> ds = new ArrayList<PhongChieu>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = " select * from PhongChieu";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				 int MaPhongChieu = rs.getInt("MaPhongChieu");
				 String TenPhongChieu = rs.getString("TenPhongChieu");
				 int SoChoNgoi = rs.getInt("SoChoNgoi");
				 boolean TinhTrang = rs.getBoolean("TinhTrang");
				 String HinhAnh = rs.getString("HinhAnh");
				 ds.add(new PhongChieu(MaPhongChieu, TenPhongChieu, SoChoNgoi, TinhTrang, HinhAnh));
			}
			kn.cn.close();
			rs.close();
			return ds;
			
		} catch (Exception e) {
			System.out.println("Get phòng chiếu "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
