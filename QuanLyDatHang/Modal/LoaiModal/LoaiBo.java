package LoaiModal;

import java.util.ArrayList;

public class LoaiBo {
	LoaiDao lDao= new LoaiDao();
	public ArrayList<Loai> getLoai(){
		return lDao.getLoai();
	}
}