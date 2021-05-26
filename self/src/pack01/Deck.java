package pack01;

public class Deck {
	final int CARD_NUM = 52;
	String[] kinds = {"SPADE","HEART","DIAMOND","CLOVER"};
	String[] numbers = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
	Card[] c = new Card[CARD_NUM];

	// 카드에 number kind 넣기
	Deck() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				c[13 * (i - 1) +  (j - 1)] = new Card(i, j);
			}
		}

	}
	//카드섞기
	void shuffle() {
		for(int i=0; i<1000; i++) {
			int random_num = (int)(Math.random()*CARD_NUM);
			Card temp = c[0];
			c[0] = c[random_num];
			c[random_num] = temp;
		}
	}
	
	//카드출력
	
	void all_print() {
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=13; j++) {
				System.out.printf("카드종류:%s , 카드번호:%s\n",kinds[c[13*(i-1)+(j-1)].getKind()-1],numbers[c[13*(i-1)+(j-1)].getNumber()-1]);
				
			}
		}
	}
}
