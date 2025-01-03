package TheLoaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import KetNoi.KetNoi;
import PhimModal.Phim;

public class TheLoaiDao {
	ArrayList<TheLoai> ds = new ArrayList<TheLoai>();
	public ArrayList<TheLoai> getTheLoai(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from TheLoai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int matheloai = rs.getInt("MaTheLoai");
				String tentheloai = rs.getString("TenTheLoai");
				ds.add(new TheLoai(matheloai, tentheloai));
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("Lấy danh sách thể loại" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<TheLoai> getLoai20Row(int page){
		try {
			ArrayList<TheLoai> dsLoai = new ArrayList<TheLoai>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from TheLoai order by MaTheLoai offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int matheloai = rs.getInt("MaTheLoai");
				String tentheloai = rs.getString("TenTheLoai");
				dsLoai.add(new TheLoai(matheloai, tentheloai));
			}
			rs.close();
			return dsLoai;
		} catch (Exception e) {
			System.out.println("get Loai với 20 Row theo Page" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<TheLoai> getLoai20RowSearch(String SearchValue, int page){
		try {
			ArrayList<TheLoai> dsLoai = new ArrayList<TheLoai>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from TheLoai where TenTheLoai like ? order by MaTheLoai offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+SearchValue+"%");
			cmd.setInt(2, page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int matheloai = rs.getInt("MaTheLoai");
				String tentheloai = rs.getString("TenTheLoai");
				dsLoai.add(new TheLoai(matheloai, tentheloai));
			}
			rs.close();
			return dsLoai;
		} catch (Exception e) {
			System.out.println("get Loai với 20 Row theo SearchValue" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int getPageCount() {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from TheLoai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo The Loai" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int getPageCountSearch(String SearchValue) {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from TheLoai where TenTheLoai like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%"+SearchValue+"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount theo The Loai Search" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int BoSungLoai(String TenLoai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into TheLoai(TenTheLoai) values(?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, TenLoai);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			
			System.out.println("Bổ sung loại "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int SuaLoai(TheLoai theloai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update TheLoai set TenTheLoai = ? where MaTheLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, theloai.getTenTheLoai());
			cmd.setInt(2, theloai.getMaTheLoai());
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {		
			System.out.println("Update loại "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int XoaLoai(int maTheLoai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete TheLoai where MaTheLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,maTheLoai);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {		
			System.out.println("Delete loại "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public TheLoai GetTheLoai_ID(int maTheLoai) {
		try {
			TheLoai theloai = new TheLoai();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from TheLoai where MaTheLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,maTheLoai);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int matheloai = rs.getInt("MaTheLoai");
				String TenTheLoai = rs.getString("TenTheLoai");
				theloai = new TheLoai(matheloai, TenTheLoai);
			}
			kn.cn.close();
			return theloai;
		} catch (Exception e) {		
			System.out.println("Get loại theo id loại "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
