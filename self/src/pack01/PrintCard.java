package pack01;

public class PrintCard {
	public static void main(String[] args) {
		Deck d = new Deck();
		
		d.shuffle();
		d.all_print();
	}//main
}//class
