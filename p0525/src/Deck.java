
public class Deck {
	// 52장의 카드생성
	// 52장의 카드에 kind,number
	// 52장의 카드를 섞는 메소드
	// 52장의 카드를 출력하는 메소드
	String[] kinds = {"SPADE","DIAMOND","HEART","CLOVER"};
	String[] numbers = {"1","2","3","4","5","6","7","8","9","10","J","K","Q"};
//	int count;
	
	
	Card[] c = new Card[kinds.length*numbers.length];
	Card[] myCard = new Card[7];
	Card[] comCard = new Card[7];
	
	void output_7card() {
		System.out.println("[7장씩 카드 배분]");
		for(int k=0; k<14; k++) {
			if(k<=6) {
				myCard[k] = new Card(c[k].kind,c[k].number);
				System.out.printf("myCard::%s , %s\n",myCard[k].kind,myCard[k].number);
			}else {
				comCard[k-7] = new Card(c[k].kind,c[k].number);
				System.out.printf("comCard:%s , %s\n",comCard[k-7].kind,comCard[k-7].number);
			}
		}
	}
	Deck() {
		for(int i = 0;i<kinds.length;i++){
			for (int j = 0; j < numbers.length; j++) {
				c[13*i+j] = new Card(kinds[i],numbers[j]);
			}
		}
		
	}
	
	void shuffle() {
		for(int i=0; i<1000; i++) {
			int random_num = (int)(Math.random()*kinds.length*numbers.length);
			Card temp = c[0];
			c[0] = c[random_num];
			c[random_num] = temp;
			
		}
	}
	//1장 출력
	void print_1Card(int index) {
		System.out.printf("카드종류:%s , 카드번호:%s\n",c[index].kind,c[index].number);
	}
	//5장 출력
	void print_5Card() {
		System.out.println("[ 5장 출력 ]");
		for(int k=0; k<5; k++) {
			System.out.printf("카드종류:%s , 카드번호:%s\n",c[k].kind,c[k].number);
		}
	}
	//전체 출력
	void print_52Card() {
		for(int i=0; i<kinds.length; i++) {
			for(int j=0; j<numbers.length; j++) {
				System.out.printf("카드종류 %s , 카드번호 %s \n",c[13*i+j].kind,c[13*i+j].number);
			}
		}
	}
	
//	void print_7Card() {
//		int count = 0;
//		int count2 = 0;
//		shuffle();
//		for(int k=0; k<=6; k++) {
//			System.out.printf("MYCARD : %s ,%s\n",c[k].kind,c[k].number);
//			count = k+1;
//		}
//		for(int k=count; k<=count+6; k++) {
//			System.out.printf("컴퓨터CARD : %s ,%s\n",c[k].kind,c[k].number);
//			count2 = k+1;
//		}
//	}
	void menu_Print() {

		System.out.println("[ 카드 프로그램 ]");
		System.out.println("1.카드 1장 출력");
		System.out.println("2.카드 5장 출력");
		System.out.println("3.카드 52장 출력");
		System.out.println("4.카드 섞기");
		System.out.println("5.카드 7장 출력");
		System.out.println("0.프로그램 종료");
		System.out.println("원하는 번호를 입력하세요");
		
	}
//	Deck() {
//		for(int i = 0;i<=kinds.length;i++){
//			for (int j = 0; j <= numbers.length; j++) {
//				c[count++] = new Card(kinds[i],numbers[j]);
//			}
//		}
//		
//	}
	
}