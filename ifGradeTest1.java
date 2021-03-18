package com.encore.test;

import java.util.Scanner;

/*
 * 제어문
 * :
 * 조건을 만족할 때 문장을 수행하도록 제어하는 문장.
 * 1)if / if~else / else
 * 	int i=1;
 *  int (i!=1) { //i=1으로 넣으면 수행 안함( =는 연산이 아니라 할당을 의미하기 때문에). i != 1 이렇게 넣어도 수행 안함 (조건에 있는 연산이 true일 때만 수행한다)
 * 	   //code block1
 * } else if(i==1){
 * 		//code block2
 * } else if(i==2){
 * 		//code block3
 * } else {
 * 		//code block4
 * }
 *  
 * 2)switch
 * : 해당하는 Case의 문장을 실행하도록 제어한다.
 * switch(grade){
 * 		case 90:
 * 		case 95:
 * 			System.out.println("A grade...");
 * 		break; --> break는 해당 케이스를 빠져나가고 switch도 빠져나간다.
 * 		
 * 		case 80:
 * 		case 85:
 * 			System.out.println("B grade...");
 * 		break;
 * 
 *		default; //if조건문에서 else와 같은 의미
 *		System.out.println("try Again ");
 *		(break;)
 * }//
 * 
 * 
 */
public class ifGradeTest1 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 시험성적을 입력하세요>>>");
		
		int score = sc.nextInt();
		
		if(score<100 && score>=90) {
			System.out.println("A grade...");
	    }else if (score<90 && score >=80) {
	   		System.out.println("B grade...");
	    }else if (score<80 && score >=70) {
	   		System.out.println("C grade...");
	    }else if (score<60 && score >=50) {
	   		System.out.println("D grade...");
	    }else {
	   		System.out.println("Try Again....");
	   	
	   		//if(score<100 && score>=90)
				//System.out.println("A grade...");
		    //else if (score<90 && score >=80) 
		   		//System.out.println("B grade...");
		    //else if (score<80 && score >=70) 
		   		//System.out.println("C grade...");
		   // else if (score<60 && score >=50) 
		   		//System.out.println("D grade...");
		    //else 
		   		//System.out.println("Try Again....");	
	   		//--->statement가 한줄일 때는 '{','}' 생략가능하다
	   	
	    }
	}

}
