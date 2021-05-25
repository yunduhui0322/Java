
public class Card {


	int kind; // SPADE, DIAMOND, HEART, CLOVER
	int number;// 1~10 J,K,Q

	static final int kinds_num = 4;
	static final int numbers_num = 13;
//	static int count;
	Card() {
		this(1, 1);
	}// 기본생성자

	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	
}
