# TIL
Just do it!


package thread.step7.test;

public class DeadLock1 implements Runnable {

	StringBuffer sb1, sb2;

	public DeadLock1(StringBuffer sb1, StringBuffer sb2) {
		this.sb1 = sb1;
		this.sb2 = sb2;
	}

	public void run() {
		synchronized (sb1) {
			sb1.append("A");
			
			try {
				sb1.wait();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//e1.printStackTrace();
			}
			synchronized (sb2) {
				sb2.append("B");
				System.out.println(sb1);
				System.out.println(sb2);
			}
		}
	}
}
----------------------------------------------


package thread.step7.test;

public class DeadLock2 implements Runnable{

	StringBuffer sb1,sb2;

	public DeadLock2(StringBuffer sb1, StringBuffer sb2){
		this.sb1 = sb1;
		this.sb2 = sb2;
	}

	public void run(){
		synchronized(sb2){ 
			sb2.append("A");
				try{
				Thread.sleep(1000);
				}catch(InterruptedException e){}
				
				synchronized(sb1){
					sb1.notify();
					sb1.append("B");
                    System.out.println(sb1);
                    System.out.println(sb2);
                }
       }
   }			
}


---------------------------------

package thread.step7.test;

public class DeadLockTest {
	public static void main(String[] args){
		final StringBuffer sb1=new StringBuffer();
		final StringBuffer sb2=new StringBuffer();

		DeadLock1 tdt1 = new DeadLock1(sb1,sb2);
		DeadLock2 tdt2 = new DeadLock2(sb1,sb2);

		Thread t1 = new Thread(tdt1);
		Thread t2 = new Thread(tdt2);
		t1.start();
		t2.start();
	}
}


