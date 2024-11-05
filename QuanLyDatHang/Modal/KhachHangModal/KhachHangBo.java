package KhachHangModal;

import java.util.ArrayList;

public class KhachHangBo {
	ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
	KhachHangDao khDao = new KhachHangDao();
	public ArrayList<KhachHang> getKhachHang(){
		ds = khDao.getKhachHang();
		return ds;
	}
	
	public boolean CheckDangNhap(String tendn , String pass) {
		boolean check = false;
		for(KhachHang kh : khDao.getKhachHang()) {
			if(tendn.equals(kh.getTendn())&&pass.equals(kh.getPass())) {
				check = true;
				return check;
			}
		}
		return check;
	}
	
}
