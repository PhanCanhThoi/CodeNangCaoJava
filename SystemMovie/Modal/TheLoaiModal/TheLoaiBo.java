package TheLoaiModal;

import java.util.ArrayList;

public class TheLoaiBo {
	TheLoaiDao theLoaiDao = new TheLoaiDao();
	ArrayList<TheLoai> ds;
	public ArrayList<TheLoai> getTheLoai(){
		return theLoaiDao.getTheLoai();
	}
	public ArrayList<TheLoai> getLoai20Row(int page){
		return theLoaiDao.getLoai20Row(page);
	}
	public int getPageCount() {
		return theLoaiDao.getPageCount();
	}
	public ArrayList<TheLoai> getLoai20RowSearch(String searchValue,int page){
		return theLoaiDao.getLoai20RowSearch(searchValue,page);
	}
	public int getPageCountSearch(String searchValue) {
		return theLoaiDao.getPageCountSearch(searchValue);
	}
	public void ThemLoai(String TenLoai) {
		theLoaiDao.BoSungLoai(TenLoai);
	}
	public void UpdateLoai(TheLoai theloai) {
		theLoaiDao.SuaLoai(theloai);
	}
	public void XoaLoai(int maLoai) {
		theLoaiDao.XoaLoai(maLoai);
	}
	public TheLoai getTheLoai_ID(int maTheLoai) {
		return theLoaiDao.GetTheLoai_ID(maTheLoai);
	}
}
