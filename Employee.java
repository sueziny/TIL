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
	
	public double getSalary() {
		return salary;
	}
	public static double getBasicSalary() {
		return BASIC_SALARY;
	}
	public String getName() {
		return name;
	}
	public MyDate getBirthDay() {
		return birthDay;
	}
	
	
	
}
