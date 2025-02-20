package ThongKePhim_SoLuongModal;

import java.util.ArrayList;

public class ThongKeBo {
	ThongKeDao tkDao = new ThongKeDao();
	public ArrayList<ThongKe> TkPhim_SoLuong(){
		return tkDao.TkPhim_SoLuong();
	}
}
