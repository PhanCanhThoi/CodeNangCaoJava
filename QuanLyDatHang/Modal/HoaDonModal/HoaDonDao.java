package HoaDonModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;


import KetNoiModal.KetNoi;

public class HoaDonDao {
	ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
	public int addHoaDon(int makh) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into hoadon(makh,NgayMua,damua) values(?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			cmd.setInt(1, makh);
			java.util.Date now = new java.util.Date();
			String temp = f.format(now);
			java.util.Date date = f.parse(temp);	
			cmd.setDate(2,new Date(date.getTime()));
			cmd.setBoolean(3, true);
			int x = cmd.executeUpdate();
			int id=0;
			if(x>0) {
				ResultSet rs= cmd.getGeneratedKeys();
				while(rs.next()) {
					id = rs.getInt(1);
				}
				rs.close();
			}	
			return id;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("them mot hoa don "+ e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
