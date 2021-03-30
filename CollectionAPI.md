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

	
    @Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}


//	public String getDate() {
//    	return year +"-"+ month +"-"+day;
//   }
	
	
}


-----------------------------------------------------------
package com.encore.vo;

public class Employee {
	public static final int BASIC_SALARY  = 100;
	public static final String BASIC_NAME = "홍길동";
	private String empId;
	private String name;
	private String addr;
	private int salary;
	
	public Employee(String empId, String addr) {
		this(empId, BASIC_NAME, addr, BASIC_SALARY);
	}
	
	public Employee(String empId, String name, String addr, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.addr = addr;
		this.salary = salary;
	}

	public String getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public int getSalary() {
		return salary;
	}
	
	

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", addr=" + addr + ", salary=" + salary + "]";
	}
	
	
	
}

-----------------------------------------------------------------------------------------------

package com.encore.vo;

public class Engineer extends Employee {

	private String tech;
	private int bonus;
	


	public Engineer(String empId, String addr) {
		super(empId, addr);
	}

	public Engineer(String empId, String name, String addr, int salary, String tech, int bonus) {
		super(empId, name, addr, salary);
		this.tech=tech;
		this.bonus=bonus;
	}

	public String getTech() {
		return tech;
	}

	public int getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return super.toString()+"Engineer [tech=" + tech + ", bonus=" + bonus + "]";
	}
	
	public void changeBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public void changeTech(String tech) {
		this.tech=tech;
	}
}
----------------------------------------------------------

package com.encore.vo;

public class Manager extends Employee {

	private String dept;

	
	public Manager(String empId, String name, String addr, int salary, String dept) {
		super(empId, name, addr, salary);
		this.dept= dept;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return super.toString()+ "Manager [dept=" + dept + "]";
	}


	public void changeDept(String dept) {
		this.dept=dept;
	}

	
	
}

-------------------------------------------------------
package com.encore.service;

import java.util.ArrayList;

import com.encore.vo.Employee;

//기능의 Template을 모아놓은 인터페이스....

public interface EmployeeListService {

	void addEmployee(Employee e);//public abstract가 생략
	void deleteEmployee(String empId);
	void updateEmployee(Employee e);
	
	//메소드오버로딩
	ArrayList<Employee> findByEmployees(String addr);
	void findByEmployees();
	
}

----------------------------------------------------------------------
package com.encore.service.impl;

import java.util.ArrayList;

import com.encore.service.EmployeeListService;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

/*
 * 1. 인터페이스를 상속 받아서 정의
 * 2. 싱글톤
 * 
 */
public class EmployeeListServiceImpl implements EmployeeListService {
	
	//추가
	private ArrayList<Employee> list;

	private static EmployeeListServiceImpl service = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() {
		list = new ArrayList<Employee>();
	}
	public static EmployeeListServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) {
		boolean find = false;//flag 값 하나 선언
		for(Employee emp: list) {
			if(emp.getEmpId().equals(e.getEmpId())) {
					find = true;
					System.out.println(e.getName()+"님은 이미 회원 명단에 가입되어 있습니다.");
					return;
			}
		}
		if(find == false) {
			list.add(e);
			System.out.println(e.getName()+"님이 회원으로 가입되셨습니다.");
		}
	}

	@Override
	public void deleteEmployee(String empId) {
		boolean find = false;//flag 값 하나 선언
		for(Employee emp: list) {
			if(emp.getEmpId().equals(empId)) {
					find = true;
					System.out.println(emp.getName()+"님을 삭제합니다.");
					list.remove(emp);
					break;
			}
		}
		if(find == false) System.out.println("삭제하려는 대상이 현재 회원 중에 존재하지 않습니다.");
	}

	@Override
	public void updateEmployee(Employee e) {
		boolean find = false;
		for(Employee emp : list) {
			if(e.getEmpId().equals(emp.getEmpId())) {
				//emp.setEmpId(null);//pk에 해당하는 값은 수정의 대상이 되면 안된다...pk를 제외한 나머지 정보들이 수정의 대상
				emp.setName(e.getName());
				emp.setAddr(e.getAddr());
				emp.setSalary(e.getSalary());
				
				if(emp instanceof Manager) {
					((Manager) emp).changeDept(((Manager)e).getDept());
				}
				if(emp instanceof Engineer) {
					((Engineer) emp).changeBonus(((Engineer)e).getBonus());
					((Engineer) emp).changeTech(((Engineer)e).getTech());
				}
			}	
		}
		
	}

	@Override
	public ArrayList<Employee> findByEmployees(String addr) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		for(Employee emp : list) {
			if(emp.getAddr().equals(addr)) temp.add(emp);
		}
		return temp;
	}

	@Override
	public void findByEmployees() {
		for(Employee e : list) System.out.println(e);
		
	}
	
}
-------------------------------------------------------------

package com.encore.test;

import com.encore.service.impl.EmployeeListServiceImpl;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeListServiceTest1 {

	public static void main(String[] args) {
		//1. Service 생성된 객체를 하나 받아온다..
				EmployeeListServiceImpl service = EmployeeListServiceImpl.getInstance();
				
				//2. method를 각각 호출..
				System.out.println("======================== 1. add ================================== ");
				Manager m1 = new Manager("111", "강호동", "방배동", 500, "개발부");
				Manager m2 =new Manager("222", "이수근", "여의동", 400, "기획부");
				Manager m3 =new Manager("333","서장훈","방배동", 600, "개발부");
				
				Engineer eg1 = new Engineer("444","김희철", "신대방동", 450, "총무부", 20);
				Engineer eg2 =new Engineer("555","이상민", "논현동", 350, "Java", 30);
				
				service.addEmployee(m1);
				service.addEmployee(m2);
				
				service.addEmployee(m3);
				service.addEmployee(eg1);
				service.addEmployee(eg2);
				//service.addEmployee(m3);
				
				service.findByEmployees();
				
				System.out.println("======================== 2. delete ================================== ");
				service.deleteEmployee("서장훈");
				
				service.findByEmployees("서초동");
			
				System.out.println("========================");


	}

}
