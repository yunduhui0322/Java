package p0615;

public class Unit {
	int hitPoint;//현재 체력
	final int MAX_HP;//최대체력
	
	Unit(int hp){
		MAX_HP = hp;
		hitPoint = MAX_HP;
	}
}