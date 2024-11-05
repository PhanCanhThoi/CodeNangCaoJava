package HoaDonModal;

public class HoaDonBo {
	HoaDonDao hdDao = new HoaDonDao();
	public int addHoaDon(int makh) {
		return hdDao.addHoaDon(makh);
	}
}
