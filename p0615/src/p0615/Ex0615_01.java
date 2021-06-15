package p0615;

public class Ex0615_01 {

	public static void main(String[] args) {
		Marine m = new Marine();
		Medic me = new Medic();
		Scv s = new Scv();
		Vulture v = new Vulture();
		Tank t = new Tank();
		Wraith w = new Wraith();
		m.hitPoint -= 5;
		me.hitPoint -= 15;
		v.hitPoint -= 25;
		t.hitPoint -= 30;
		w.hitPoint -= 35;
		
		s.repair_unit(w);
		s.repair_unit(t);
		s.repair_unit(v);
		
		me.heal_unit(m);
	}

}
