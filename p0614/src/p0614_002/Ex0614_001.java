package p0614_002;

public class Ex0614_001 {

	public static void main(String[] args) {
		Tank t1 = new Tank();
		Marine m1 = new Marine();
		Firebat f1 = new Firebat();
		DropShip d1 = new DropShip();
		Wraith w1 = new Wraith();
		Scv s1 = new Scv();
		Vulture v1 = new Vulture();
		Medic me1 = new Medic();
		
		
		t1.hitPoint -= 10;
		f1.hitPoint -= 30;
		m1.hitPoint -= 20;
		d1.hitPoint -= 40;
		w1.hitPoint -= 50;
		v1.hitPoint -= 60;
		me1.hitPoint -= 20;
		s1.hitPoint -= 10;
		
		s1.repair(t1);
		s1.repair(v1);
		s1.repair(d1);
		s1.repair(w1);
		me1.healing(f1);
		me1.healing(m1);
	}//main
}//class
