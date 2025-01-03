package PhimModal;

import java.util.ArrayList;

public class PhimBo {
	PhimDao phimDao = new PhimDao();
	ArrayList<Phim> ds;
	public ArrayList<Phim> getPhimDangChieu(){
		return phimDao.getPhimDangChieu();
	}
	public ArrayList<Phim> getPhimChuanBiChieu(){
		return phimDao.getPhimChuanBiChieu();
	}
	public Phim get1Phim(int maPhim) {
		return phimDao.get1Phim(maPhim);
	}
	public ArrayList<Phim> getPhimDangChieuPagination(int page , String searchValue){
		return phimDao.getPhimDangChieuPagination(page, searchValue);
	}
	public int getPageCountPhimDangChieu(String searchValue) {
		return phimDao.getPageCountPhimDangChieu(searchValue);
	}
	public ArrayList<Phim> getPhim(){
		return phimDao.getPhim();
	}
	public ArrayList<Phim> getPhim20Row(int pgae){
		return phimDao.getPhim20Row(pgae);
	}
	public int getPageCount() {
		return phimDao.getPageCount();
	}
	public ArrayList<Phim> getPhimSapChieuPagination(int page , String searchValue){
		return phimDao.getPhimSapChieuPagination(page, searchValue);
	}
	public int getPageCountPhimSapChieu(String searchValue) {
		return phimDao.getPageCountPhimSapChieu(searchValue);
	}
	public ArrayList<Phim> getPhim20RowSearch(String searchValue,int page){
		return phimDao.getPhim20RowSearch(searchValue,page);
	}
	public int getPageCountSearch(String SearchValue) {
		return phimDao.getPageCountSearch(SearchValue);
	}
	public void ThemPhim(Phim phim) {
		phimDao.ThemPhim(phim);
		return;
	}
	public void UpdatePhim(Phim phim) {
		phimDao.UpdatePhim(phim);
		return;
	}
	public Phim get1PhimTheoMa(int maphim) {
		return phimDao.Get1Phim(maphim);
	}
	public void DeletePhim(int maPhim) {
		phimDao.DeletePhim(maPhim);
		return;
	}

}
