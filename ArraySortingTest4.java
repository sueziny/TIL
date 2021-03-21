package array.test;

import java.util.Random;

/*
 * Sorting --- 정렬
 * ::
 * 배열과 같은 자료구조에 있어서는 3,5,7,3,11,2
 * 정렬에 대한 요구사항이 빈번하게 일어난다.
 * 정렬이란?
 * 정렬전{3,6,1,2,8,9}-->오름 차순(default) 정렬 후 {1,2,3,6,8,9}-->내림차순 {9,8,7,3,2,1}
 * 정렬 | 순서 
 * 순서는 값이 입력된 순서를 말한다.
 * a,bb,a,c,zz
 * ::
 * Bubble Sorting ---- 버블정렬
 * 정렬을 구현하기 위한 알고리즘 중에서 가장 대표적인 알고리즘이 버블솔팅
 * 
 * 방법
 * 인접한 두 수를 비교해서 큰 수를 뒤로 보내는 방법
 * 2,5 두수를 비교 -->2,5를 유지한다.
 * 5,3 두수를 비교 -->
 * 		1)temp라는 임시변수를 하나 만든다.
 * 		  그리고 그 안에 5를 잠시 저장.
 * 		2)3을 5의 자리에 갖다 놓는다.
 * 		3)3의 자리에는 temp안에 있는 5를 다시 가져와서 갖다놓는다.
 *       ---> 이렇게 두 수의 자리를 temp변수를 이용해서 바꾸는 방법을 swap이라 한다.
 * 
 */

public class ArraySortingTest4 {

	public static void main(String[] args) {
		Random r = new Random();
	//	int a = r.nextInt();
		
		int [] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) 
			arr[i] = r.nextInt(10);//0~9사이의 임의의 정수값
			System.out.println("=====Array의 초기화 완료=====\n");
			for(int i : arr) System.out.print(i+" ");
			
			int temp = 0;{
			for(int i =0; i<arr.length-1; i++)
				for(int j=0; j<arr.length-1; j++) {
					if(arr[j]>arr[j+1]) {//앞의 수가 뒤의 수보다 더 크다면 
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}//if
				}
			}//for
		System.out.println("\n==========정렬완료=========\n");
		for(int i : arr) System.out.print(i+" ");
		
		
	}

}








