package HoaDonModal;

public class HoaDonBo {
	HoaDonDao hdDao = new HoaDonDao();
	public int AddHoaDon(int makh) {
		return hdDao.AddHoaDon(makh);
	}
}
