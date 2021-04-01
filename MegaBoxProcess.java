package thread.step6.test;

public class MegaBoxProcess {

	public static void main(String[] args) {
		MegaBoxUser user = new MegaBoxUser();
		Thread user1 = new Thread(user, "¿øºó");
		Thread user2 = new Thread(user, "ÀÌ³ª¿µ");
		
		user1.start();
		user2.start();
	}

}
