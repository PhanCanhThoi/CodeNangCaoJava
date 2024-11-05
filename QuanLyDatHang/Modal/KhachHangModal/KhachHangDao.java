package KhachHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModal.KetNoi;

public class KhachHangDao {
	ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
	public ArrayList<KhachHang> getKhachHang(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("makh");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sodt");
				String email = rs.getString("email");
				String tendn = rs.getString("tendn");
				String pass = rs.getString("pass");
				ds.add(new KhachHang(id, hoten, diachi, sdt, email, tendn, pass));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách khách hàng" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
}
