# TIL
Just do it!

package exception.runtime.test;

public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String [] str = {
				"Hello Java",
				"No, I mean it",
				"Nice to meet you"
		};
		
		int i = 0;
		while(i<4) {
			try {
			System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch!");
			}	
			i++;
		}
		System.out.println("The End");
	}

}
-------------------------------------------------------

package exception.runtime.test;

public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		//객체 생성하지 않고 참조변수로 접근할 때 발생하는 예외
		System.out.println("===========NullPointerException===========");
		String str = "Encore";
		String str1 = new String("Encore");
		str1 = null; //객체생성을 하지 않은 것과 동일한 결과가 발생..
		try {
		System.out.println("문자열 길이를 반환합니다."+str1.length());
		System.out.println("toSring() 스트링에서는 오버라이딩 되어져 있다 "+ str1.toString());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Nice Catch!...1");
		//}catch(NullPointerException e1) {
		//	System.out.println("Nice Catch!..2");
		}finally {//위와 상관없이(예외가 발생하건 말건, 예외를 잡건 말건) 무조건 이 부분은 수행된다...
				System.out.println("Always print...");//이 부분에 들어갈 코드를 나중에 설명
		}
	}
}
----------------------------------------------------------------

package exception.runtime.test;

public class RuntimeExceptionTest3 {

	public static void main(String[] args) {
		String [] str = {
				"Hello Java",
				"No, I mean it",
				"Nice to meet you"
		};
		
		int i = 0;
		while(i<4) {
			try {
			System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {//Exception e 로도 잡을 수 있다..(부모이기 때문에)
				System.out.println("Nice Catch!");
			}catch(Exception e) {//이미 앞에서 처리했기 때문에 출력되지 않는다.
				System.out.println("Nice Catch!..2");
			}		
			i++;
		}
		System.out.println("The End");
	}

}
--------------------------------------------------------------------------

package exception.runtime.test;
/*
 * 예외를 처리하는 방	법 2번째 ...throws사용해본다.
 */

class Throws {
	//go() 수행하던 중 예외가 발생...그걸 던지니 ..go()를 호출한 곳에서 예외처리를 직접 하세요
	public void go() throws ArithmeticException{
		int i = 10;
		int j = 0;
		System.out.println("2. 0을 분모로 하면 안됩니다");
		if(i/j==0) //예외발생
			System.out.println("ArithmeticException...Boom");
	}
}
public class RuntimeExceptionTest4 {

	public static void main(String[] args) {
		
		Throws t = new Throws();
		System.out.println("1. go() calling...");
		try {
			t.go();// 문제지점호출
		}catch(ArithmeticException e) {
			System.out.println("3.호출한 지점에서 예외를 잡았습니다.");
		}
	}

}

