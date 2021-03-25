# TIL
Just do it!

package com.encore.parent;

import com.encore.util.MyDate;

/*
 * 자식들의 공통적인 성질을 
 * 일반적인 성질로 가지고 있는 부모 클래스..
 * 
 */
public class Employee {
	//상수값 지정
	public static final double BASIC_SALARY  = 100.0;
	private String name;
	private MyDate birthDay;
	private double salary;
	
	public Employee() {}// 기본 생성자
	public Employee(String name, MyDate birthDay) {
		this(name, birthDay, BASIC_SALARY );
	}
	public Employee(String name, MyDate birthDay, double salary) {
		super();
		this.name = name;
		this.birthDay = birthDay;
		this.salary = salary;
	}
	
	
	//1step. Object가 가지고 있는 기능을 물려 받았다.
	//2step  그걸 자신에게 맞게 고쳐쓴다.
	@Override
	public String toString() {
		return "Employee [name=" + name + ", birthDay=" + birthDay + ", salary=" + salary + "]";
	}
	

	public String getDetails() {
		return name +","+ birthDay.getDate() +","+salary;
	}
	
}

----------------------------------------------------------------------------------
package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee {
	
	public String tech;
	
	public Engineer(String name, MyDate birthDay, double salary, String tech ) {//자식이 생성되려할때...
		//부모 기본 생성자 호출이 여기서 무조건 일어난다....super();
		super(name, birthDay, salary);
		this.tech=tech;
	}
	
	public String getDetails() {
		return super.getDetails() +","+tech;
	}
}
------------------------------------------------------------------------------------

package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

/*
 * 부모 클래스 Employee로부터 모든것을 물려받고
 * 자기자신만의 멤버를 추가하는 자식 클래스...
 * 
 * 생성자 호출----> 객체 생성
 * 
 */
public class Manager extends Employee {
		
	// 자식만의 멤버를 추가
	public String dept;
	/*
	 * 자식 생성자...객체 생성 알고리즘
	 * 자식 생성자{ 첫라인에서 무조건 부모기본생성자 호출이 일어난다. (super();)
	 */
	public Manager(String name, MyDate birthDay, double salary, String dept) {//자식이 생성되려할때...
		//부모 기본 생성자 호출이 여기서 무조건 일어난다....super();
		super(name, birthDay, salary);
		this.dept=dept;
	}
	//Method Overriding
	/*
	 * 상속관계에서만 일어난다.
	 * 1step :부모가 가진 기능을 물려받는다.(부모가 가진 기능을 호출한다)
	 * 2step :그걸 자신에 맞게 고쳐쓴다.
	 * 
	 * Overriding의 Rule
	 * 0. 상속관계의 두 클래스 사이에서 일어난다.
	 * 1. 메소드 선언부는 모두 일치
	 * 2. 구현부는 반드시 달라야 한다.
	 * --> 하는 일이 달라졌음으로 새로운 메소드가 만들어졌다.
	 *     메소드 재정의
	 */
	
	
	public String getDetails() {
		return super.getDetails() +","+dept;
	}
	
}
-------------------------------------------------------------------------

package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Secretary extends Employee{

	public String bossOfName;
	
	public Secretary(String name, MyDate birthDay, double salary, String bossOfName) {//자식이 생성되려할때...
		//부모 기본 생성자 호출이 여기서 무조건 일어난다....super();
		super(name, birthDay, salary);
		this.bossOfName=bossOfName;
	}
	
	public String getDetails() {
		return super.getDetails() +","+bossOfName;
	}
}


