package temp;

public class Hang {
	private String tenHang;
	private int gia;
	private int soLuong;
	private int thanhTien;
	
	public Hang(String tenHang , int soLuong , int Gia) {
		this.tenHang = tenHang;
		this.soLuong = soLuong;
		this.gia=Gia;
		this.thanhTien = soLuong*Gia;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	
}
