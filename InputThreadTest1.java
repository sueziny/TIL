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
