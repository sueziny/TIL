package looping.test;

/*
 * 반복문 중에서 가장 많이 사용되는
 * for문이 어떻게 동작하는지 정확하게 이해한다.
 * for(초기식; 조건식; 증감식)
 */

public class LoopingBasicTest1 {

	public static void main(String[] args) { //모든 코드의 시작점은 main 메소드
		
		System.out.println("==============for========\n");
		for(int i = 0, j = 0; i<10 & j<10; i++, j++) {
			
			System.out.println("Hello Looping.."+i);
		}//for
		
		
		System.out.println("==============while========\n");
		
		
		int i = 0; //로컬변수(main 메소드 안에 변수) , 초기식 , 처음에 딱 한번만 실행
		
		while(i<10) {
			System.out.println("Hello while Looping.."+ i);
			i++;
		}//while
		
		System.out.println("\n==============do while========\n");
		
		
		int j = 10; //1
		do {//2  한번은 무조건 실행
			System.out.println(j+"...Always print..");
			j++;
		}while(j<10);//3 여기서 비교
		
	}//main

}//class
