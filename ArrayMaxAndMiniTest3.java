package array.test;

/*
 * int타입의 배열을 만든다..랜덤한 값의 정수를 집어 넣는다.
 * 여러숫자들 중에서 가장 큰 수와 가장 작은수를 찾아내는 알고리즘을 작성
 * 
 * 
 */
public class ArrayMaxAndMiniTest3 {

	public static void main(String[] args) {
		
		int[] scores = {79, 91, 44, 99, 55, 96};
		int min = scores[0]; //배열의 첫번째 값으로 기본값을 초기화한다...79
		int max = scores[0]; //...79
		
		
		// 알고리즘, 코딩테스트에서 주로 사용하는 방법
	    //for(int i=0; i<scores.length; i++) {
	    	//if(scores[i]<min)min = scores[i];
	    	//if(scores[i]>max)max = scores[i];
	    //}
	    
		
		// 프로그램에서 사용하는 방법
	    //Advanced for|ForEach..."뭐가 어디에서 도는가?"
		 for(int score : scores ) {
			 if(score<min) min = score;
			 if(score>max)max = score;
		 }
		
	    
	   // System.out.println("최솟값 "+min);
	    //System.out.println("최대값 "+max);
	}//main

}
