# TIL
Just do it!

/*
 * =====static한 키워드 성질=====
 *1. 객체생성 과정 없이 메모리에 올라간다.
 *2. 객체생성 과정 훨씬 이전에 메모리에 올라간다....class File Loader(실행의 가장 첫 단계)과정에서..
 *		JVM(STACK|HEAP(new라는 키워드로 생성된 객체만 올라간다.|....Class Area(static한 성질들의 멤버))
 *3. static한 성질의 필드는 생성된 객체들에서 서로 공유한다..
 *4. static은  static끼리 통한다.
 *5. static(객체생성과 상관없음) 블락 안에서 this(객체 자체를 가리킴)사용 못한다.
 *6. static과 final은 성질상 종종 함께 사용된다.
 *   ex)상수값 선언  static final int BASIC_SALARY=100;
 *7. static initialization block
 *8. 실글톤
 *
 */

package exam.test;

class Member{
	//필드 레벨에 static 변수를 선언(local level로는 사용할 수 없다.)
	static String name = "홍길동";
	static int age = 22;
	
	int count = 1;//필드
	
	
	//static block
	public static void getMember() { //static block
		System.out.println("우/유/빛/깔"+name); //static variable
		//System.out.println("우/유/빛/깔"+count);//위 4번에 대한 내용
	}
	//non-static block
	public void getMember2() { //static block
		System.out.println("우/유/빛/깔"+name); //static variable
		System.out.println("우/유/빛/깔"+count);//위 4번에 대한 내용
	}
}

public class StaticExamTest {

	public static void main(String[] args) {
		//static한 성질의 기능은 바로 접근해서 사용할 수 있다....Class 이름.static메소드
		Member.getMember();
		//
		Member m = new Member();
		m.getMember();
		m.getMember2();
	}

}

-----------------------------------------------------------------------------------

package exam.test;

class Car{
	int serialNumber;//field
	static int counter;//static
	// 둘다 기본값은 0
	
	Car(){
		counter++;
		serialNumber=counter;
	}
	
	
}
public class StaticExamTest2 {

	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		
		System.out.println("==========field==========");
		System.out.println(c1.serialNumber);//1
		System.out.println(c2.serialNumber);//2
		System.out.println(c3.serialNumber);//3
		
		System.out.println("=========static variable========");
		System.out.println(c1.counter);//3
		System.out.println(c2.counter);//3
		System.out.println(c3.counter);//3
		
	}

}
----------------------------------------------------------------------------

package exam.test;
//static initialization block...
//초기화...
public class StaticExamTest3 {
	static int i =0 ;
	public static void main(String[] args) {
		//실질적으로 이 부분이 가장 먼저 실행된다---> 여기에다가 초기화 알고리즘 넣는다..
		//객체생성 ...();...생성자 호출...필드 초기화
		
		System.out.println("1. main method static block..."+i);

	}//main

	static {
		i=300;
		System.out.println("2. stinitialization block..."+i);
	}
}

---------------------------------------------------------------------------

package exam.test;
/*
 * Modifier---> Access modifier|Usage Modifier
 * Usage Modifier :: static, final, abstract
 * static + final 주로 함께 많이 쓰인다.
 * 
 * final:: "내가 마지막이야"를 의미하는 키워드
 * final + 변수 --> "내가 마지막 변수야" --->상수지정
 * final + 클래스 --> "내가 마지막 클래스야" ---> 상속금지 (마지막 자식이 되어서 뒤에 자식을 못둔다.)
 * final + 메소드--> "내가 마지막 메소드야" ---> 오버라이딩 금지
 */
class A{
	public final static int BASE_SALARY = 300;  //변수명은 전부 대문자
	public final String test() {
		return "Overriding 금지";
	}
}

final class B{//상속 금지
	
}

//class C extends B{
//	
//}

class D extends A{
//	public final String test() {
//		return "Overriding 금지";
//	}
	
}
public class StaticExamTest4 {

	public static void main(String[] args) {
		
	}

}

