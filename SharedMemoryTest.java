package thread.step5.test;


class Calculator{
	private int memory;

	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		System.out.println(Thread.currentThread().getName()+" : "+this.memory);
	}
	
	public int getMemory() {
		return memory;
	}
	
}


class UserA extends Thread{
	
	private Calculator calculator;
	
	
	public void setCalculator(Calculator calculator) {
		setName("CalculatorUserA");
		this.calculator = calculator;
	}


	public void run() {
		calculator.setMemory(100);
	}
	
}

class UserB extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {	
		setName("CalculatorUserB");
		this.calculator = calculator;
		}
	
	public void run() {
		calculator.setMemory(50);
	}
}

public class SharedMemoryTest {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		UserA thread1 = new UserA();
		thread1.setCalculator(calculator);
		thread1.start();
		
		UserB thread2 = new UserB();
		thread2.setCalculator(calculator);
		thread2.start();
	}

}
