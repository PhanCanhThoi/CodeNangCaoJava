package Phim_TheLoai_Modal;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoi.KetNoi;
import PhimModal.Phim;

public class Phim_TheLoaiDao {
	ArrayList<Phim_TheLoai> ds = new ArrayList<Phim_TheLoai>();
	public Phim_TheLoai get1Phim(int maPhim){
		try {
			Phim_TheLoai phim_TheLoai = null;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from Phim_TheLoai\r\n"
					+ "where MaPhim = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, maPhim);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int maphim = rs.getInt("MaPhim");
				String tenphim = rs.getString("TenPhim");
				int matheloai = rs.getInt("MaTheLoai");
				String daodien = rs.getString("DaoDien");
				String dienvien = rs.getString("DienVien");
				Date ngayphathanh = rs.getDate("NgayPhatHanh");
				String thoiluong = rs.getString("ThoiLuong");
				String MoTa = rs.getString("MoTa");
				String poster = rs.getString("Poster");
				String LinkTrailer  =rs.getString("LinkTrailer");
				String Ngonngu = rs.getString("NgonNgu");
				String tenloai = rs.getString("TenTheLoai");
				phim_TheLoai = new Phim_TheLoai(maphim, tenphim, matheloai, daodien, dienvien, ngayphathanh, thoiluong, MoTa, poster, LinkTrailer, Ngonngu, tenloai);
			}
			rs.close();kn.cn.close();
			return phim_TheLoai;
		} catch (Exception e) {
			System.out.println("Lấy ra 1 bộ phim + Thể loại " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
