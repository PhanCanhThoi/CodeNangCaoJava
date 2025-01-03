package ShowGheModal;

public class ShowGhe {
	private int maGhe;
	private String tenGhe;
	boolean Tinhtrang;
	public int getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(int maGhe) {
		this.maGhe = maGhe;
	}
	public String getTenGhe() {
		return tenGhe;
	}
	public void setTenGhe(String tenGhe) {
		this.tenGhe = tenGhe;
	}
	public boolean isTinhtrang() {
		return Tinhtrang;
	}
	public void setTinhtrang(boolean tinhtrang) {
		Tinhtrang = tinhtrang;
	}
	public ShowGhe(int maGhe, String tenGhe, boolean tinhtrang) {
		super();
		this.maGhe = maGhe;
		this.tenGhe = tenGhe;
		Tinhtrang = tinhtrang;
	}
	public ShowGhe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
