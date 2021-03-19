package com.encore.capsulation;

import java.util.Scanner;

public class MyDateTest {

	public static void main(String[] args) {
		
		/*
		 * Scanner sc = new Scanner(System.in); System.out.println("날짜를 입력하세요"); int
		 * Month = sc.nextInt(); int Day = sc.nextInt();
		 * 
		 * MyDate md = new MyDate(); md.setMonth(Month); md.setDay(Day);
		 * 
		 * int Month = sc.nextInt(); int Day = sc.nextInt();
		 * 
		 * 
		 * if(1 <= md.getMonth() & md.getMonth() <= 12) {
		 * 
		 * System.out.println(md.getMonth());
		 * 
		 * }else if(12<md.getMonth()) { System.out.println("다시 입력해주세요"); }
		 * 
		 * switch(md.getMonth()) { case 1: case 3: case 5: case 7: case 8: case 10: case
		 * 12: if(1 <= md.getDay() & md.getDay() <= 31) {
		 * 
		 * System.out.println(md.getMonth()+"월"+md.getDay()+"일");
		 * 
		 * }else { System.out.println("잘못입력하셨습니다."); } break;
		 * 
		 * case 2: if(1 <= md.getDay() & md.getDay() <= 28) {
		 * 
		 * System.out.println(md.getMonth()+"월"+md.getDay()+"일");
		 * 
		 * }else { System.out.println("잘못입력하셨습니다."); } break;
		 * 
		 * case 4: case 6: case 9: case 11: if(1 <= md.getDay() & md.getDay() <= 30) {
		 * 
		 * System.out.println(md.getMonth()+"월"+md.getDay()+"일");
		 * 
		 * }else { System.out.println("잘못입력하셨습니다."); } break;
		 * 
		 * default: System.out.println("잘못입력하셨습니다.");
		 * 
		 * }
		 */
		Scanner sc = new Scanner(System.in); 
		System.out.println("날짜를 입력하세요");
		int Month = sc.nextInt(); 
		int Day = sc.nextInt();
		 
		 MyDate md = new MyDate(); 
		 System.out.println(md);
		 
		 md.setMonth(Month); 
		 md.setDay(Day);
		
	
	System.out.println("오늘은"+ md.getMonth()+"월"+md.getDay()+"일");
	
	}

}
