
package SachModal;

import java.util.ArrayList;

public class SachBo {
	SachDao sachDao = new SachDao();
	ArrayList<Sach> ds;
	public ArrayList<Sach> getSach(){
		ds = sachDao.getSach();
		return ds;
	}
	
	public ArrayList<Sach> timMa(String MaLoai){
		ArrayList<Sach> temp = new ArrayList<Sach>();
		ds=sachDao.getSach();
		for(Sach sach:ds) {
			if(sach.getMaLoai().equals(MaLoai)) {
				temp.add(sach);
			}
		}
		return temp;
	}
	
	public ArrayList<Sach> Tim(String keyword){
		SachDao sachdao = new SachDao();
		ArrayList<Sach> temp1 = new ArrayList<Sach>();
		ArrayList<Sach> ds = sachdao.getSach();
		for(Sach sach:ds) {
			if(sach.getTenSach().toLowerCase().trim().contains(keyword.toLowerCase().trim())) {
				temp1.add(sach);
			}
		}
		
		return temp1;
}
	}