package ThongKePhim_SoLuongModal;

public class ThongKe {
	private String TenPhim;
	private int SoLuong;
	public String getTenPhim() {
		return TenPhim;
	}
	public void setTenPhim(String tenPhim) {
		TenPhim = tenPhim;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public ThongKe(String tenPhim, int soLuong) {
		super();
		TenPhim = tenPhim;
		SoLuong = soLuong;
	}
	public ThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
