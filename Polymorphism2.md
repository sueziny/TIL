# TIL
Just do it!

package com.encore.util;

public class MyDate {

	private int year;
	private int month;
	private int day;
	
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	
    public String getDate() {
    	return year +"-"+ month +"-"+day;
   }
	
	
}

---------------------------------------------------------
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


--------------------------------------------------------------------------------------------------
package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee {
	
	private String tech;
	private int bonus;
	
	public Engineer(String name, MyDate birthDay, double salary, String tech, int bonus ) {//자식이 생성되려할때...
		//부모 기본 생성자 호출이 여기서 무조건 일어난다....super();
		super(name, birthDay, salary);
		this.tech=tech;
		this.bonus=bonus;
	}
	
	public String getDetails() {
		return super.getDetails() +","+tech;
	}

	//기능 추가
	public void changeTech(String tech) {
		this.tech = tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getTech() {
		return tech;
	}

	public int getBonus() {
		return bonus;
	}
	
	
	
}
-----------------------------------------------------

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
	//Manager 클래스만의 기능을 추가

	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
-----------------------------------------------------------------------------------------

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

	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}
	
	
	
}

-------------------------------------------------------------------------------------

package com.encore.service;

import com.encore.child.Engineer;
import com.encore.parent.Employee;

/*
 * 상속관계에 있는 다양한 subclass들을 핸들링하는 기능만으로 이루어진 서비스 클래스.
 * 
 */
public class EmployeeService {
	/*
	 * 1step
	 * ::
	 * public void manageManager(Manager m){}
	 * public void manageEngineer(Engineer eg){}
	 * public void manageSecretary(Secretary s){}
	 * 
	 * 2step------Overloading
	 * "메소드 이름은 같고
	 * 처리하는 데이터를 달리하는 기법"
	 * ::
	 * << Rule >>
	 * 0.하나의 클래스에서만 적용되는 기법
	 * 1.메소드 이름은 반드시 같아야 한다.
	 * 2.메소드 인자값은 반드시 달라야 한다.
	 * 3.메소드 리턴타입은??...상관없다.
	 * ::
	 * public void manageEmployee(Manager m){}
	 * public void manageEmployee(Engineer eg){}
	 * public void manageEmployee(Secretary s){}
	 * 
	 * 3step
	 * public void manageEmployee(Employee e){}
	 * 
	 */
	
	public void manageEmployee(Employee e) {
		if(e.getName().equals("Peter")) {
			System.out.println(e.getDetails());
		}
		if(e instanceof Engineer) {
			System.out.println("연봉 :: "+(e.getSalary()*12+((Engineer) e).getBonus()));
		}
	}
	public void printAllEmployee(Employee[] emps) {
		for(Employee e:emps)
			System.out.println(e.getDetails());
	}
	
}
---------------------------------------------------------------------
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
----------------------------------------------------------------

package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.service.EmployeeService;
import com.encore.util.MyDate;

/*
 * Collection
 * 1. Homogeneous Collection (동종간의 집합체)
 * 2. Heterogeneous Collection(이기종간의 집합체)
 */
public class PolymorphismTest_sample {

	public static void main(String[] args) {
		//1. 부모타입으로 자식생성

		Employee e1 = new Manager("Robert", new MyDate(1981,4,2), 33000.0, "IT");
		Employee e2 = new Engineer("Peter", new MyDate(1981,4,2), 33000.0, "IT",200);
		Employee e3 = new Secretary("Gosling", new MyDate(1981,4,2), 34000.0, "Robert");
		Employee e4 = new Manager("강호동", new MyDate(1981,4,2), 33000.0, "연예부");
		
		//2. 부모타입의 배열에 초기화
		Employee[] emps = {e1, e2, e3, e4};
		
		//3. 서비스 클래스 생성
		EmployeeService service = new EmployeeService();
		
		service.manageEmployee(e4);
		service.manageEmployee(e2);
		
		service.printAllEmployee(emps);
	}//main
			
}//class



