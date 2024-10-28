
package SachModal;

import java.util.ArrayList;

public class SachDao {
	public ArrayList<Sach> 	getSach(){
		ArrayList<Sach> ds = new ArrayList<Sach>();
		ds.add(new Sach("b1","CSDL1","Le Nam", (long)10, (long)100, "image_sach/b1.jpg", "cntt"));
		ds.add(new Sach("b2","Vat Ly","Le Nam", (long)10, (long)100, "image_sach/b2.jpg", "ly"));
		ds.add(new Sach("b3","Chat Ran","Le Nam", (long)10, (long)100, "image_sach/b3.jpg", "hoa"));
		ds.add(new Sach("b4","Giai Tich","Le Nam", (long)10, (long)100, "image_sach/b4.jpg", "toan"));
		ds.add(new Sach("b5","Dai So","Le Nam", (long)10, (long)100, "image_sach/b5.jpg", "toan"));
		ds.add(new Sach("b6","Cong nghe thuc pham","Le Nam", (long)10, (long)100, "image_sach/b6.jpg", "sinh"));
		ds.add(new Sach("b7","Hoa 6","Le Nam", (long)10, (long)100, "image_sach/b7.jpg", "hoa"));
		return ds;
	}    
}