package KhachHangModal;

import java.util.Date;

public class KhachHang {
	private int MaKhachHang;
	private String TenKhachHang;
	private String Email;
	private String SoDienThoai;
	private Date NgaySinh;
	private boolean GioiTinh;
	private String DiaChi;
	private String TenDangNhap;
	private String MatKhau;
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public KhachHang(int maKhachHang, String tenKhachHang, String email, String soDienThoai, Date ngaySinh,
			boolean gioiTinh, String diaChi, String tenDangNhap, String matKhau) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		Email = email;
		SoDienThoai = soDienThoai;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
