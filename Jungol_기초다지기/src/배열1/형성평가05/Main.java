package 배열1.형성평가05;

import java.util.Scanner;

/*6개의 문자배열을 만들고 {'J' 'U' 'N' 'G' 'O' 'L'} 으로 초기화 한 후 문자 한 개를 입력받아 배열에서의 위치를 출력하는 프로그램을 작성하시오.
첫 번째 위치는 0번이며 배열에 없는 문자가 입력되면 "none" 라는 메시지를 출력하고 끝내는 프로그램을 작성하시오.*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char list[]= {'J', 'U', 'N', 'G', 'O' ,'L'};
		char a;
		int i;
		int j;
		
		
		a=sc.nextLine();
		for(i=0; i<list.length; i++) {
			if(list.equals(a)) {
				System.out.println(i);
			}else {
				System.out.println("none");
			}
		}
		
	}
	
	

}
