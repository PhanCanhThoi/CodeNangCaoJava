package LoaiModal;

import java.util.ArrayList;

public class LoaiDao {
	public ArrayList<Loai> getLoai(){
		ArrayList<Loai> ds = new ArrayList<Loai>();
		ds.add(new Loai("ct","chinh tri"));
		ds.add(new Loai("cntt","Cong nghe thong tin"));
		ds.add(new Loai("toan","Sach Toan"));
		ds.add(new Loai("ly","Vat Ly"));
		ds.add(new Loai("sinh","Cong nghe sinh hoc"));
		ds.add(new Loai("hoa","Sach Hoa"));
		return ds;
	}
}