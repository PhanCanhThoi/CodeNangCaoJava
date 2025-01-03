package DangNhapModal;

public class DangNhap {
	private String TenDangNhap;
	private String MatKhau;
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

	public DangNhap(String tenDangNhap, String matKhau) {
		super();
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	public DangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
