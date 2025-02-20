package HoaDonModal;

import java.util.Date;

public class HoaDon {
	private int MaHoaDon;
	private int MaKhachHang;
	private Date NgayDatVe;
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public Date getNgayDatVe() {
		return NgayDatVe;
	}
	public void setNgayDatVe(Date ngayDatVe) {
		NgayDatVe = ngayDatVe;
	}
	public HoaDon(int maHoaDon, int maKhachHang, Date ngayDatVe) {
		super();
		MaHoaDon = maHoaDon;
		MaKhachHang = maKhachHang;
		NgayDatVe = ngayDatVe;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
}
