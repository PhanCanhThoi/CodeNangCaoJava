package KhachHangModal;

import java.util.ArrayList;

public class KhachHangBo {
	KhachHangDao khDao = new KhachHangDao();
	public ArrayList<KhachHang> getKhachHang20Row(int Page){
		return khDao.getKhachHang20Row(Page);
	}
	public ArrayList<KhachHang> getKhachHang20RowSearch(String searchValue,int page){
		return khDao.getKhachHang20RowSearch(searchValue, page);
	}
	public int getPageCount() {
		return khDao.getPageCount();
	}
	public int getPageCountSearch(String searchValue) {
		return khDao.getPageCountSearch(searchValue);
	}
	public KhachHang getKhachHang_Account(String tendn , String pass) {
		return khDao.getKhachHang_Account(tendn, pass);
	}
	public long getmakh(String tendn , String pass) {
		return khDao.getmakh(tendn, pass);
	}
}
