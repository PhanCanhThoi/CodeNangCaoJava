package LichChieu;

import java.util.ArrayList;

public class LichChieuBo {
	LichChieuDao lcBo = new LichChieuDao();
	public ArrayList<LichChieu> getLichChieu20Row(int page){
		return lcBo.getLichChieu20Row(page);
	}
	public ArrayList<LichChieu> getLichChieu20RowSearch(String searchValue,int page){
		return lcBo.getLichChieu20RowSearch(searchValue, page);
	}
	public int pageCount() {
		return lcBo.getPageCount();
	}
	public int pageCountSearch(String searchValue) {
		return lcBo.getPageCountSearch(searchValue);
	}
}
