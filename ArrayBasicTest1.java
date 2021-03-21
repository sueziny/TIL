package array.test;

/*
 * 배열 선언, 생성, 초기화 과정을 작성
 * for문을 사용해서 배열 안에 들어있는 값들을 콘솔창으로 출력
 */

public class ArrayBasicTest1 {

	public static void main(String[] args) {
		
		//1. 배열선언
		int[] arr = new int[3];
		 System.out.println("배열의 주소값::"+arr);
		 for(int i = 0; i<arr.length; i++) System.out.println(arr[i]);//0 0 0
		 
		 //2.초기화
		 arr[0] = 11; arr[0]=22; arr[0]=33;
		 for(int i = 0; i<arr.length; i++) System.out.println(arr[i]);
	}

}
