package test;

public class OperatorTest1 {

	public static void main(String[] args) {
		
		int i = 5; //반드시 초기화하고 사용해야 한다. 얘는 기본값이 없어서 초기화 안하고 쓰면 에러!
		int j = 3;
		
		Operator o1 = new Operator();//주소값 1000 (가정)
		Operator o2 = new Operator();//주소값 2000
		
		//==(same)
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o1==o2); //false
		System.out.println(o1!=o2); //true
		o1=o2; // =(assign)
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o1==o2);//true
		System.out.println(i != j);//true
		//%...modulus (나눴을 때의 나머지)
		System.out.println("연산자 % :: "+i%j); //2
		System.out.println(i == j);//false
		System.out.println("====================");
		System.out.println(i != j);//true 
		
		//++(1씩 증가), --(1씩 감소)
		int k = 10;
		System.out.println(k++);// 10--->1이 나중에 증가
		System.out.println(k); //11
		
		int m = 10;
		System.out.println(++m); //11--->1이 먼저 증가
		System.out.println(m);//11
		
		//논리 연산자
		System.out.println(o1.test1() | o1.test2());// or --->true / 둘다 수행하고 결과 도출
		System.out.println("================================");
		System.out.println(o1.test2() & o1.test1());// AND --->false
		System.out.println("================================");
		
		//Short circuit (지름길)
		//장점 : 속도가 빨라진다 (but, 사실 크게 속도 차이없음) 
		//진짜 장점은 문제 상황을 건너뛴다는 것!! 앞에서 결론이 나왔으면 뒤를 실행하지 않는다면 뒤에 버그나 에러가 있어도 시스템에 문제가 생기지 않기 때문에 
		System.out.println(o1.test1() || o1.test2());// true 앞만 수행해서 결과가 나오면 뒤에는 수행하지 않음.
		System.out.println("================================");
		System.out.println(o1.test2() && o1.test1());// false
		
	
	}//main

}//class

class Operator{
	public boolean test1() {
		System.out.println("test1() Calling...");
		return true;
		
	}
	public boolean test2() {
		System.out.println("test2() Calling...");
		return false;
	}
}
