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






















