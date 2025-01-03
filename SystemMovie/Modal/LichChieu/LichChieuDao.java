package LichChieu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoi.KetNoi;

public class LichChieuDao {
	public ArrayList<LichChieu> getLichChieu20Row(int page){
		try {
			ArrayList<LichChieu> ds = new ArrayList<LichChieu>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select LichChieu.*,TenPhim,TenPhongChieu from LichChieu inner join Phim on LichChieu.MaPhim=Phim.MaPhim inner join PhongChieu on PhongChieu.MaPhongChieu = LichChieu.MaPhongChieu order by MaLichChieu offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				 int MaLichChieu = rs.getInt("MaLichChieu");
				 int MaPhim = rs.getInt("MaPhim");
				 int MaPhongChieu = rs.getInt("MaPhongChieu");
				 String TenPhongChieu =rs.getString("TenPhongChieu");
				 String TenPhim = rs.getString("TenPhim");
				 Date NgayChieu = rs.getDate("NgayChieu");
				 String GioChieu = rs.getString("GioChieu");
				 ds.add(new LichChieu(MaLichChieu, MaPhim, MaPhongChieu, TenPhongChieu, TenPhim, NgayChieu, GioChieu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get Lich Chieu với 20 Row theo Page" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<LichChieu> getLichChieu20RowSearch(String Search , int page){
		try {
			ArrayList<LichChieu> ds = new ArrayList<LichChieu>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select LichChieu.*,TenPhim,TenPhongChieu from LichChieu inner join Phim on LichChieu.MaPhim=Phim.MaPhim inner join PhongChieu on PhongChieu.MaPhongChieu = LichChieu.MaPhongChieu where TenPhim like ? order by MaLichChieu offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+Search+"%");
			cmd.setInt(2, page);
			ResultSet rs = cmd.executeQuery();		
			while(rs.next()) {
				int MaLichChieu = rs.getInt("MaLichChieu");
				 int MaPhim = rs.getInt("MaPhim");
				 int MaPhongChieu = rs.getInt("MaPhongChieu");
				 String TenPhongChieu =rs.getString("TenPhongChieu");
				 String TenPhim = rs.getString("TenPhim");
				 Date NgayChieu = rs.getDate("NgayChieu");
				 String GioChieu = rs.getString("GioChieu");
				 ds.add(new LichChieu(MaLichChieu, MaPhim, MaPhongChieu, TenPhongChieu, TenPhim, NgayChieu, GioChieu));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get Lịch Chiếu với 20 Row theo Search" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int getPageCount() {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from LichChieu inner join Phim on LichChieu.MaPhim=Phim.MaPhim inner join PhongChieu on PhongChieu.MaPhongChieu = LichChieu.MaPhongChieu";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo Lịch chiếu" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int getPageCountSearch(String searchValue) {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from LichChieu inner join Phim on LichChieu.MaPhim=Phim.MaPhim inner join PhongChieu on PhongChieu.MaPhongChieu = LichChieu.MaPhongChieu where TenPhim like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+searchValue+"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();kn.cn.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo Lịch Chiếu" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
