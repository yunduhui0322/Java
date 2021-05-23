import java.util.Scanner;
public class ScoreProcess {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Student[] s = new Student[10];
		
		scorePro:while(true) {
			mainPrint();
			int choice = scan.nextInt();
			switch (choice) {
			case 1://�����߰�
				scoreInsert(s);
				break;
			case 2://�������
				scorePrint(s);
				break;
			case 3://��������
				scoreFix(s);
				break;
			case 4://�����˻�
				scoreSearch(s);
				break;
			case 5://���ó��
				scoreRank(s);
				break;
			case 0://���α׷�����
				System.out.println("���α׷��� �����մϴ�");
				break scorePro;

			}//switch -program 
		}//while -scoerPro
	}//main
	
	static void mainPrint() {
		System.out.println("[ ����ó�� ���α׷�]");
		System.out.println("1. �л����� �߰�");
		System.out.println("2. �л����� ���");
		System.out.println("3. �л����� ����");
		System.out.println("4. �л��A�� �˻�");
		System.out.println("5. �л���� ó��");
		System.out.println("0. ���α׷� ���� ");
		System.out.println("���ϴ� ��ȣ�� �����ϼ���");
	}//mainPrint method
	
	static void topTitle() {
		System.out.printf("��ȣ\t�̸�\t����\t����\t����\t�հ�\t���\t���\n");
	}
	
	static void scoreInsert(Student[] s) {
		for(int i = Student.count; i<s.length; i++) {
			String name = "";
			int kor,eng,math = 0;
			
			System.out.println("�л��̸��� �Է��ϼ���(0.�����޴� �̵�)");
			name = scan.next();
			if(name.equals("0")) {
				break;
			}
			System.out.println("���������� �Է��ϼ���");
			kor = scan.nextInt();
			System.out.println("���������� �Է��ϼ���");
			eng = scan.nextInt();
			System.out.println("���������� �Է��ϼ���");
			math = scan.nextInt();
			s[i] = new Student(name,kor,eng,math);
		}
	}//scoreInsert method
	
	static void scorePrint(Student[] s) {
		topTitle();
		for(int i=0; i<Student.count; i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s[i].stu_number,s[i].name,s[i].kor,
					s[i].eng,s[i].math,s[i].total,s[i].avg,s[i].rank);
		}
	}//scorePrint method
	
	static void scoreFix(Student[] s) {
		fixPro:while(true) {
			String searchName = "";
			int searchNameNo = 0;
			int fixNameNo = 0;
			int fixSubNo = 0;
			System.out.println("������ �л��̸��� �Է��ϼ���");
			searchName = scan.next();
			searchNameNo = -1;
			for(int i=0; i<Student.count; i++) {
				if(s[i].name.contains(searchName)) {
					System.out.printf("%d. %s\n",i,s[i].name);
					searchNameNo = 0;
				}
			}
			switch (searchNameNo) {
			case -1:
				System.out.println("�˻��Ͻ� �л��̸��� �������� �ʽ��ϴ�\n �ٽ��Է��ϼ���");
				break;
			case 0:
				System.out.println("\n�����Ͻ� �л���ȣ�� �Է��ϼ���");
				fixNameNo = scan.nextInt();
				System.out.println("\n�����Ͻ� �����ȣ�� �Է��ϼ���");
				System.out.printf("1.����\n2.����\n3.����");
				fixSubNo = scan.nextInt();
				switch (fixSubNo) {
				case 1://�������
					System.out.printf("���� ��������: %d��\n������ ������ �Է��ϼ��� ",s[fixNameNo].kor);
					s[fixNameNo].kor = scan.nextInt();
					break;
				case 2://�������
					System.out.printf("���� ��������: %d��\n������ ������ �Է��ϼ��� ",s[fixNameNo].eng);
					s[fixNameNo].eng = scan.nextInt();
					break;
				case 3://���м���
					System.out.printf("���� ��������: %d��\n������ ������ �Է��ϼ��� ",s[fixNameNo].math);
					s[fixNameNo].math = scan.nextInt();
					break;
				}//switch fixSubNo
				s[fixNameNo].total = s[fixNameNo].kor + s[fixNameNo].eng + s[fixNameNo].math;
				s[fixNameNo].avg = (double)s[fixNameNo].total/3;
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�");
				break fixPro;
			}//switch searchNameNo
			
		}//while fixPro
	}//scoreFix method
	static void scoreSearch(Student[] s) {
		searchPro:while(true) {
			String searchName = "";
			int searchNameNo = 0;
			System.out.println("�˻��� �л��̸��� �Է��ϼ���");
			searchName = scan.next();
			searchNameNo = -1;
			for(int i=0; i<Student.count; i++) {
				if(s[i].name.contains(searchName)) {
					searchNameNo = 0;
				}
			}
			switch (searchNameNo) {
			case -1:
				System.out.println("�˻��Ͻ� �̸��� ���������ʽ��ϴ�.\n�ٽ��Է��ϼ���.\n");
				break;
			case -0:
				topTitle();
				for(int i=0; i<Student.count; i++) {
					if(s[i].name.contains(searchName)) {
						System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s[i].stu_number,s[i].name,s[i].kor,
								s[i].eng,s[i].math,s[i].total,s[i].avg,s[i].rank);

					}
				}
				System.out.println("�˻��� �Ϸ��߽��ϴ�.");
				break searchPro;
			}//switch searchNameNo
		}//while searchPro
	}//scoreSearch method
	
	static void scoreRank(Student[]s) {
		for(int i=0; i<Student.count; i++) {
			int rankNum = 1;
			for(int j=0; j<Student.count; j++) {
				if(s[i].total<s[j].total) {
					rankNum++;
				}
			}
			s[i].rank = rankNum;
		}
		System.out.println("���ó���� �Ϸ�Ǿ����ϴ�.");
	}//scoreRank method
}//class
