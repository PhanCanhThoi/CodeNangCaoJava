package TheLoaiModal;

public class TheLoai {
	private int MaTheLoai;
	private String TenTheLoai;
	public int getMaTheLoai() {
		return MaTheLoai;
	}
	public void setMaTheLoai(int maTheLoai) {
		MaTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	public TheLoai(int maTheLoai, String tenTheLoai) {
		super();
		MaTheLoai = maTheLoai;
		TenTheLoai = tenTheLoai;
	}
	public TheLoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
