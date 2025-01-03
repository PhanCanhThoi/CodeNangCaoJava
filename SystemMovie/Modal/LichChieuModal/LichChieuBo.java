package LichChieuModal;

import java.sql.Date;
import java.util.ArrayList;

public class LichChieuBo {
	LichChieuDao lichChieuDao = new LichChieuDao();
	ArrayList<LichChieu> ds;
	public ArrayList<LichChieu> getLichChieuTheoPhim_Ngay(int maPhim,Date ngay){
		return lichChieuDao.getLichChieuTheoPhim_Ngay(maPhim, ngay);
	}
	public void ThemLichChieu(LichChieu lichchieu) {
		lichChieuDao.ThemLichChieu(lichchieu);
		return;
	}
	public void UpdateLichChieu(LichChieu lichchieu) {
		lichChieuDao.UpdateLichChieu(lichchieu);
		return ;
	}
	public void DeleteLichChieu(int malichchieu) {
		lichChieuDao.DeleteLichChieu(malichchieu);
		return;
	}
	public LichChieu getLichChieu_ID(int malichchieu) {
		return lichChieuDao.getLichChieu_ID(malichchieu);
	}
}
