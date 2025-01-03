package ShowGheModal;

import java.util.ArrayList;

public class ShowGheBo {
	ArrayList<ShowGhe> ds;
	ShowGheDao gheDao = new ShowGheDao();
	public ArrayList<ShowGhe> getGhe(int malichchieu , int maphongchieu){
		return gheDao.getGhe(malichchieu, maphongchieu);
	}
}
