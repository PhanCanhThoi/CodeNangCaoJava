package Phim_TheLoai_Modal;

import java.util.Date;

public class Phim_TheLoai {
	private int MaPhim;
	private String TenPhim;
	private int MaTheLoai;
	private String DaoDien;
	private String DienVien;
	private Date NgayPhatHanh;
	private String ThoiLuong;
	private String MoTa;
	private String Poster;
	private String LinkTrailer;
	private String NgonNgu;
	private String TenTheLoai;
	public int getMaPhim() {
		return MaPhim;
	}
	public void setMaPhim(int maPhim) {
		MaPhim = maPhim;
	}
	public String getTenPhim() {
		return TenPhim;
	}
	public void setTenPhim(String tenPhim) {
		TenPhim = tenPhim;
	}
	public int getMaTheLoai() {
		return MaTheLoai;
	}
	public void setMaTheLoai(int maTheLoai) {
		MaTheLoai = maTheLoai;
	}
	public String getDaoDien() {
		return DaoDien;
	}
	public void setDaoDien(String daoDien) {
		DaoDien = daoDien;
	}
	public String getDienVien() {
		return DienVien;
	}
	public void setDienVien(String dienVien) {
		DienVien = dienVien;
	}
	public Date getNgayPhatHanh() {
		return NgayPhatHanh;
	}
	public void setNgayPhatHanh(Date ngayPhatHanh) {
		NgayPhatHanh = ngayPhatHanh;
	}
	public String getThoiLuong() {
		return ThoiLuong;
	}
	public void setThoiLuong(String thoiLuong) {
		ThoiLuong = thoiLuong;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	public String getLinkTrailer() {
		return LinkTrailer;
	}
	public void setLinkTrailer(String linkTrailer) {
		LinkTrailer = linkTrailer;
	}
	public String getNgonNgu() {
		return NgonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		NgonNgu = ngonNgu;
	}
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	public Phim_TheLoai(int maPhim, String tenPhim, int maTheLoai, String daoDien, String dienVien, Date ngayPhatHanh,
			String thoiLuong, String moTa, String poster, String linkTrailer, String ngonNgu, String tenTheLoai) {
		super();
		MaPhim = maPhim;
		TenPhim = tenPhim;
		MaTheLoai = maTheLoai;
		DaoDien = daoDien;
		DienVien = dienVien;
		NgayPhatHanh = ngayPhatHanh;
		ThoiLuong = thoiLuong;
		MoTa = moTa;
		Poster = poster;
		LinkTrailer = linkTrailer;
		NgonNgu = ngonNgu;
		TenTheLoai = tenTheLoai;
	}
	public Phim_TheLoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
