# TIL
Just do it!


package poly.vo;
//Super Class...
public class Employee {
	String empId;
	String name;
	String addr;
	int salary;
	
	public Employee() {	}
	
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
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", addr=" + addr
				+ ", salary=" + salary + "]";
	}		
}
------------------------------------------------------------------------------

package poly.vo;

public class Engineer extends Employee{
	String tech;
	int bonus;
	
	public Engineer(String empId, String name, String addr, int salary,String tech, int bonus) {
		super(empId,name,addr,salary);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	public String getTech() {
		return tech;
	}

	public int getBonus() {
		return bonus;
	}
	
	

	public void changeTech(String tech) {
		this.tech = tech;
	}

	public void changeBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString()+" Engineer [tech=" + tech + ", bonus=" + bonus + "]";
	}	
}

---------------------------------------------------------------------------

package poly.vo;

public class Manager extends Employee{
	
	String dept;

	public Manager(String empId, String name, String addr, int salary,String dept) {
		super(empId,name,addr,salary);
		this.dept = dept;
	}
	
	
	public String getDept() {
		return dept;
	}


	public void changeDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return super.toString()+" Manager [dept=" + dept + "]";
	}	
}
--------------------------------------------------------------------------------

package poly.service;

import poly.vo.Employee;
import poly.vo.Engineer;

/*
 * 1. Service 클래스는 Employee(부모)[ ], Employee 을 hasing.
 * 2. 부모타입의 배열객체를 가지게되면 배열에 담긴 여러개의 자식객체들을 관리할수 있따....
 *    단일한 기능으로 ...즉, 부모클래스의 기능이다.
 * 3. Polymorphic Argument
 */
public class EmployeeService {
	
//	public void changeEmployee(Employee[ ] ea, Employee e, String str) {
//		
//	}
	 static private EmployeeService service = new EmployeeService();
	 private EmployeeService() {}
	 public static EmployeeService getInstance() {
		 return service;
	 }
	//0.
	public void printInfo(Employee e){
		System.out.println(e);
	}
	
	//1. 모든 Employee[ ]안에 들어있는 객체 정보들을 출력
	public void printAllInfo(Employee[ ] ea){
		for(int i=0; i<ea.length; i++){
			System.out.println(ea[i]);
		}
	}
	
	//2.테스트 클래스에서 넘겨받은 empId의 값과 일치하는 객체를 리턴하는 기능
	public Employee findByEmpId(Employee[ ] ea, String empId){
		Employee emp = null;
		
		for(int i=0; i<ea.length; i++){
			if(ea[i].getEmpId().equals(empId)){
				emp=ea[i];
				break;
			}
		}
		return emp;
	}
	
	//3. 테스트 클래스에서 넘겨받은  addr값과 일치하는 Employee 타입의 객체를 리턴받음
	//같은 주소를 가진 사람의 count를 함께 알아낸다.
	/*public Employee[ ] findByAddress(Employee[ ] ea, String addr){
		Employee[ ] emp = new Employee[ea.length];
		int count = 0;
		
		for(int i=0; i<ea.length;i++){
			if(ea[i].getAddr().equals(addr)){ //2,3
				emp[ count ] = ea[i];
				count++;
			}
		}		
		return emp;
	}*/
	//test에서 continue를 사용하는 방법....count사용 하지 않고
	public Employee[ ] findByAddress(Employee[ ] ea, String addr){
		Employee[ ] emp = new Employee[ea.length];
		for(int i=0; i<emp.length; i++){
			if(ea[i].getAddr().equals(addr)){
				emp[i] = ea[i];
			}
		}
		return emp;
	}
	
	//4. 특정한 Employee의 연봉을 리턴하는 기능...Engineer일때는 보너스 까지 생각
	public int getAnnualSalary(Employee e){
		int annualSalary = 0;
		
		annualSalary = e.getSalary()*12;
		
		if(e instanceof Engineer){
			Engineer eg = (Engineer)e;
			annualSalary =eg.getSalary()*12+eg.getBonus();
		}
		return annualSalary;
	}
	
	//5. 연간 총 인건비의 총액을 리턴하는 기능
	public int getTotalCost(Employee[ ] ea){
		int totalCost = 0;
		for(int i=0; i<ea.length; i++){
			totalCost += getAnnualSalary(ea[i]);
		}
		return totalCost;
		
	}
	
}

-------------------------------------------------------------------------

package poly.test;

import poly.service.EmployeeService;
import poly.vo.Employee;
import poly.vo.Engineer;
import poly.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		Employee e = new Employee("e123", "aaa", "상일동", 450);
		Manager m = new Manager("m667", "bbb", "천호동", 320, "개발부");
		Engineer eg = new Engineer("eg334", "ccc", "일산", 100, "JAVA", 500);
		Engineer eg1 = new Engineer("eg155", "ddd", "일산", 400, "JQuery", 50);
		
		//EmployeeService service = new EmployeeService();
		
		System.out.println("***** 0.printInfo calling *******");
		EmployeeService.getInstance().printInfo(e);
		EmployeeService.getInstance().printInfo(m);
		
		System.out.println("\n*****1. printAllInfo calling *******");
		Employee[ ] arr = {e,m,eg,eg1};
		EmployeeService.getInstance().printAllInfo(arr);
		
		
		System.out.println("\n*****2. findByEmpId calling *******");
		Employee emp=EmployeeService.getInstance().findByEmpId(arr, "e123");
		System.out.println(emp); 
		
		
		System.out.println("\n*****3. findByAddress calling *******");
		Employee[ ] empArr=EmployeeService.getInstance().findByAddress(arr, "일산");
		
		for(int i=0; i<empArr.length; i++){
			if(empArr[i]==null)
				
				continue; 
			System.out.println(empArr[i].getAddr()+" "+empArr[i].getName());
		}
		
		
		System.out.println("\n*****4. getAnnualSalary calling *******");
		System.out.println("Anuual Salary :: "+EmployeeService.getInstance().getAnnualSalary(e));
		System.out.println("Anuual Salary :: "+EmployeeService.getInstance().getAnnualSalary(eg1));
		
		
		System.out.println("\n*****5. getTotalCost calling *******");
		System.out.println("[모든 고용인들의 연간 총 인건비는 ::]"
									+EmployeeService.getInstance().getTotalCost(arr));
		
	}
}

-------------------------------------------------------------------------------------------------

package poly.test;

class EncoreCompany{
	private String companyName;
	
	//1.static private으로 객체 생성
	static private EncoreCompany encore = new EncoreCompany();
	
	//2. 다른 곳에서는 객체생성 못함.
	 private EncoreCompany() {
		companyName = "encore";
		System.out.println("company Name...."+ companyName );
	}
	//3.만들어 놓은 객체를 다른 곳에서 가져다 쓸 수 있도록 기능을 하나 만들어 놓는다....public static으로 
	public static EncoreCompany getCompany() {
		return encore;
	}
}
public class SingletoneTest {

	public static void main(String[] args) {
		
		//EncoreCompany e = new EncoreCompany();
		
		EncoreCompany encore1 = EncoreCompany.getCompany();	
		EncoreCompany encore2 = EncoreCompany.getCompany();
		EncoreCompany encore3 = EncoreCompany.getCompany();
		
		System.out.println(encore1);
		System.out.println(encore2);
		System.out.println(encore3);
	}

}



