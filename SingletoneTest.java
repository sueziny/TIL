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
