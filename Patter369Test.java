package com.encore.test1;

import java.util.Scanner;

public class Patter369Test {

	/* 
	 * Scanner객체를 통해서 
	 * 10~99 사이의 장소를 하나 입력받는다.(2자리의 숫자)
	 * 
	 * 3,6,9...즉 3의 배수값이 포함되어져 있는지를 패턴으로 적용하는 알고리즘
	 * 하나 있으면 @
	 * 두개 있으면 @@
	 * 없으면 숫자
	 * 
	 * 예를 들어서 
	 * 31 ->@
	 * 11->11
	 * 98->@
	 * 96->@@
	 * 
	 * 힌트 
	 * 2자리 수 
	 * 앞자리  -->/
	 * 끝자리  -- >%
	 * 
	 * 제어문 연습하기
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int i=0; i<100; i++) {
		int number = sc.nextInt();
				
	    int a = number/10; 
	    int b = number%10;
	  
	    if(a==3|a==6|a==9) {
		  if(b==3|b==6|b==9)
			  System.out.println("@@");
		  else 
			  System.out.println("@");
	  }else {
		  if(b==3|b==6|b==9)
			  System.out.println("@");
		  else 
			  System.out.println(number);
	   }
	    
	  }
	}
}
