package p0614;

import java.util.ArrayList;

public class Ex0614_04 {

	public static void main(String[] args) {

		//Marine 8명, 탱크 7대, 드랍쉽 5대
		
		int x = 1000;
		int y = 2000;
		
		ArrayList<Terran> arr_t = new ArrayList<Terran>();
		for(int i=0; i<20; i++) {
			if(i<8) {
				arr_t.add(new Marine());
			}else if(i<15) {
				arr_t.add(new Tank());
			}else{
				arr_t.add(new DropShip());
			}
		}
		
		for(int i=0; i<20; i++) {
			arr_t.get(i).move(x, y);
		}
		
//		ArrayList<Marine> arr_mar = new ArrayList<Marine>();
//		for(int i=0; i<8; i++) {
//			arr_mar.add(new Marine());
//		}
//		for(Marine m : arr_mar) {
//			m.move(x, y);
//		}
//		ArrayList<Tank> arr_tan = new ArrayList<Tank>();
//		for(int i=0; i<7; i++) {
//			arr_tan.add(new Tank());
//		}
//		for(Tank t : arr_tan) {
//			t.move(x, y);
//		}
//		
//		ArrayList<DropShip> arr_dro = new ArrayList<DropShip>();
//		
//		for(int i=0; i<5; i++) {
//			arr_dro.add(new DropShip());
//		}
//		
//		for(DropShip d : arr_dro) {
//			d.move(x, y);
//		}
	}//main

}//class
