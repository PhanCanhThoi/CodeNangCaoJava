package LoaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import KetNoiModal.KetNoi;

public class LoaiDao {
	ArrayList<Loai> ds = new ArrayList<Loai>();
	public ArrayList<Loai> getLoai(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maLoai = rs.getString("maloai");
				String tenLoai = rs.getString("tenloai");
				ds.add(new Loai(maLoai, tenLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get loai" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}