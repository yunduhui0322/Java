
public class Deck {
	final int CARD_NUM = 52;
	Card[] c = new Card[CARD_NUM];
	
	
	Deck() {
		for(int i=1; i<=Card.kinds_num; i++) {
			for(int j=1; j<=Card.numbers_num; j++) {
				c[13*(i-1)+(j-1)] = new Card(i,j);
			}
		}
	}//기본생성자
	
	void shuffle() {
		for(int i=0; i<1000; i++) {
			int random_no = (int)(Math.random()*CARD_NUM);
			Card temp = c[0];
			c[0] = c[random_no];
			c[random_no] = temp;
		}
	}// shuffle method
	void card_print(Card c) {
		String[] kinds = { "SPADE", "DIAMOND", "HEART", "CLOVER" };
		String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		System.out.printf("카드종류 : %s, 카드 번호 :%s\n", kinds[c.kind-1], numbers[c.number-1]);
	}
}
