package Phim_TheLoai_Modal;

import java.util.ArrayList;

public class Phim_TheLoaiBo {
	Phim_TheLoaiDao phim_TheLoaiDao = new Phim_TheLoaiDao();
	ArrayList<Phim_TheLoai> ds;
	public Phim_TheLoai get1Phim_TheLoai(int maPhim) {
		return phim_TheLoaiDao.get1Phim(maPhim);
	}
}
