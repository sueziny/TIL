package com.encore.cons.test;

import com.encore.cons.Programmer2;
import com.encore.util.MyDate;

public class ProgrammerTest2 {

	public static void main(String[] args) { 
		// 1.객체 생성 --> 메모리 할당 / Programmer의 식구들을 메모리에 올린다.
		// 2.메소드 호출-->
		// 3.개발자의 정보가 콘솔창에 출력되도록 작성
		// birthday의 정보가 1980-1-1
	Programmer2 pro = new Programmer2();
	Programmer2 pro1 = new Programmer2();
	
	MyDate md = new MyDate();
	md.setDate(1980, 1, 1);

	pro.setProgrammer("James",md, 300000.0F, 10000);//필드에 값을 주입
	System.out.println(pro.getProgrammer());//주입된 값을 받아옴(Calling)
	
	pro1.setProgrammer("Peter",md, 400000.0F, 20000);//필드에 값을 주입
	System.out.println(pro1.getProgrammer());//주입된 값을 받아옴(Calling)
	
	pro = pro1;
	
	System.out.println(pro.getProgrammer());//주입된 값을 받아옴(Calling)
	System.out.println(pro1.getProgrammer());//주입된 값을 받아옴(Calling)
	
	}

}
