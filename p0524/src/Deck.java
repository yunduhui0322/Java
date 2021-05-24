
public class Deck {
	final int CARD_NUM = 52;
	Card[] c = new Card[CARD_NUM];
	
	
	Deck() {
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=13; j++) {
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
}
