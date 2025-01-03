package PhongChieuModal;

public class PhongChieu {
	private int MaPhongChieu;
	private String TenPhongChieu;
	private int SoChoNgoi;
	private boolean TinhTrang;
	private String HinhAnh;
	public int getMaPhongChieu() {
		return MaPhongChieu;
	}
	public void setMaPhongChieu(int maPhongChieu) {
		MaPhongChieu = maPhongChieu;
	}
	public String getTenPhongChieu() {
		return TenPhongChieu;
	}
	public void setTenPhongChieu(String tenPhongChieu) {
		TenPhongChieu = tenPhongChieu;
	}
	public int getSoChoNgoi() {
		return SoChoNgoi;
	}
	public void setSoChoNgoi(int soChoNgoi) {
		SoChoNgoi = soChoNgoi;
	}
	public boolean isTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public PhongChieu(int maPhongChieu, String tenPhongChieu, int soChoNgoi, boolean tinhTrang, String hinhAnh) {
		super();
		MaPhongChieu = maPhongChieu;
		TenPhongChieu = tenPhongChieu;
		SoChoNgoi = soChoNgoi;
		TinhTrang = tinhTrang;
		HinhAnh = hinhAnh;
	}
	public PhongChieu() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
