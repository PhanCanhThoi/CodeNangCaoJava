package ChiTietHoaDonModal;

public class ChiTietHoaDonBo {
	ChiTietHoaDonDao cthdDao = new ChiTietHoaDonDao();
	public void addChiTietHoaDon(String masach , long slmua , int maHoaDon) {
		int temp = cthdDao.addChiTietHoaDon(masach, slmua, maHoaDon);
	}
}
