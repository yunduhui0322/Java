
public class Card {

	String[] kinds = {"SPADE", "DIAMOND", "HEART", "CLOVER"};
	String[] numbers = {"1","2","3","4","5","6","7","8","9","10",
						"J","Q","K"};
	
	int kind; //SPADE, DIAMOND, HEART, CLOVER
	int number;//1~10 J,K,Q
	
	Card(){
		this(1,1);
	}//기본생성자
	
	Card(int kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	void card_print(int kind, int number) {
		System.out.printf("카드종류 : %s, 카드 번호 :%s\n",kinds[kind-1],numbers[number-1]);
	}
}
