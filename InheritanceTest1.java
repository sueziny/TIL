package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		
		Employee emp = new Employee("James", new MyDate(1982,3,2), 23000.0 );
		Manager m = new Manager("Robert", new MyDate(1981,4,2), 33000.0, "IT");
		Secretary eg = new Secretary("Gosling", new MyDate(1981,4,2), 33000.0, "java");
		Engineer ss = new Engineer("Peter", new MyDate(1981,4,2), 33000.0, "IT",200);
		//Robert가 부서를 바꾼다...
		m.changeDept("Marketing");
		
		System.out.println(emp.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(ss.getDetails());
		
		//////////////////Polymorphism///////////////////
		////부모타입으로 자식을 생성한다.
		
		System.out.println("\n========Polymorphism===========\n");
		
		Employee e1 = new Manager("Robert", new MyDate(1981,4,2), 33000.0, "IT1");
		Employee e2 = new Engineer("Gosling", new MyDate(1981,4,2), 33000.0, "Python",200);
		Employee e3 = new Secretary("Peter", new MyDate(1981,4,2), 33000.0, "java");
		
		//2. Object Casting 기법 필요...부모 찾으면 안되고 자식변수로 찾아야 한다...자식만의 기능이기 때문에
		((Manager) e1).changeDept("Marketing");
		//Manager m1 = (Manager)e1;
		//m1.changeDept("Marketing";)
		/*1.
		 * Virtual Method(생성된 자식의 메소드) Invocation 원리
		 * 상속관계의 2개의 클래스에서
		 * 메소드 오버라이딩을 했을 때 발생하는 원리
		 * 
		 * compile Time Type 메소드 - 부모의 메소드가 호출
		 * Runtime Type 메소드 - 자식의 메소드 호출
		 */
		System.out.println(e1.getDetails());
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());
	}

}
