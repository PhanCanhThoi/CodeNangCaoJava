package LichSuDatVeModal;

import java.util.ArrayList;

public class LichSuDatVeBo {
	LichSuDatVeDao lsDao = new LichSuDatVeDao();
	public ArrayList<LichSuDatVe> getLichSu_TrangThai(int makh,boolean trangthai,int check){
		return lsDao.getVe_TrangThai(makh, trangthai,check);
	}
	public ArrayList<LichSuDatVe> getVeChuaThanhToan(){
		return lsDao.GetVe();
	}
}
