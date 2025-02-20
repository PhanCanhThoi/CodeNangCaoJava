package LichSuDatVeModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoi.KetNoi;

public class LichSuDatVeDao {
	public ArrayList<LichSuDatVe> getVe_TrangThai(int makh,boolean trangthai,int check){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			ArrayList<LichSuDatVe> ds = new ArrayList<LichSuDatVe>();
			String sql = "";
			if(check==0) {
				sql="select * from LichSuDatVe	\r\n"
						+ "where TrangThai = ? and MaKhachHang=? and NgayChieu>= GETDATE()";
			}else if(check==-1){
				sql ="select * from LichSuDatVe	\r\n"
						+ "where TrangThai = ? and MaKhachHang=? and NgayChieu < GETDATE()";
			}else {
				sql ="select * from LichSuDatVe	\r\n"
						+ "where TrangThai = ? and MaKhachHang=? and NgayChieu >= GETDATE()";
			}
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setBoolean(1, trangthai);
			cmd.setInt(2, makh);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String tenphim = rs.getString("TenPhim");
				Date ngaydatve = rs.getDate("NgayDatVe");
				Date ngaychieu = rs.getDate("NgayChieu");
				int mave = rs.getInt("MaVe");
				String tenghe = rs.getString("TenGhe");
				String TenPhongChieu = rs.getString("TenPhongChieu");
				String gichieu = rs.getString("GioChieu");
				ds.add(new LichSuDatVe(mave, makh, trangthai, tenphim, tenghe, TenPhongChieu, gichieu, ngaydatve, ngaychieu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lỗi get lịch sử đặt vé "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<LichSuDatVe> GetVe(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			ArrayList<LichSuDatVe> ds = new ArrayList<LichSuDatVe>();
			String sql = "select * from LichSuDatVe where TrangThai = 0";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String tenphim = rs.getString("TenPhim");
				Date ngaydatve = rs.getDate("NgayDatVe");
				Date ngaychieu = rs.getDate("NgayChieu");
				int mave = rs.getInt("MaVe");
				String tenghe = rs.getString("TenGhe");
				String TenPhongChieu = rs.getString("TenPhongChieu");
				String gichieu = rs.getString("GioChieu");
				int makh = rs.getInt("MaKhachHang");
				boolean trangthai = rs.getBoolean("TrangThai");
				ds.add(new LichSuDatVe(mave, makh, trangthai, tenphim, tenghe, TenPhongChieu, gichieu, ngaydatve, ngaychieu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lỗi get lịch sử đặt vé "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
