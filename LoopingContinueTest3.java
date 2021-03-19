package looping.test;
/*
 * 1~100까지 숫자 중에서 홀수의 합을 출력하는 로직을 작성
 * 	1)먼저 1부터 100까지 합을 출력
 */

public class LoopingContinueTest3 {

	public static void main(String[] args) {
		int sum = 0;
		
		for(int i = 1; i<=100; i++) {
			
			if(i%2==0) continue; //지금 조건은 아래 코드를 건너뛰고 반복을 계속하라!!
			sum+=i;
				
		}
			System.out.println("1부터 100까지의 홀수값의 합"+ sum );
	}

}
