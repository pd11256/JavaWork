package 반복제어문3.형성평가03;
//자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.

//주의! '*'과 '*'사이에 공백이 없고 줄사이에도 빈줄이 없다.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for(int i=0; i<a; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		for(int i=a-1; i>0; i--) {
			for(int j=0; j<i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
	} 

}
