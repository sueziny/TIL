package greet.test;

import greet.MyGreet;

/*
 * MyGreet 클래스의 메소드를 동작시키는 실행 클래스...Test 클래스
 */
public class MyGreetTest {
	public static void main(String[] args) {
		//객체를 생성
		/*
		 * 메모리에 mg라는 이름으로 올라간다...
		 * 클래스의 식구들이 올라간다.
		 * 2개...필드, 메소드
		 * 메모리를 올리는 이유(객체 생성하는 이유)??
		 * 메모리 올라간 애들만 접근해서 사용할 수 있다.
		 */
		MyGreet mg = new MyGreet(); 
		mg.sayHello("정은총");//method calling
		
	}
}

// JVM에서는 main메소드를 제일 먼저 찾음
