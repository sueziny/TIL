package thread.step3.test;
/*Thread
 * 1) main 쓰레드...데몬 쓰레드...O
 * 2) 작업 쓰레드...X
 * 
 * 해당 코드에서는 별도의 쓰레드 클래스를 작성하지 않을 것이다.
 * main 쓰레드 (데몬 쓰레드)만 실행되는 Process 코드를 작성할 것이다.
 * --> Single Thread...
 * 
 * Beep(경고음 발생) 발생 + 경고음을 콘솔창으로 출력
 */

import java.awt.Toolkit;
/*
 * Thread
 * 1)main 쓰레드 ...데몬 쓰레드 ...O
 * 2)작업 쓰레드 ...X
 * 
 * 해당 코드에서는 
 * 경고음을 울리는 작업과
 * 동시에 
 * 경고음을 출력하는 작업을 병행해서 처리하도록 로직을 작성
 * -->
 * 이것을 해결하는 방법
 * 경고음을 출력하는 작업을 스레드로 만들어야 한다.
 * BeepPrintThread를 하나 작성
 * BeepPrintTest2에서 동시 작업이 될 수 있도록 로직을 완성..
 */

class BeepPrintThread extends Thread{
	
	Toolkit tool = Toolkit.getDefaultToolkit();
	
	public void run() {
		for(int i=0; i<5; i++) {
			tool.beep(); 
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
		
			}
		}
	}
}
public class BeepPrintTest2 {

	public static void main(String[] args) {
		
		BeepPrintThread beep = new BeepPrintThread();
		beep.start();
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		//경고음이 5번 울리는 작업...
		for(int i=0; i<5; i++) {
			tool.beep(); 
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
		
			}
		}
	}
}
