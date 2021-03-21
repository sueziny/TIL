package array.test;

import java.util.Arrays;
import java.util.Random;


public class ArraySortingTest5 {

	public static void main(String[] args) {
		Random r = new Random();
	//	int a = r.nextInt();
		
		int [] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) 
			arr[i] = r.nextInt(10);//0~9사이의 임의의 정수값
			System.out.println("=====Array의 초기화 완료=====\n");
			for(int i : arr) System.out.print(i+" ");
			
		//~Test4 에서 이중for문을 사용해서 Bubble Sorting하는 로직을 이제는 내부적으로 구현이된 함수를 바로 사용	
			Arrays.sort(arr);
			
		System.out.println("\n==========정렬완료=========\n");
		for(int i : arr) System.out.print(i+" ");
	}

}








