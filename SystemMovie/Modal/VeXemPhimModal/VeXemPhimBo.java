package VeXemPhimModal;

public class VeXemPhimBo {
	VeXemPhimDao veDao = new VeXemPhimDao();
	public void AddVeXemPhim(int maGhe,int maLichChieu,int MaPhim, int maHoaDon) {
		veDao.AddVeXemPhim(maGhe, maLichChieu, MaPhim, maHoaDon);
		return;
	}
	public void update(int mave) {
		veDao.Update(mave);
		return;
	}
	public int CountVe_Thang() {
		return veDao.CountVe_Thang();
	}
}
