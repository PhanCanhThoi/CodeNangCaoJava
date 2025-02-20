package VeXemPhimModal;

public class VeXemPhim {
	private int MaVe;
	private int MaGhe;
	private int MaLichChieu;
	private boolean TrangThai;
	private int MaPhim;
	private int MaHoaDon;
	public int getMaVe() {
		return MaVe;
	}
	public void setMaVe(int maVe) {
		MaVe = maVe;
	}
	public int getMaGhe() {
		return MaGhe;
	}
	public void setMaGhe(int maGhe) {
		MaGhe = maGhe;
	}
	public int getMaLichChieu() {
		return MaLichChieu;
	}
	public void setMaLichChieu(int maLichChieu) {
		MaLichChieu = maLichChieu;
	}
	public boolean isTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}
	public int getMaPhim() {
		return MaPhim;
	}
	public void setMaPhim(int maPhim) {
		MaPhim = maPhim;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public VeXemPhim(int maVe, int maGhe, int maLichChieu, boolean trangThai, int maPhim, int maHoaDon) {
		super();
		MaVe = maVe;
		MaGhe = maGhe;
		MaLichChieu = maLichChieu;
		TrangThai = trangThai;
		MaPhim = maPhim;
		MaHoaDon = maHoaDon;
	}
	public VeXemPhim() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
