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

public class BeepPrintTest1 {

	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		//경고음이 5번 울리는 작업...
		for(int i=0; i<5; i++) {
		tool.beep(); 
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
		
		}
	}
		for(int i=0; i<5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
			
			}
	}

	}
}
