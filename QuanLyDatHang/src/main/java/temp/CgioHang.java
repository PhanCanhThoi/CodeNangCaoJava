package temp;

import java.util.ArrayList;

public class CgioHang {
	 public ArrayList<Hang> ds = new ArrayList<Hang>();
	
	public void themHang(String th , int sl , int gia) {
		int n = ds.size();
		for( int i = 0 ; i < n ; i ++) {
			if((ds.get(i).getTenHang().toLowerCase().trim()).equals(th.toLowerCase().trim())) {
				int slt = ds.get(i).getSoLuong()+sl;
				ds.get(i).setSoLuong(slt);
				int giatemp = ds.get(i).getGia();
				int tt = slt * giatemp;
				ds.get(i).setThanhTien(tt);
				return;
			}
		}
		Hang h = new Hang(th, sl, gia);
		ds.add(h);
	}
	public void sua(String th , int sl , int gia) {
		int n = ds.size();
		for(int i = 0 ; i < n ; i++) {
			if((ds.get(i).getTenHang().toLowerCase().trim()).equals(th.toLowerCase().trim())) {
				ds.get(i).setSoLuong(sl);
				ds.get(i).setGia(gia);
				int thanhtien = sl*gia;
				ds.get(i).setThanhTien(thanhtien);
				return;
			}
		}
	}
	public void xoa(String th) {
		int n = ds.size();
		for(int i = 0 ; i<n ; i ++) {
			if((th.toLowerCase().trim()).equals(ds.get(i).getTenHang().toLowerCase().trim())) {
				ds.remove(i);
				break;
			}
		}
	}
	public long tongTien() {
		int n = ds.size();
		long tong=0;
		for(int i = 0 ; i < n ; i++) {
			tong=tong + ds.get(i).getThanhTien();
		}	
		return tong;
	}
}
