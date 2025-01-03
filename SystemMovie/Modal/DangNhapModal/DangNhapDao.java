package DangNhapModal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoi.KetNoi;


public class DangNhapDao {
	ArrayList<DangNhap> ds = new ArrayList<DangNhap>();
	public ArrayList<DangNhap> getDangNhap(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from DangNhap";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String TenDn = rs.getString("TenDangNhap");
				String Mk = rs.getString("MatKhau");
				ds.add(new DangNhap(TenDn, Mk));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	public DangNhap getAdmin_Account(String tendn , String pass){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			DangNhap dn = new DangNhap();
			String sql = "select * from DangNhap where TenDangNhap=? and Password=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				String TenDangNhap = rs.getString("TenDangNhap");
				String Password = rs.getString("Password");
				dn = new DangNhap(TenDangNhap, Password);
			}
			rs.close();kn.cn.close();
			return dn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	public long getMaKh(String tendn , String pass){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from DangNhap where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			long makh=0;
			while(rs.next()) {
				makh=rs.getLong("MaKhachHang");
			}
			rs.close();kn.cn.close();
			return makh;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
	}

}
