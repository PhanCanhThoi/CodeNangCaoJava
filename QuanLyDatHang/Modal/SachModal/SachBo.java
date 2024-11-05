
package SachModal;

import java.util.ArrayList;

public class SachBo {
	SachDao sachDao = new SachDao();
	ArrayList<Sach> ds;
	public ArrayList<Sach> getSach(int page){
		ds = sachDao.getSach(page);
		return ds;
	}
	public ArrayList<Sach> getAllSach(){
		ds = sachDao.getAllSach();
		return ds;
	}
	public int getPageCount() {
		int x = sachDao.getPageCount();
		return x;
	}
	public int getPageCountMaloai(String maloai) {
		int x = sachDao.getPageCountMaloai(maloai);
		return x;
	}
	public int getPageCountSearch(String search) {
		int x = sachDao.getPageCountSearch(search);
		return x;
	}
	public ArrayList<Sach> getSachMaloai(int page , String maloai){
		ds = sachDao.getSachMaloai(page, maloai);
		return ds;
	}
	public ArrayList<Sach> getSachSearch(int page , String search){
		ds = sachDao.getSachSearch(page, search);
		return ds;
	}
	}