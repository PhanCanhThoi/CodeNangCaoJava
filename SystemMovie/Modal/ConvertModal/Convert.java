package ConvertModal;

import java.util.ArrayList;

public class Convert {
	public ArrayList<Integer> ConvertMaGhe(String maGhe){
		ArrayList<Integer> ds = new ArrayList<Integer>();
		String[] dsghe= maGhe.split(",");
		for(int i = 0 ; i < dsghe.length ; i ++) {
			int x = Integer.parseInt(dsghe[i]);
			ds.add(x);
		}
		return ds;
	}
}
