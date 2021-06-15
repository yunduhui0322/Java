package p0615;

public class Medic extends GroundUnit implements healing {

	public Medic() {
		super(60);
	}

	void heal_unit(healing h) {
		Unit u = (Unit)h;
		while(u.hitPoint != u.MAX_HP) {
			u.hitPoint++;
			System.out.printf("%s 치료중입니다. 현재체력:%d\n",u.getClass().getSimpleName(),u.hitPoint);
		}
		System.out.printf("%s 치료가 완료되었습니다.현재체력 %d\n",u.getClass().getSimpleName(),u.hitPoint);
	}
}
