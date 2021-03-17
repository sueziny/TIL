package com.encore.cons.test;

import com.encore.cons.Programmer;
import com.encore.util.MyDate;

public class ProgrammerTest {

	public static void main(String[] args) {

		// step1
		/*
		 * Programmer pro = new Programmer(); Programmer pro1 = new Programmer();
		 * 
		 * MyDate md = new MyDate(); md.setDate(1980, 1, 1);
		 * 
		 * pro.setProgrammer("James", md, 300000.0F, 10000);//필드에 값을 주입
		 * pro1.setProgrammer("Peter", md, 400000.0F, 20000);//필드에 값을 주입
		 * 
		 * pro = pro1;
		 * 
		 * System.out.println(pro.getProgrammer());//주입된 값을 받아옴
		 * System.out.println(pro1.getProgrammer());
		 */

		// step2
		/*
		 * 1. pro1, pro2객체를 생성... 2. 생성자를 이용해서 필드에 직접 값을 할당한다.
		 * 
		 * 3. 필드 정보를 콘솔창으로 출력..
		 * 
		 * 4. Peter의 연봉은 450000.0달러 입니다. 출력이 되도록 로직을 완성하세요
		 * 
		 * 
		 */
		MyDate md = new MyDate();
		
		md.setDate(1980, 1, 1);

		Programmer pro1 = new Programmer("James", md, 300000.0F, 10000);
		Programmer pro2 = new Programmer("Peter", md, 450000.0F, 20000);

		System.out.println(pro1.getProgrammer());
		System.out.println(pro2.getProgrammer());

		System.out.println("\n========================\n");

		System.out.println(pro1.getName() + "님의 연봉은 " + pro1.getIncome() + "달러입니다!!");
		System.out.println(pro2.getIncome());

	}

}
