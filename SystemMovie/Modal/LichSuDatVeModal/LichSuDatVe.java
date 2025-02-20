package LichSuDatVeModal;

import java.util.Date;

public class LichSuDatVe {
	private int MaVe;
	private int MaKhachHang;
	private boolean TrangThai;
	private String TenPhim;
	private String TenGhe;
	private String TenPhongChieu;
	private String GioChieu;
	private Date NgayDatVe;
	private Date NgayChieu;
	public int getMaVe() {
		return MaVe;
	}
	public void setMaVe(int maVe) {
		MaVe = maVe;
	}
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public boolean isTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}
	public String getTenPhim() {
		return TenPhim;
	}
	public void setTenPhim(String tenPhim) {
		TenPhim = tenPhim;
	}
	public String getTenGhe() {
		return TenGhe;
	}
	public void setTenGhe(String tenGhe) {
		TenGhe = tenGhe;
	}
	public String getTenPhongChieu() {
		return TenPhongChieu;
	}
	public void setTenPhongChieu(String tenPhongChieu) {
		TenPhongChieu = tenPhongChieu;
	}
	public String getGioChieu() {
		return GioChieu;
	}
	public void setGioChieu(String gioChieu) {
		GioChieu = gioChieu;
	}
	public Date getNgayDatVe() {
		return NgayDatVe;
	}
	public void setNgayDatVe(Date ngayDatVe) {
		NgayDatVe = ngayDatVe;
	}
	public Date getNgayChieu() {
		return NgayChieu;
	}
	public void setNgayChieu(Date ngayChieu) {
		NgayChieu = ngayChieu;
	}
	public LichSuDatVe(int maVe, int maKhachHang, boolean trangThai, String tenPhim, String tenGhe,
			String tenPhongChieu, String gioChieu, Date ngayDatVe, Date ngayChieu) {
		super();
		MaVe = maVe;
		MaKhachHang = maKhachHang;
		TrangThai = trangThai;
		TenPhim = tenPhim;
		TenGhe = tenGhe;
		TenPhongChieu = tenPhongChieu;
		GioChieu = gioChieu;
		NgayDatVe = ngayDatVe;
		NgayChieu = ngayChieu;
	}
	public LichSuDatVe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
