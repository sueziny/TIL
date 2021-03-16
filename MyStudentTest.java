package sample.test;

import sample.MyStudent;
/*
 * MyGreet 클래스의 메소드를 동작시키는 실행 클래스...Test클래스
 * 1. 클래스 객체를 생성==식구(구성요소)들이 메모리에 올라간다
 * 2. 접근
 *  1)필드--- 값할당
 *  2)메소드---호출(Calling)
 */
public class MyStudentTest {

	public static void main(String[] args) {
		MyStudent ms = new MyStudent(); //1
		//2
		ms.name = "나예지";
		ms.age = 25;
		ms.adress = "서초동";
		//실제 코드값이 실제값이 되면 하드코어 될 수 없음.
		ms.printInfo(); 
	
	}

}
