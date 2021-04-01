# TIL
Just do it!


package thread.step4.test;

import javax.swing.JOptionPane;

/*
 * 메인 쓰레드만 가동되는 로직을 작성
 * 동시작업(병렬적인 작업)처리가 안된다.
 * 
 * 로또 번호를 입력받는 작업
 * 		+
 * 카운팅을 하는 작업
 * --> 10초 안에 최종적으로 로또번호를 입력!!
 * 
 */
public class InputThreadTest1 {

	public static void main(String[] args) {
		//1. 데이터 입력...작업..GUI
		String input = JOptionPane.showInputDialog("최종 로또 번호 마지막 자리 숫자를 입력하세요");
		System.out.println("입력한 숫자는 " + input + " 입니다");
		
		//2. 일종의 카운팅 작업...10,9,8,7,6,.....1
		for(int i=10; i>=1; i--) {
			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				
			}
			System.out.println(i);
		}
		

	}

}
------------------------------------------

package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * 작업쓰레드를 사용
 * 
 * 로또번호 입력 작업과 동시에 
 * 카운팅 작업이 진행되도록 로직을 작성
 * 
 * 방법
 * ::
 * 작업쓰레드를 하나 추가한다.
 * CountingThread를 새롭게 하나 정의
 * --> 로또번호 입력과 Counting작업이 병렬적으로 처리되도록 로직을 완성...
 * 
 */
class CountingThread implements Runnable{
	public void run() {
		for(int i=10; i>=1; i--) {
			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				
			}
			System.out.println(i);
		}
	}
}
public class InputThreadTest2 {

	public static void main(String[] args) {
		
		CountingThread ct = new CountingThread ();
		Thread t = new Thread(ct);
		
		t.start();
		
		//1. 데이터 입력...작업..GUI
		String input = JOptionPane.showInputDialog("최종 로또 번호 마지막 자리 숫자를 입력하세요");
		System.out.println("입력한 숫자는 " + input + " 입니다");
		
	

	}

}
------------------------------------------------------------------------------

package thread.step4.test;

import javax.swing.JOptionPane;

/*
 * 카운팅작업 - CountThread
 * 숫자입력작업 - LottoInputThread
 * ::
 * 두개의 쓰레드가 Process안에서 서로 리소스를 공유하면서 도는 상황을 로직으로 작성
 * 카운팅되는 상황을 서로 공유하도록 로직을 작성
 * ::
 * 1.카운트가 다 끝나도록 숫자입력이 안되면 - 해당 프로그램을 종료
 * 2.카운트 진행 도중에 숫자가 입력되면 - 더이상 카운팅을 진행하지 않도록 한다
 * ---> 위 2가지 요구사항이 충족되도록 로직을 완성하시기 바랍니다.
 * 
 */

class CountThread extends Thread {
	 InputThreadTest3 process;
	 
	public CountThread(InputThreadTest3 process) {
		super();
		this.process = process;
	}

	public void run() {
		for(int i=10; i>=1; i--) {
			if(process.inputCheck) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
		if(!process.inputCheck) {
			System.out.println("10초가 경과되었습니다...값 입력시간 초과!!");
			System.exit(0);
		}
	}
}
class LottoInputThrea extends Thread{
	
	 InputThreadTest3 process;
	 
		public LottoInputThrea(InputThreadTest3 process) {
			super();
			this.process = process;
		}
	
	public void run() {
		String input = JOptionPane.showInputDialog("최종 로또 번호 마지막 자리 숫자를 입력하세요");
		System.out.println("입력한 숫자는 " + input + " 입니다");
		
		process.inputCheck = true;
	}
}

public class InputThreadTest3 {
//필드...Date ...Resource..Thread가 공유
	boolean inputCheck = false;
	
	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		
		CountThread ct = new CountThread (process);
		LottoInputThrea input = new LottoInputThrea(process);
				
		ct.start();
		input.start();
		
	}

}
------------------------------------------------------------------------



