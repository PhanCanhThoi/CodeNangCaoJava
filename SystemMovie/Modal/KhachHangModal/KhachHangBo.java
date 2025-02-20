package KhachHangModal;

import java.util.ArrayList;
import java.util.Date;

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
	public int getmakh(String tendn , String pass) {
		return khDao.getmakh(tendn, pass);
	}
	public void AddKhachHang(String tenKhachHang, String email, String soDienThoai, Date ngaySinh,
			boolean gioiTinh, String diaChi, String tenDangNhap, String matKhau) {
		khDao.AddKhachHang(tenKhachHang, email, soDienThoai, ngaySinh, gioiTinh, diaChi, tenDangNhap, matKhau);
		return;
	}
	public KhachHang getKhachHang_Ma(int makh) {
		return khDao.getKhachHang_Ma(makh);
	}
	public void Update(int maKhachHang,String tenKhachHang, String email, String soDienThoai, Date ngaySinh,
			boolean gioiTinh, String diaChi, String tenDangNhap) {
		khDao.Update(maKhachHang, tenKhachHang, email, soDienThoai, ngaySinh, gioiTinh, diaChi, tenDangNhap);
		return;
	}
	public void Delete(int makh) {
		khDao.delete(makh);
		return;
	}
	public int getPageCountKh() {
		return khDao.getPageCountKh();
	}
	public ArrayList<KhachHang> getKhachHang(){
		return khDao.getKhachHang();
	}
}
