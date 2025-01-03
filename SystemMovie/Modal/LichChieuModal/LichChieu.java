package LichChieuModal;

import java.util.Date;

public class LichChieu {
	private int MaLichChieu;
	private int MaPhim;
	private int MaPhongChieu;
	private Date NgayChieu;
	private String GioChieu;
	public int getMaLichChieu() {
		return MaLichChieu;
	}
	public void setMaLichChieu(int maLichChieu) {
		MaLichChieu = maLichChieu;
	}
	public int getMaPhim() {
		return MaPhim;
	}
	public void setMaPhim(int maPhim) {
		MaPhim = maPhim;
	}
	public int getMaPhongChieu() {
		return MaPhongChieu;
	}
	public void setMaPhongChieu(int maPhongChieu) {
		MaPhongChieu = maPhongChieu;
	}
	public Date getNgayChieu() {
		return NgayChieu;
	}
	public void setNgayChieu(Date ngayChieu) {
		NgayChieu = ngayChieu;
	}
	public String getGioChieu() {
		return GioChieu;
	}
	public void setGioChieu(String gioChieu) {
		GioChieu = gioChieu;
	}
	public LichChieu(int maLichChieu, int maPhim, int maPhongChieu, Date ngayChieu, String gioChieu) {
		super();
		MaLichChieu = maLichChieu;
		MaPhim = maPhim;
		MaPhongChieu = maPhongChieu;
		NgayChieu = ngayChieu;
		GioChieu = gioChieu;
	}
	public LichChieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
