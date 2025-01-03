package PhongChieuModal;

import java.util.ArrayList;

public class PhongChieuBo {
	PhongChieuDao pcDao = new PhongChieuDao();
	public ArrayList<PhongChieu> getPhongChieu(){
		return pcDao.getPhongChieu();
	}
}
